import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class NewContactManager {

	//연락처 목록을 관리하는 컬렉션 객체 만들기
	private ArrayList<Contact> contacts;
	
	Scanner scanner = new Scanner(System.in);
	
	public String chooseMenu() {
		System.out.println();
		System.out.println("***********************************************************************");
		System.out.println("  [1] 등록 | [2] 수정 | [3] 삭제 | [4] 목록 | [5] 검색 | [6] 저장 | [0] 종료");
		System.out.println("***********************************************************************");
		System.out.print("원하는 작업 번호를 입력하세요 : ");
		String selection = scanner.nextLine();
		System.out.println();
		return selection;
	}
	
	public void showContacts() {
		//연락처 목록을 순회하면서(for) 화면에 출력
		System.out.println("[ 연락처 목록 ]");
		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);
		//for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
	
	public ArrayList<Contact> searchContacts(String name) {
		//검색 결과를 저장할 컬렉션 객체 만들기
		ArrayList<Contact> searchedContacts = new ArrayList<>();
		
		for (Contact contact : contacts) {
			if (contact.getName().contains(name)) {//연락처에 저장된 이름과 사용자가 입력한 이름의 부분일치 검색
				searchedContacts.add(contact); //일치하는 연락처를 검색 결과 목록에 추가
			}
		}
		
		return searchedContacts; // 검색된 연락처 목록 반환
	}
	
	private void loadContacts() {
		File f = new File("contacts.dat");
		if (!f.exists()) { //파일이 없다면
			contacts = new ArrayList<Contact>();
			return;
		}
		
		try (
			FileInputStream fis = new FileInputStream("contacts.dat");
			ObjectInputStream ois = new ObjectInputStream(fis)
		) {
			contacts = (ArrayList<Contact>)ois.readObject();
		} catch (IOException | ClassNotFoundException ex) { // 파일 없음 오류 + 형변환 오류
			contacts = new ArrayList<Contact>();
		}
	}
	
	public void doManage() {
		
		loadContacts(); //파일에 저장된 연락처 정보 읽기
		
		outer: while (true) {
			//1. 메뉴 보여주기 + 사용자의 작업 선택
			String selection = chooseMenu();
			
			//2. 사용자 선택에 따라 해당 작업 처리
			switch (selection) {
			case "1": //사용자 등록
				//1. 입력
				System.out.println("[ 등록할 연락처 정보를 입력하세요 ]");
				System.out.print("이름 : ");
				String name = scanner.nextLine();
				System.out.print("전화번호 : ");
				String phone = scanner.nextLine();
				System.out.print("이메일 : ");
				String email = scanner.nextLine();
				//2. 객체 만들기 + 입력 데이터 저장 + 목록에 추가
				Contact contact = new Contact();
				contact.setName(name);
				contact.setPhone(phone);
				contact.setEmail(email);
				contacts.add(contact); //목록에 추가
				
				System.out.println("새 연락처를 등록했습니다.");
				
				break;
				
			case "2": //수정				
				//검색
				System.out.print("수정할 이름 : ");
				String nameToSearch3 = scanner.nextLine();
				
				//검색 결과 목록 만들기 + 목록을 순회하면서 일치 항목 찾기 + 결과 목록에 추가
				ArrayList<Contact> searchedContacts3 = searchContacts(nameToSearch3);
				
				if (searchedContacts3.size() == 0) {
					System.out.println("수정할 연락처를 찾을 수 없습니다.");
					break;
				}
				
				//출력
				for (int i = 0; i < searchedContacts3.size(); i++) {
					System.out.printf("[%d]. %s\n", (i + 1), searchedContacts3.get(i));
				}
				
				//검색 결과 목록에서 수정 대상 선택 (입력)
				System.out.print("수정할 연락처 번호 : ");
				int noToEdit = scanner.nextInt(); //버퍼에서 숫자만 가져오고 enter는 남겨둡니다.
				scanner.nextLine(); //버퍼에 남아있는 enter 제거
				
				if (noToEdit < 1 || noToEdit > searchedContacts3.size()) {
					System.out.println("입력 오류");
					break;
				}
				//수정 내용 입력
				System.out.println("[ 수정할 연락처 정보를 입력하세요 ]");
				System.out.print("이름 : ");
				String name2 = scanner.nextLine();
				System.out.print("전화번호 : ");
				String phone2 = scanner.nextLine();
				System.out.print("이메일 : ");
				String email2 = scanner.nextLine();
				//수정 내용 저장
				Contact contact2 = searchedContacts3.get(noToEdit - 1); 
				contact2.setName(name2);
				contact2.setPhone(phone2);
				contact2.setEmail(email2);				
				
				System.out.println("선택한 연락처를 수정했습니다.");
				
				break;
				
			case "3": // 삭제
				//검색
				System.out.print("삭제할 이름 : ");
				String nameToSearch2 = scanner.nextLine();
				
				//검색 결과 목록 만들기 + 목록을 순회하면서 일치 항목 찾기 + 결과 목록에 추가
				ArrayList<Contact> searchedContacts2 = searchContacts(nameToSearch2);
				
				if (searchedContacts2.size() == 0) {
					System.out.println("삭제할 연락처를 찾을 수 없습니다.");
					break;
				}
				
				//출력
				for (int i = 0; i < searchedContacts2.size(); i++) {
					System.out.printf("[%d]. %s\n", (i + 1), searchedContacts2.get(i));
				}
				
				//검색 결과 목록에서 삭제 대상 선택 (입력)
				System.out.print("삭제할 연락처 번호 : ");
				int noToDelete = scanner.nextInt(); //버퍼에서 숫자만 가져오고 enter는 남겨둡니다.
				scanner.nextLine(); //버퍼에 남아있는 enter 제거
				
				if (noToDelete < 1 || noToDelete > searchedContacts2.size()) {
					System.out.println("입력 오류");
					break;
				} 				
				//삭제처리 : ArrayList.remove(위치번호) or ArrayList.remove(참조)
				Contact contactToDelete = searchedContacts2.get(noToDelete - 1);
				contacts.remove(contactToDelete);
				
				System.out.println("선택한 연락처를 삭제 했습니다.");
				
				
				break;
				
			case "4": // 목록 보기			
				showContacts();
				break;
				
			case "5": // 검색
				//검색어 입력
				System.out.print("검색할 이름 : ");
				String nameToSearch = scanner.nextLine();
				
				//검색 결과 목록 만들기 + 목록을 순회하면서 일치 항목 찾기 + 결과 목록에 추가
				ArrayList<Contact> searchedContacts = searchContacts(nameToSearch);
				
				//출력
				for (int i = 0; i < searchedContacts.size(); i++) {
					System.out.printf("[%d]. %s\n", (i + 1), searchedContacts.get(i));
				}
				break;
				
			case "6": // 저장 (Contact의 목록 저장)
//				FileOutputStream fos = null;
//				ObjectOutputStream oos = null;
//				try {
//					fos = new FileOutputStream("contacts.dat");
//					oos = new ObjectOutputStream(fos);
//					oos.writeObject(contacts); //연락처 목록(ArrayList)을 일괄 저장					
//				} catch (IOException e) { //IOException, FileNotFoundException 모두 처리
//					e.printStackTrace();// 화면에 오류 메시지 출력하는 명령
//				} finally {
//					try { oos.close(); } catch (Exception ex) { }
//					try { fos.close(); } catch (Exception ex) { }
//				}				
				
				try(
					//여기에 선언된 변수는 자동으로 close가 호출됩니다.
					FileOutputStream fos = new FileOutputStream("contacts.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos)
				) {					 
					oos.writeObject(contacts); //연락처 목록(ArrayList)을 일괄 저장					
				} catch (IOException e) { //IOException, FileNotFoundException 모두 처리
					e.printStackTrace();// 화면에 오류 메시지 출력하는 명령
				} 
				
				System.out.println("연락처 목록을 파일에 저장했습니다.");
				break;
			
			case "0": //프로그램 종료
				System.out.println("연락처 프로그램을 종료합니다.");
				break outer; //outer로 지정된 반복문 또는 switch문 종료
				
			default : //입력 오류
				System.out.println("지원하지 않는 명령입니다.");
				break;
			}
		}
		
	}

	public static void main(String[] args) {
	
		NewContactManager manager = new NewContactManager();
		manager.doManage();

	}

}
