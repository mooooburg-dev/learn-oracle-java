
public class WrapperDemo {

	public static void main(String[] args) {

		int x = 10;
		//Object o = x;
		Object o = new Integer(x);
		System.out.println(o);

		//int y = (int)o;
		int y = ((Integer)o).intValue();
		System.out.println(y);
		
		//int z = null;	// primitive type에는 null 저장이 안됨
		Integer z2 = null;
				
		
	}

}
