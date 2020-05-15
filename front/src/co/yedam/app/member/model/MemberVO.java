package co.yedam.app.member.model;

public class MemberVO {
	String id; 				//아이디
	String pwd;				//패스워드
	String name;			//이름
	String hobby;			//취미
	String gender;			//성별
	String religion;		//종교
	String introduction;	//자기소개
	String regdt ;			//가입일자
	
	//lombok이라는 편한 기능이 있음
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", hobby=" + hobby + ", gender=" + gender
				+ ", religion=" + religion + ", introduction=" + introduction + ", regdt=" + regdt + "]";
	}

}
