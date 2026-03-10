package app.mvc.service;

import java.util.List;

import app.mvc.dao.BoardDAO;
import app.mvc.dao.BoardDAOImpl;
import app.mvc.dto.BoardDTO;
import app.mvc.dto.ReplyDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;
/**
 * @author 
 * */
public class BoardServiceImpl implements BoardService {
	private static BoardService instance = new BoardServiceImpl();
	private BoardDAO boardDao = BoardDAOImpl.getInstance();
			
	private BoardServiceImpl() {}
    public static BoardService getInstance() {
		return instance;
	}
    
	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		List<BoardDTO> list = boardDao.boardSelectAll();
		
		if(list.isEmpty())
			throw new SearchWrongException("검색된 레코드가 없습니다.");
		
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SearchWrongException {
		List<BoardDTO> list = boardDao.boardSelectBySubject(keyWord);
		
		if(list.isEmpty())
			throw new SearchWrongException(keyWord+"가 포함된 검색된 레코드가 없습니다.");
 		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SearchWrongException {
		BoardDTO bdto = boardDao.boardSelectByNo(boardNo);
		if(bdto == null)
			throw new SearchWrongException(boardNo+" 레코드가 없습니다.");
		return bdto;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws DMLException {
		int result = boardDao.boardInsert(boardDTO);
		if(result==0)
			throw new DMLException("게시글이 등록되지 않았습니다.");

	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws DMLException {
		int result = boardDao.boardUpdate(boardDTO);
		if(result==0)
			throw new DMLException(boardDTO.getBoardNo()+"번 게시글이 수정되지 않았습니다.");
	}

	@Override
	public void boardDelete(int boardNo) throws DMLException {
		int result = boardDao.boardDelete(boardNo);
		if(result==0)
			throw new DMLException(boardNo+"번 게시글이 삭제되지 않았습니다.");
	}

	@Override
	public void replyInsert(ReplyDTO replyDTO) throws DMLException {
		int result = boardDao.replyInsert(replyDTO);
		if(result==0)
			throw new DMLException("댓글이 등록되지 않았습니다.");
	}

	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SearchWrongException {
		BoardDTO bdto = boardDao.replySelectByParentNo(boardNo);
		if(bdto==null)
			throw new SearchWrongException(boardNo+"번 게시글에 댓글이 없습니다.");
		return bdto;
	}

}











