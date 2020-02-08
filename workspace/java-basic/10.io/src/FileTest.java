import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {

	public static void main(String[] args) {
		
		//날짜의 출력 형식을 관리하는 클래스 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		
		//File : File or Directory 관리 클래스
		//File file = new File("C:\\Windows"); //문자열에서 \\ -> 실제로는 \
		File file = new File("C:\\"); //문자열에서 \\ -> 실제로는 \		
		
		//String[] files = file.list();	//디렉터리에 포함된 파일 + 디렉터리 목록을 문자열 배열로 반환
		File[] files = file.listFiles();//디렉터리에 포함된 파일 + 디렉터리 목록을 File 배열로 반환
		
		for (File f : files) { //목록에 포함된 파일 또는 디렉터리를 순회
			
			//java.util.Date : 날짜를 관리하는 클래스				
			Date d = new Date(f.lastModified()); //long형 시간을 받아서 날짜 형식으로 구성
			
			if (f.isDirectory()) { //디렉터리(폴더)인지 확인				 
				System.out.printf("%s%7s%13s %s\n",
					formatter.format(d), //d.toString(), //f.lastModified(),
					"<DIR>",
					"",
					f.getName());
			} else { // if (f.isFile() == true)				
				System.out.printf("%s%7s%,13d %s\n",
					formatter.format(d), //d.toString(), //f.lastModified(),
					"",
					f.length(),
					f.getName());
			}
		}

	}

}
