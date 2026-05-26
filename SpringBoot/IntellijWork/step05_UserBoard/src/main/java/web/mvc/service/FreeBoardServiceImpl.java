package web.mvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.FreeBoard;
import web.mvc.exception.BasicException;
import web.mvc.exception.ErrorCode;
import web.mvc.repository.FreeBoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBoardServiceImpl implements FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;

    @Override
    public List<FreeBoard> selectAll() {
        List<FreeBoard> freeBoardList = freeBoardRepository.findAll();
        return freeBoardList;
    }

    @Override
    public Page<FreeBoard> selectAll(Pageable pageable) {
        return freeBoardRepository.findAll(pageable);
    }

    @Override
    public void insert(FreeBoard board) {
        freeBoardRepository.save(board);
    }

    @Override
    @Transactional
    public FreeBoard selectBy(Long bno, boolean state) {
        FreeBoard freeBoard = freeBoardRepository.findById(bno).orElseThrow(()->new BasicException(ErrorCode.FAILED_DETAIL));
        if(state){
            int newReadnum = freeBoard.getReadnum() + 1;
            freeBoard.setReadnum(newReadnum);
        }
        return freeBoard;
    }

    @Override
    @Transactional
    public FreeBoard update(FreeBoard board) {
        FreeBoard originBoard = freeBoardRepository.findById(board.getBno()).orElseThrow(()->new BasicException(ErrorCode.FAILED_DETAIL));

        if(originBoard.getPassword() == null || !originBoard.getPassword().equals(board.getPassword())){
            throw new BasicException(ErrorCode.WRONG_PASS);
        }

        originBoard.setSubject(board.getSubject());
        originBoard.setContent(board.getContent());

        return originBoard;
    }

    @Override
    public void delete(Long bno, String password) {
        FreeBoard freeBoard = freeBoardRepository.findById(bno).orElseThrow(()->new BasicException(ErrorCode.FAILED_DELETE));
        if(freeBoard.getPassword()==null || !freeBoard.getPassword().equals(password)){
            throw new BasicException(ErrorCode.WRONG_PASS);
        }
        freeBoardRepository.delete(freeBoard);
    }
}
