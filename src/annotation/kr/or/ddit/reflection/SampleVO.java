package annotation.kr.or.ddit.reflection;

public class SampleVO implements Comparable<SampleVO> {
	public String id;
	protected String name;
	private int age;

	public SampleVO(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public SampleVO() throws RuntimeException {

	}

	@Override
	public String toString() {
		return String.format("SampleVO [id=%s, name=%s, age=%s]", id, name, age);
	}

	@Override
	public int compareTo(SampleVO o) {
		return name.compareTo(o.name);
	}

}
