
class TheBase {
	String m1 = "Base Member";
	
	void m() {
		System.out.println("TheBase.m()");
	}
}

//TheBase의 모든 멤버가 TheDerived에 포함
class TheDerived extends TheBase {
	String m2 = "Derived Member"; // 새로운 멤버 추가
	
	// 기존 멤버 변경 -> 오버라이딩(overriding)
	// (변경은 메서드만 가능 : 메서드 이름/형태/전달인자까지 모두 같아야 한다)
	void m() {	
		System.out.println("TheDerived.m()");
	}
}

public class ExtendsDemo {

	public static void main(String[] args) {
		// 1.
		TheBase b1 = new TheBase();
		b1.m();
		TheDerived d1 = new TheDerived();
		d1.m();
		
		// 2. 상속관계에서는 참조타임과 인스턴스타입이 다를 수 있다.
		TheBase b2 = new TheDerived();
		
		b2.m();	// 참조타입 != 인스턴스타입인 겨우, 재정의 메서드는 인스턴스 타입이 기준이 된다.
		
		//System.out.println(b2.m2);	// 참조변수는 참조타입을 기준으로 인스턴스를 사용
		
		//TheDerived d2 = new TheBase();	// 상속구조의 부모를 생성할 수 없다
		//TheDerived d2 = (TheDerived)new TheBase(); // 형변환 시켜 실행할 수는 있지만 어차피 오류!
		
		TheDerived d2 = (TheDerived)b2;
		System.out.println(d2.m2);
		
		// b1을 TheDerived로 형변환 할 수 있다면 해라
		if(b1 instanceof TheDerived) {
			System.out.println("형변환 가능");
			d2 = (TheDerived)b1;
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
