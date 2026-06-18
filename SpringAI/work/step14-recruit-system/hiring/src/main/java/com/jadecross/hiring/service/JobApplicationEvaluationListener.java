package com.jadecross.hiring.service;

import com.jadecross.hiring.client.HiringAdvisorClient;
import com.jadecross.hiring.client.JobClient;
import com.jadecross.hiring.dto.JobApplicationSubmittedEvent;
import com.jadecross.hiring.mapper.EntityDtoMapper;
import com.jadecross.hiring.repoistory.JobApplicationRepository;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class JobApplicationEvaluationListener {

    private final JobClient jobClient;
    private final HiringAdvisorClient advisorClient;
    private final JobApplicationRepository repository;

    public JobApplicationEvaluationListener(JobClient jobClient, HiringAdvisorClient advisorClient, JobApplicationRepository repository) {
        this.jobClient = jobClient;
        this.advisorClient = advisorClient;
        this.repository = repository;
    }

    @Async
    @TransactionalEventListener //서비스에서 우선 들어온 정보로 데이터를 저장한 다음에 이벤트가 발생, publishEvent가 호출됐을때 여기로 온다.
    public void handle(JobApplicationSubmittedEvent event){
        //event.applicationId()는 등록된 이력서 Id
        System.out.println("event.applicationId() = "+ event.applicationId());

        //아래 문장 실행결과에는 jobApplication, 평가, 평가 이유가 없는 상태
        var jobApplication = this.repository.findById(event.applicationId()).orElseThrow();

        //jobApplication.getJobId()는 채용공고 아이디, 이 아이디를 가지고 AI쪽으로 이동
        //-> 채용 공고의 상세정보를 가져옴
        var jobDetails = this.jobClient.getJobDetails(jobApplication.getJobId());

        //공고 상세정보 중에서도 꼭 필요한 내용들만 가져옴
        //이력서 + 채용공고 상세정보를 AI에 전달하려는 필요한 정보만 추출해서 하나의 객체 변환
        var evaluationRequest = EntityDtoMapper.toJobApplicationEvaluationRequest(jobApplication, jobDetails);

        //평가를 요청하고 그 결과가 점수, 이유로 가져옴
        var evaluationResponse = this.advisorClient.evaluate(evaluationRequest);

        //이미 만들어졌던 레코드에 평가점수와 이유를 추가
        jobApplication.setMatchScore(evaluationResponse.matchScore());
        jobApplication.setMatchReasoning(evaluationResponse.matchReasoning());

        this.repository.save(jobApplication); //수정 -> 그래서 TransactionalEventListener이어야 함.
    }

}
