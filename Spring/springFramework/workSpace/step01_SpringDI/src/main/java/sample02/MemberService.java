package sample02;

public class MemberService {
	private MemberDAO memberDAO;
	private Member member;
	
	public MemberService() {
		System.out.println("MemberService 기본 생성자 호출");
	}

	public MemberService(MemberDAO memberDAO, Member member) {
		System.out.println("MemberService 생성자 memberDAO = "+memberDAO+", member = "+member);
		this.memberDAO = memberDAO;
		this.member = member;
	}
	
	public void selectInsert() {
		System.out.println("MemberService slectInsert call");
		memberDAO.insert(member);
	}
}
