package test.student.list;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentExam {

	public static void main(String[] args) {
		StudentExam std = new StudentExam();

		List<Student> list = new ArrayList<Student>();
		list.add(new Student("1584012", "홍길동", 76, 72, 83));
		list.add(new Student("1484011", "고길동", 76, 72, 83));
		list.add(new Student("1684015", "손흥민", 66, 72, 83));
		list.add(new Student("1884013", "박지성", 56, 90, 93));
		list.add(new Student("2084009", "차범근", 36, 77, 88));

		std.setRanking(list);

		System.out.println("정렬 전");
		for (Student student : list) {
			System.out.println(student);
		}

		Collections.sort(list);
		System.out.println("학번순 정렬.");
		for (Student student : list) {
			System.out.println(student);
		}

		Collections.sort(list, new TotalSort());
		System.out.println("총점 순 정렬");
		for (Student student : list) {
			System.out.println(student);
		}
	}

	public void setRanking(List<Student> List) {
		for (Student student : List) {
			int rank = 1;
			for (Student student2 : List) {
				if (student.getTotal() < student2.getTotal()) {
					rank++;
				}
			}
			student.setRank(rank);
		}
	}
}