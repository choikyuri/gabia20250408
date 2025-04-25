package chapter06;

public class StudentInfo_06 {

	// 멤버변수=필드
	int studentID;
	private String studentName;
	int grade;
	String address;

	// 생성자
	public StudentInfo_06() {

	}

	// 생성자 오버로딩
	public StudentInfo_06(int studentID, String studentName, int grade, String address) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.grade = grade;
		this.address = address;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
