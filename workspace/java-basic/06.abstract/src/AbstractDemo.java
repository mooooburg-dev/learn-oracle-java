

// abstract class : 인스턴스 생성 불가능 (new가 안됨)
//                  abstract methods를 포함하는 클래시는 반드시 abstract
abstract class TheAbstract {
	
	// 일반 멤버를 갖는것이 가능하다
	int x = 10;
	void m() {
		
	}
	
	// abstract method : 본문이 없는 메서드( {}가 없음 )
	abstract void am();
}

// 추상클래스를 상속하는 클래스는 상속받은 추상메서드를 재정의 해야함.
// 아니면 추상클래스로 만들어야 한다.
class TheConcrete extends TheAbstract {
	@Override
	void am() {
		System.out.println("TheConcreate.am()");
	}
}


public class AbstractDemo {

	public static void main(String[] args) {
		
		// 1.
		TheAbstract a1; // 추상클래스 참조 변수 생성 O
		//a1 = new TheAbstract(); // 추상클래스 인스턴스 생성 X
		
		// 2.
		TheAbstract a2 = new TheConcrete();
		a2.am();
	}

}
