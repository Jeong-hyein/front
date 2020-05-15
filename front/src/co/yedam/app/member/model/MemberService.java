package co.yedam.app.member.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import co.yedam.app.common.ConnectionManager;

public class MemberService {

	//싱글톤, 한번 정의해서 계속 불러쓴다.
	private static MemberService instance = new MemberService();
	public static MemberService getInstance() {
		return instance;
	}
	
	//회원가입
	public void memberInsert(MemberVO member) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnect();
			conn.setAutoCommit(false); //자동커밋 false
			//회원테이블에 등록, if문으로
			MemberDAO.getInstance().memberInsert(conn, member);
			//로그인 테이블에 등록
		
			//권한테이블에 등록
			
			conn.commit(); //같이 커밋
			} catch(Exception e) {
				e.printStackTrace();
				try {
					conn.rollback(); //하나라도 오류나면 rollback
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
//				conn.setAutoCommit(true);
				ConnectionManager.close(conn);
			}
		}
	
	public ArrayList<MemberVO> getMemberList() {
		Connection conn = null; //conn할 필요없는데 헷갈리지말라고 넣음
		try {
			conn = ConnectionManager.getConnect();
			return MemberDAO.getInstance().getMemberList(conn);
		} finally {
			ConnectionManager.close(conn);
		}
	}
	
	public getMember() {
		
	}
	
}
