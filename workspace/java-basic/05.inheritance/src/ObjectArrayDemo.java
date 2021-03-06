import lombok.Data;


@Data
class ThePoint {
	private int x;
	private int y;
}

public class ObjectArrayDemo {

	public static void main(String[] args) {

		// 클래스 배열 : 인스턴스의 배열이 아니고 참조의 배열
		ThePoint[] points = new ThePoint[10];
		for(int i=0 ; i<points.length ; i++) {
			// 인스턴스를 만들어서 넣어줘야 한다.
			points[i] = new ThePoint();
			points[i].setX(i * 100);
			points[i].setY(i * 100);
			
			System.out.println(points[i]);
		}
	}

}
