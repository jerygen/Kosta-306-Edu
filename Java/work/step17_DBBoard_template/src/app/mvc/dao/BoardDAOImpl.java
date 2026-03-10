package app.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.mvc.common.DBManager;
import app.mvc.dto.BoardDTO;
import app.mvc.dto.ReplyDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

public class BoardDAOImpl implements BoardDAO {
	
	private static BoardDAO instance = new BoardDAOImpl();
	
	private BoardDAOImpl() {}
	
	public static BoardDAO getInstance() {
		return instance;
	}
	

	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<BoardDTO> list = new ArrayList<>();
		String sql="select * from board order by board_no desc";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				int boardNo = rs.getInt(1);
				String subject = rs.getString(2);
				String writer = rs.getString(3);
				String content = rs.getString(4);
				String boardDate = rs.getString(5);
				
				list.add(new BoardDTO(boardNo, subject, writer, content, boardDate));
			}			
		}catch (SQLException e) {
			//여기서 예외를 잡지 않으면 서비스로 갔을 때 정상적으로 처리 되기 때문에 예외 메세지를 계속 전달하기 위해서 잡아서 전달한다.
			//보안을 위해서 다른 메세지로 둔갑해서 전달하는 것
			//e.printStackTrace();
			throw new SearchWrongException("DB에 문제가 있어 다시 진행해주요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}					
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<BoardDTO> list = new ArrayList<>();
		String sql="select * from board where subject like ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1,"%"+keyWord+"%");

			rs = ps.executeQuery();
			
			while(rs.next()) {
				int boardNo = rs.getInt(1);
				String subject = rs.getString(2);
				String writer = rs.getString(3);
				String content = rs.getString(4);
				String boardDate = rs.getString(5);
				
				list.add(new BoardDTO(boardNo, subject, writer, content, boardDate));
			}			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB에 문제가 있어 다시 진행해주요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		BoardDTO bdto = null;
		String sql="select * from board where board_no = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, boardNo);

			rs = ps.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt(1);
				String subject = rs.getString(2);
				String writer = rs.getString(3);
				String content = rs.getString(4);
				String boardDate = rs.getString(5);
				
				bdto = new BoardDTO(no, subject, writer, content, boardDate);
			}			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB에 문제가 있어 다시 진행해주요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return bdto;
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws DMLException {
		Connection con=null;
		PreparedStatement ps = null;
		String sql="insert into board ( subject, writer, content, board_date) \r\n"
				+ "values ( ?, ?, ?, now())";
		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, boardDTO.getSubject());
			ps.setString(2, boardDTO.getWriter());
			ps.setString(3, boardDTO.getContent());
			
			result = ps.executeUpdate();
					
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB에 문제가 있어 다시 진행해주요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws DMLException {
		Connection con=null;
		PreparedStatement ps = null;
		String sql="update board set content = ? where board_no = ?";
		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, boardDTO.getContent());
			ps.setInt(2, boardDTO.getBoardNo());
			
			result = ps.executeUpdate();
					
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB에 문제가 있어 다시 진행해주요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	//댓글이 존재하는 게시글을 삭제하는 경우를 고려해야 함
	@Override
	public int boardDelete(int boardNo) throws DMLException {
		Connection con=null;
		PreparedStatement ps = null;
		String sql="delete from board where board_no = ?";
		int result = 0;
		try {
			con = DBManager.getConnection();
			
			ps = con.prepareStatement(sql);

			ps.setInt(1, boardNo);
			
			result = ps.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("먼저 삭제하려는 글의 댓글을 삭제한 후 삭제해주세요.");
			
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int replyInsert(ReplyDTO replyDTO) throws DMLException {
		Connection con=null;
		PreparedStatement ps = null;
		String sql="insert into reply(reply_content,board_no ,reply_regdate) values( ?, ?, now())";
		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, replyDTO.getReplyContent());
			ps.setInt(2, replyDTO.getBoardNo());
			
			result = ps.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB에 문제가 있어 다시 진행해주요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select * from board where board_no=?";
		BoardDTO bdto = null;
		List<ReplyDTO> list = new ArrayList<>();
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, boardNo);
			
			rs = ps.executeQuery();
					
			if(rs.next()) {
				//열의 정보를 가져와서 BoardDTO에 담는다.
				bdto = new BoardDTO();
				
				bdto.setBoardNo(rs.getInt(1));
				bdto.setSubject(rs.getString(2));
				bdto.setWriter(rs.getString(3));
				bdto.setContent(rs.getString(4));
				bdto.setBoardDate(rs.getString(5));
				
				//게시글에 해당하는 댓글 리스트 가져오기
				list = this.replySelect(con, boardNo);
				bdto.setRepliesList(list);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB에 문제가 있어 다시 진행해주요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return bdto;
	}
	
	
	/***
	 * 부모글에 해당하는 댓글정보 가져오기
	 * */
	private List<ReplyDTO> replySelect(Connection con ,int boardNo)throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from reply where board_no = ?";
		List<ReplyDTO> list = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				int replyNo = rs.getInt(1);
				String replyContent = rs.getString(2);
				int board_No = rs.getInt(3); // BoardDTO
				String replyRegdate = rs.getString(4);
				
				list.add( new ReplyDTO(replyNo, replyContent, board_No, replyRegdate) );
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("DB에 문제가 있어 다시 진행해주요^^");
		}finally {
			DBManager.releaseConnection(null, ps, rs);
		}
		return list;
	}

}













