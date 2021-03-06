import java.util.Scanner;

public class MethodDemo {

	public static void main(String[] args) {
		
		
		// 명령행에서 사용자 입력을 받는 객체
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("박스 그리기에 사용할 문자 : ");
		String s = scanner.nextLine();	// 입력 내용을 문자열로 반환
		
		System.out.print("박스의 너비 : ");
		int width = scanner.nextInt();
		
		System.out.print("박스의 높이 : ");
		int height = scanner.nextInt();
		
		drawBox(s, width, height);	// 메서드 호출 : 정의된 메서드를 실행
		
		scanner.close();
		
		int x = rand();
		System.out.printf("rand : %d", x);
	}
	
	private static int rand() {	// 결과형 이름(전달인자)
		int x = (int)(Math.random()*900) + 100;
		
		return x;	// 함수를 종료 + x를 호출한 곳으로 반환
	}

	// 메서드 정의 : 재사용 코드 단위 만들기
	private static void drawBox(String s2, int width, int height) {
		for (int y=0 ; y<height ; y++) {
			for(int x=0 ; x<width ; x++) {
				if( x == 0 || x == width-1 || y == 0 || y == height-1 ) {
					// System.out.print("*");
					System.out.print(s2);
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
