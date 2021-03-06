
class TheShape {
	String name;
	
	public void draw() {
		System.out.println("TheShape.draw()");
	}
}
class TheRect extends TheShape {
	public void draw() {
		System.out.println("TheRect.draw()");
	}
}
class TheOval extends TheShape {
	public void draw() {
		System.out.println("TheOval.draw()");
	}
}
class TheLine extends TheShape {
	public void draw() {
		System.out.println("TheLine.draw()");
	}
}

public class Polymorphism {

	public static void main(String[] args) {

		// TheRect 3개, The Line 3개, TheOval 3개 -> draw() 호출
		TheShape[] shapes = new TheShape[9];
		
		for( int i=0 ; i<shapes.length ; i++) {
			switch (i % 3) {
				case 0: shapes[i] = new TheRect(); break;
				case 1: shapes[i] = new TheLine(); break;
				case 2: shapes[i] = new TheOval(); break;
			}
		}
			
		for( int i=0 ; i<shapes.length ; i++) {
			// 다형성 : 동일한 코드가 상황(인스턴스)에 따라 다른 기능을 수행
			// -> 1) 참조타입 != 인스턴스 타입이 다르고
			// -> 2) 재정의 메서드 호출 기준에 의해서 
			// ==> 다형성이 가능해진다.
			shapes[i].draw();
		}
		
	}

}
