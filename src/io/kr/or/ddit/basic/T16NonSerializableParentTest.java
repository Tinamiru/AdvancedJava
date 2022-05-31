package io.kr.or.ddit.basic;

import java.io.*;

public class T16NonSerializableParentTest {

//	부모클래스가 Serializable 인터페이스를 구현하고 있지 않을 경우
//	부모 객체의 필드값 처리 방법에 대하여...
//	
//	1. 부모 클래스가 Serializable 인터페이스를 구현하도록 해야 한다.
//	2. 자식 클래스에 writeObject()와 readObject() 메서드를 이용하여
//	   부모 객체의 필드값을 처리할 수 있도록 직접 구현한다.

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/D_Other/nonSerializableTest.bin"));

		Child child = new Child();
		child.setParentName("부모");
		child.setChildName("자식");
		oos.writeObject(child); // 직렬화
		oos.flush(); // 생략가능
		oos.close();

		/////////////////////////////////////////////////////////////
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/D_Other/nonSerializableTest.bin"));

		child = (Child) ois.readObject(); // 역직렬화

		System.out.println("부모이름 : " + child.getParentName());
		System.out.println("자식이름 : " + child.getChildName());

		ois.close();

	}
}

//	Serializable 미구현 부모 클래스
class parent {
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}

//	Serializable 구현 자식 클래스
class Child extends parent implements Serializable {
	private String childName;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(getParentName());
		out.defaultWriteObject();
	}

	/**
	 * 역직렬화가 될때 자동으로 호출됨. (접근제어자가 private타입이 아니면 자동호출 되지 않음)
	 * 
	 * @param in
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		setParentName(in.readUTF());
		in.defaultReadObject();
	}
}
