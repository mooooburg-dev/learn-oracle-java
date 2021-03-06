import java.util.Arrays;

import javax.print.attribute.standard.MediaSize.Other;

import lombok.Data;


@Data
class ThePoint implements Comparable<ThePoint> {
	private int x;
	private int y;
	@Override
	public int compareTo(ThePoint ohter) {
		if(this.x > ohter.x) return 1;
		else if(this.x < ohter.x) return -1;
		else return 0;
	}
}

public class InterfaceDemo2 {

	public static void main(String[] args) {
		
//		int[] ar = new int[10];
//		for( int i=0 ; i<ar.length ; i++ ) {
//			ar[i] = (int)(Math.random() * 900) + 100;
//		}
//		
//		for( int i=0 ; i<ar.length ; i++ ) {
//			System.out.println(ar[i]);
//		}
//		
//		Arrays.sort(ar);	// 배열을 정렬하는 메서드
//		System.out.println("================");
//		
//		for( int i=0 ; i<ar.length ; i++ ) {
//			System.out.println(ar[i]);
//		}
		

		// 클래스 배열 : 인스턴스의 배열이 아니고 참조의 배열
		ThePoint[] points = new ThePoint[10];
		for(int i=0 ; i<points.length ; i++) {
			// 인스턴스를 만들어서 넣어줘야 한다.
			points[i] = new ThePoint();
			points[i].setX((int)(Math.random() * 900) + 100);
			points[i].setY((int)(Math.random() * 900) + 100);
		}
		
		for( int i=0 ; i<points.length ; i++ ) {
			System.out.println(points[i]);
		}
		
		System.out.println("================");
		Arrays.sort(points);
		
		
		for( int i=0 ; i<points.length ; i++ ) {
			System.out.println(points[i]);
		}
	}

}
