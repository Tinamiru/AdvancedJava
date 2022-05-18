package test.student.list;

class Student implements Comparable<Student> {
	private String num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int rank;

	public Student(String num, String name, int kor, int eng, int mat) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = mat;
		this.total = kor + eng + mat;
	}

	public String getNum() {
		return num;
	}

	public int getTotal() {
		return total;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int compareTo(Student std) {
		return num.compareTo(std.num);
	}

	@Override
	public String toString() {
		return String.format("학번: %s, 이름: %s, 국어: %s, 영어: %s, 수학: %s, 총점: %s, 등수: %s", num, name, kor, eng, math, total,
				rank);
	}
}