

// 


class TheObject2 {
	Object data; // Object 형식의 변수에는 모든 타입의 데이터 저장이 가능
}


class TheGeneric<T, Z> {
	T data1;	// T는 미확정 자료형
	Z data2;	// Z는 미확정 자료형
}


public class GenericDemo {

	public static void main(String[] args) {

		TheObject2 obj = new TheObject2();
		obj.data = "Hello";
		//obj.data = 20;
		//obj.data = 12.23;
		
		// Object 타입의 변수에 저장된 데이터를 읽을 때 반드시 형변환 필요
		//double d = (double)obj.data;	
		//System.out.println(d);
		
		System.out.println("======================================");
		
		// data1은 Integer, data2는 String으로 사용하겠다
		TheGeneric<Integer, String> gobj = new TheGeneric ();
		gobj.data1 = 10;
		gobj.data2 = "Hello";
		//gobj.data2 = 12.34; // 확정된 자료형을 변경할 수 없음
		
		String s = gobj.data2;	// Generic 변수의 데이터를 읽을 때 형변환이 필요없다.
	}

}
