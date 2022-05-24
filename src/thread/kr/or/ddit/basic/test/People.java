package thread.kr.or.ddit.basic.test;

public class People {
	String name;
	String snn;

	public People() {
	}

//	public People(String name, String snn) {
//		this.name = name;
//		this.snn = snn;
//	}

	/**
	 * 
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSnn() {
		return snn;
	}

	public void setSnn(String snn) {
		this.snn = snn;
	}

}

class Student extends People {
	public int studentNo;

	public Student(String name, String snn, int studentNo) {
		this.name = name;
		this.snn = snn;
		this.studentNo = studentNo;

	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
}
