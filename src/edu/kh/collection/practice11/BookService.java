package edu.kh.collection.practice11;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BookService {

	Scanner sc = new Scanner(System.in);
	
	List<Book> bookList = new LinkedList<Book>();
	
	public BookService () {
		
		bookList.add( new Book(1001, "용의자 1의 헌신", "히가시노 게일고", 15110, "재일 출판사"));
		bookList.add( new Book(1002, "용의자 2의 헌신", "히가시노 게이고", 15120, "재이 출판사"));
		bookList.add( new Book(1003, "용의자 3의 헌신", "히가시노 게삼고", 15130, "재삼 출판사"));
		bookList.add( new Book(1004, "용의자 4의 헌신", "히가시노 게사고", 15140, "재사 출판사"));
		
	}
	
	
	
	public void displayMenu() {
		
		
		try {
		
			int input = 0;
			
			do { 
				System.out.println();
				System.out.println("===도서 목록 프로그램===");
				System.out.println("1. 도서 등록");
				System.out.println("2. 도서 전체 조회");
				System.out.println("3. 도서 정보 수정");
				System.out.println("4. 도서 정보 삭제");
				System.out.println("5. 좋아요(즐겨찾기) 추가");
				System.out.println("6. 좋아요(즐겨찾기) 삭제");
				System.out.println("0. 프로그램 종료");
				
				System.out.print("\n번호를 입력해 주세요 : ");
				input = sc.nextInt();
				System.out.println();
	
					
					
				if ( !(0<= input || input <=6) ) {
					System.out.println("목록에 있는 번호를 입력해주세요\n");
				} else {
					
					switch(input) {
					
					case 1 : System.out.println(bookRegist()); 
						break;
					case 2 : searchAllBook();
						break;
					case 3 : changeBookInfo();
						break;
					case 4 : removeBook();
						break;
					case 5 : addFav();
						break;
					case 6 : removeFav();
						break;
					case 0 : System.out.println("프로그램을 종료합니다.\n");
						break;
					default : System.out.println("목록에 있는 번호를 입력해주세요.\n");

					}
				}
					
				
			} while(input != 0);
		
		} catch (InputMismatchException e) {
			System.out.println("\n잘못된 값을 입력하셨습니다.\n");
		}
		
	} // public void bookMenu	

	
	
	public String bookRegist() throws InputMismatchException{
		
		System.out.println("===도서 등록===");
		
		System.out.print("도서번호 : ");
		int input1 = sc.nextInt();
		
		System.out.print("도서제목 : ");
		String input2 = sc.nextLine();
		
		sc.nextLine();
		System.out.print("도서저자 : ");
		String input3 = sc.nextLine();
		
		System.out.print("도서가격 : ");
		int input4 = sc.nextInt();
		
		sc.nextLine();
		System.out.print("출판사 : ");
		String input5 = sc.nextLine();
		
		if ( bookList.add( new Book(input1, input2, input3, input4, input5)) ) {
			return "추가되었습니다.\n";
		} else {
			return "잘못 입력하셨습니다.\n";
		}
		
	}
	
	
	
	
	public void searchAllBook() throws InputMismatchException{
		
		System.out.println("===도서 전체 조회===");	
		
		if (bookList.isEmpty()) {
			System.out.println("도서가 아무것도 등록되어 있지 않습니다.\n");
			return;
		} else {

			for(Book bk : bookList) {
				System.out.println(bk);

			}

		}
	}
	
	
	
	
	public void changeBookInfo() throws InputMismatchException{
		
		System.out.println("===도서 정보 변경===");	
		System.out.print("수정할 도서의 도서번호를 입력하세요 : ");
		int input7 = sc.nextInt();
		
		

		
		//getter/setter 이용하여 수정?
		
		for (int i = 0; i<bookList.size(); i++) {
			if(input7 == bookList.get(i).getBookNum()) {
				
				System.out.println();
				System.out.println("1. 도서제목");
				System.out.println("2. 도서저자");
				System.out.println("3. 도서가격");
				System.out.println("4. 출판사");
				System.out.println("0. 수정종료");
				System.out.print("어떤 정보를 수정하시겠습니까? : ");
				int input8 = sc.nextInt();
				
				sc.nextLine();			
				
				switch(input8) {
				
				case 1 : 
					System.out.print("바꿀 정보를 입력하세요 : ");
					String input11 = sc.nextLine();
					bookList.get(i).setName(input11); 
					System.out.println("수정이 완료되었습니다.");
					break;
				case 2 : 
					System.out.print("바꿀 정보를 입력하세요 : ");
					String input12 = sc.nextLine();
					bookList.get(i).setWriter(input12); 
					System.out.println("수정이 완료되었습니다.");
					break;
				case 3 : 
					System.out.print("바꿀 정보를 입력하세요 : ");
					int input13 = sc.nextInt();
					bookList.get(i).setPrice(input13); 
					System.out.println("수정이 완료되었습니다.");
					break;
				case 4 : 
					System.out.print("바꿀 정보를 입력하세요 : ");
					String input14 = sc.nextLine();
					bookList.get(i).setPublisher(input14); 
					System.out.println("수정이 완료되었습니다.");
					break;
				case 0 : System.out.println("수정을 종료합니다."); 
					break;
				default : System.out.println("번호를 잘못 입력하셨습니다.");
					
				}
		
			} 
		
		}
	}
	
	
	
	
	public void removeBook() throws InputMismatchException{
	
		System.out.println("===도서 정보 삭제===");	
		
		System.out.print("삭제할 책 번호를 입력해주세요 : ");
		
		int input15 = sc.nextInt();
		
		
		
		for (int i = 0; i<bookList.size(); i++) {
			
			if(input15 == bookList.get(i).getBookNum()) {
				
				Book temp = bookList.remove(i);
				bookList.remove(i);
				
				System.out.println("[" + temp.getName() + "]의 정보가 삭제되었습니다.\n");
				break;
				
			} 
		}
		
	}
	


	
	List<Book> favList = new LinkedList<Book>();
	
	public void addFav() throws InputMismatchException {
		System.out.println("===좋아요(즐겨찾기) 추가===");	
		System.out.print("추가할 책 번호를 입력해주세요 : ");
		
		int input16 = sc.nextInt();
		
		for (int i = 0; i<bookList.size(); i++) {
			
			if(input16 == bookList.get(i).getBookNum()) {
				
				Book temp = bookList.get(i);
				favList.add(bookList.get(i));
				
				System.out.println("[" + temp.getName() +"] 추가되었습니다.");
				System.out.println("즐겨찾기 책 정보");
				System.out.println(favList);
				System.out.println();
				break;
			}
		}
		
		
		
	}
	
	
	public void removeFav() throws InputMismatchException {
		System.out.println("===좋아요(즐겨찾기) 삭제===");	
		System.out.print("즐겨찾기에서 삭제할 책 번호를 입력해주세요 : ");
		
		int input17 = sc.nextInt();
		
		if (favList.size() >0) {
			for (int i = 0; i<favList.size(); i++) {
				
				if(input17 == favList.get(i).getBookNum()) {
					
					Book temp = favList.get(i);
					favList.remove(i);
					System.out.println("[" + temp.getName() +"] 즐겨찾기에서 삭제되었습니다.\n");

				}
			}
		} 
		
		
	}

	
} // public class BookService
