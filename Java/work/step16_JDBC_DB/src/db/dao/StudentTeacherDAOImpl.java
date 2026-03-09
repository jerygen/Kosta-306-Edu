package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.dto.Room;
import db.dto.Student;
import db.dto.Subject;
import db.dto.Teacher;
import db.util.DbManager;

public class StudentTeacherDAOImpl implements StudentTeacherDAO {

	@Override
	public List<Student> getGenderByWomen() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from student where substring(reg_number, 8,1) = '2'";
		List<Student> list = new ArrayList<>();
		
		try {
			con = DbManager.getConnection(); //연결
	
			ps = con.prepareStatement(sql);//실행
			rs = ps.executeQuery();
			
			while(rs.next()) {
				//열을 조회
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String jumin = rs.getString(3);
				String phone = rs.getString(4);
				String address = rs.getString(5);
				String email = rs.getString(6);
				
				list.add(new Student(id, name, jumin, phone, address, email));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps, rs);//닫기
		}
		
		return list;
	}

	@Override
	public List<Teacher> getTeacherInfoByAddr(String gu) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from instructor where substring(address, instr(address, '강남구'), 3) = '강남구'";
		List<Teacher> list = new ArrayList<>();
		
		try {
			con = DbManager.getConnection(); //연결
	
			ps = con.prepareStatement(sql);//실행
			rs = ps.executeQuery();
			
			while(rs.next()) {
				//열을 조회
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String jumin = rs.getString(3);
				String phone = rs.getString(4);
				String address = rs.getString(5);
				String email = rs.getString(6);
				String sugangCode = rs.getString(7);
				
				list.add(new Teacher(id, name, jumin, phone, address, email, sugangCode));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps, rs);//닫기
		}
		
		return list;
	}

	@Override
	public Teacher getTeacherInfoBySubject(String subject) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select * from instructor where course_code = \r\n"
				+ "    (select course_code from course where upper(course_name)=upper( ? ));\r\n"
				+ "";
		Teacher teacher = null;
		
		try {
			con = DbManager.getConnection(); //연결
			
			ps = con.prepareStatement(sql);//실행
			ps.setString(1, subject);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				//열을 조회
				teacher = new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3), 
										rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps, rs);//닫기
		}
		return teacher;
	}

	@Override
	public Teacher getTeacherInfoByNo(int teacherNo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from v_tear where instructor_id = ?";
		Teacher teacher = new Teacher();
		
		
		try {
			con = DbManager.getConnection(); //연결
			
			ps = con.prepareStatement(sql);//실행
			rs = ps.executeQuery();
			
			if(rs.next()) {
				//열을 조회
				teacher.setRoom( new Room(rs.getInt("classroom_no"), rs.getInt("capacity")) );
				teacher.setSubject( new Subject(rs.getString("course_code"), rs.getString("course_name")) );
				
				teacher.setTeacherNo(rs.getInt("instructor_id"));
				teacher.setTeacherName(rs.getString("name"));
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps, rs);//닫기
		}
		return teacher;
	}

}
