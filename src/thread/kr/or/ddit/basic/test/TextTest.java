package thread.kr.or.ddit.basic.test;

public class TextTest {
    public static void main(String[] args){
        System.out.println("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.flush();
    }
}