package ex0309.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ex0309.db.util.DbManager;
import ex0309.dto.Emp;

public class EmpDAO {
	/**
	 * 사원의 이름 검색하기
	 * */
	public void getSelectNames() {
		//로드, 연결, 실행, 닫기
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = DbManager.getConnection(); //연결
			
			st = con.createStatement();//실행
			rs = st.executeQuery("select ename, sal from emp");
			while(rs.next()) {
				//열을 조회
				String ename = rs.getString(1);
				int sal = rs.getInt(2);
				
				System.out.println(ename+" | "+sal);
			}
			System.out.println("**조회 완료*****");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, st, rs);//닫기
		}
		
	}
	
	//사원 등록
	//insert into emp(empno, ename, sal, hiredate) values(9000, '희정', 2500, now());
	public void insert(Emp emp) {
		Connection con = null;
		Statement st = null;
		String sql = "insert into emp(empno, ename, sal, hiredate) values("+emp.getEmpno()+", '"+emp.getEname()+"', "+emp.getSal()+", now())"; 
		
		try {
			con = DbManager.getConnection();
			st = con.createStatement();
			int result = st.executeUpdate(sql); // 0 or 1
			
			System.out.println("result = "+result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, st);
		}
	}
	
	/**
	 * PreparedStatement 방식으로 insert 하기
	 * */
	public void preParedinsert(Emp emp) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into emp(empno, ename, sal, hiredate) values(?, ?, ?, now())"; 
		
		
		try {
			con = DbManager.getConnection();
			
			ps = con.prepareStatement(sql);
			
			//?의 순서대로 개수만큼 setXxx(?순서, 값) 필요
			ps.setInt(1,emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setInt(3, emp.getSal());
			
			int result = ps.executeUpdate(); // 0 or 1
			
			System.out.println("result = "+result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps);
		}
	}
	
	/**
	 * 사원 전체 검색하기
	 * select empno, ename, sal, hiredate from emp;
	 * */
	public List<Emp> selectAll(){
		List<Emp> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select empno, ename, sal, hiredate from emp"; 
		
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {			
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				int sal = rs.getInt(3);
				String hiredate = rs.getString(4);
				
				list.add(new Emp(empno, ename, sal, hiredate));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps, rs);
		}
		
		return list;
	}
	
	/**
	 * 사원번호에 해당하는 사원 정보 검색하기
	 * select empno, ename, sal, hiredate from emp where empno=?;
	 * */
	public Emp selectByEmpno(int empno) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select empno, ename, sal, hiredate from emp where empno=?";
		Emp emp = null;
		
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, empno);
			
			rs = ps.executeQuery();
			
			//while문을 쓸 필요가 없다.
			if(rs.next()) { //맨 처음 상태에서는 커서가 무조건 컬럼명에 위치하기 때문에 하나 내려주는 작업이 필요!! 하나만 조회한다고 해도 반드시 내려주는 작업이 필요하다.
				emp = new Emp (rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps, rs);
		}
		
		return emp;
	}
	
	/**
	 * 사원번호에 해당하는 사원 삭제하기
	 * delete from emp where empno=?
	 * */
	public int deleteByEmpno(int empno) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from emp where empno=?";
		int result = 0;
		
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, empno);
			
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps);
		}
		
		return result;
	}
	
	
	
	
	
}// 클래스 끝
