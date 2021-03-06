import java.util.ArrayList;
import java.util.LinkedList;

public class HelloCollection {
	
	public static void main(String[] args) {

		//String[] ar = new String[10];
		//ar[0] = "test";
		
		//Object타입 호환성을 사용하는 ArrayList
//		ArrayList al = new ArrayList();
//		al.add("Data 1");
//		al.add("Data 2");
//		al.add("Data 3");
//		al.add("Data 4");
//		al.add("Data 5");
		
		//Generic형식의 ArrayList
		ArrayList<String> al = new ArrayList<>();
		al.add("Data 1");
		al.add("Data 2");
		al.add("Data 3");
		al.add("Data 4");
		al.add("Data 5");
		
		for( int i=0 ; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		System.out.println("===================================");
		
		
		LinkedList<String> al2 = new LinkedList<>();
		al2.add("Data 1");
		al2.add("Data 2");
		al2.add("Data 3");
		al2.add("Data 4");
		al2.add("Data 5");
		
		for( int i=0 ; i<al2.size(); i++) {
			System.out.println(al2.get(i));
		}
		
		
	}

}
