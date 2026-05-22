package web.mvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import web.mvc.domain.FreeBoard;
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
        return null;
    }

    @Override
    public void insert(FreeBoard board) {

    }

    @Override
    public FreeBoard selectBy(Long bno, boolean state) {
        return null;
    }

    @Override
    public FreeBoard update(FreeBoard board) {
        return null;
    }

    @Override
    public void delete(Long bno, String password) {

    }
}
