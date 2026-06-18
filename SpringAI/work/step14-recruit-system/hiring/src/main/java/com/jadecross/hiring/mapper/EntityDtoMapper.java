package com.jadecross.hiring.mapper;


import com.jadecross.hiring.dto.*;
import com.jadecross.hiring.entity.JobApplication;

public class EntityDtoMapper {

    public static JobApplication toJobApplication(JobApplicationSubmissionRequest request) {
        var entity = new JobApplication();
        entity.setJobId(request.jobId());
        entity.setCandidateId(request.candidateId());
        return entity;
    }

    public static JobApplicationDetails toJobApplicationDetails(JobApplication jobApplication) {
        return new JobApplicationDetails(
                jobApplication.getId(),
                jobApplication.getJobId(),
                jobApplication.getCandidateId(),
                jobApplication.getAppliedDate(),
                jobApplication.getResume(),
                jobApplication.getMatchScore(),
                jobApplication.getMatchReasoning()
        );
    }

    public static CandidateApplication toCandidateJobApplication(JobApplication jobApplication, JobDetails jobDetails) {
        return new CandidateApplication(
                jobApplication.getId(),
                jobApplication.getJobId(),
                jobApplication.getCandidateId(),
                jobDetails.title(),
                jobDetails.employer(),
                jobApplication.getAppliedDate(),
                jobApplication.getResume()
        );
    }

    /**
     * 평가를 위한 요청,이력서가 공고 상세설명과 요구 스킬에 충족하는 지 확인하기 윙함
     * */
    public static JobApplicationEvaluationRequest toJobApplicationEvaluationRequest(JobApplication jobApplication, JobDetails jobDetails){
        return new JobApplicationEvaluationRequest(
                jobDetails.title(),
                jobDetails.description(), 
                jobDetails.requiredSkills(),
                jobApplication.getResume() //중요. 이력서
        );
    }

}
