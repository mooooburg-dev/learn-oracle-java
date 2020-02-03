

class TheObject {	// extends Object 가 생략되어 있는 형태
	
	int x;
	
	@Override
		public boolean equals(Object obj) {
			TheObject other = (TheObject)obj;
			return this.x == other.x;
		}
	
	@Override
		public String toString() {	// 객체의 정보를 간단한 문자열로 반환
			//return super.toString();	// super : 부모 클래스(여기서는 object)
			return String.format("[X: %d]",  x);
		}
}

public class ObjectDemo {

	public static void main(String[] args) {

		TheObject obj1 = new TheObject();
		obj1.x = 10;
		
		TheObject obj2 = new TheObject();
		obj2.x = 10;
		
		
		if( obj1 == obj2 ) { // 비교 연산자는 주소를 비교한다
			System.out.println("Equals");
		}
		else {
			System.out.println("Not Equals");
		}
		
		
		if( obj1.equals(obj2) ) { // Object.equals()는 주소를 비교한다
			System.out.println("Equals");
		}
		else {
			System.out.println("Not Equals");
		}
		
		System.out.println("========================");
		
		String str1 = new String("Hello Java");
		String str2 = new String("Hello Java");
		
		System.out.println(str1 == str2); // 주소 비교
		System.out.println(str1.equals(str2)); // 내용 비교
		
		
		System.out.println("========================");
		
		System.out.println(obj1.toString());
	}

}
