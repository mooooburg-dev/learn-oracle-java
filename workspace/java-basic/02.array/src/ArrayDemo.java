
public class ArrayDemo {

	public static void main(String[] args) {
		
		//1. 배열 만들기
		int x = 10;
		int[] ar = null;	// 참조형 변수 만들기
		System.out.println(ar);
		ar = new int[10];	// 인스턴스 만들기 + 주소를 참조형 변수에 저장
		System.out.println(ar);
		
		for( int i=0 ; i<ar.length ; i++) {
			//Math.random() : 0~1 사이의 난수(double) 발생
			ar[i] = (int)(Math.random() * 900)+100; //100~1000
			//System.out.println(ar[i]);
		}
		
		////////////////////////
		
		// 2. 2차원 배열
		int[][] ar2 = new int[7][5];
		for( int i=0 ; i<ar2.length ; i++) {
			for( int j=0 ; j<ar2[i].length ; j++) {
				ar2[i][j] = (int)(Math.random() * 900)+100; //100~1000
				System.out.printf("[%d]", ar2[i][j]);
			}
			System.out.println();
		}
		
		/////////////////////////
		
		// 3. 배열 초기화 (변수 선언 + 트정한 값 저장)
		int[] ar3 = new int[] {1,2,3,4,5};
		//int[] ar3 = {1,2,3,4,5};
		for( int i=0 ; i<ar3.length ; i++) {
			System.out.println(ar3[i]);
		}
	}

}
