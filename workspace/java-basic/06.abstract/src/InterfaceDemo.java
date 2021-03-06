

// interface : 극단적인 추상클래스 -> 모든 멤버가 추상 메서드(일반 변수는 안됨)
interface TheInterface {
	void am1();	// -> public abstract void am1();
	void am2();	// -> public abstract void am2();
}

// interface를 구현하는 클래스는 반드시 추상메서드를 재정의 하거나
// 또는 추상클래스로 정의해야 한다.
class TheImplement implements TheInterface {

	@Override
	public void am1() {
		System.out.println("am1");
	}

	@Override
	public void am2() {
		System.out.println("am2");
	}
	
}


public class InterfaceDemo {

	public static void main(String[] args) {
		
		// 1.
		TheInterface i1;	// 인터페이스 참조 변수 만들 수 있다.

		// i1 = new TheInterface(); // 인터페이스 인스턴스 만들수 X
		i1 = new TheImplement();
		i1.am1();
		i1.am2();
		
	}

}
