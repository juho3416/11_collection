package edu.kh.collection.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.model.vo.Member;

public class SetService {
	
	// Set(집합)
	// - 순서를 유지하지 않음(== 인덱스 없음)
	// - 중복을 허용하지 않는다. (null도 중복X, 1개만 저장 가능)
	
	// *** Set이 중복을 확인하는 방법 ***
	// -> 객체가 가지고 있는 필드값이 모두 같으면 중복으로 판단
	// --> 이 때, 필드값이 모두 같은지 비교하기 위해서
	//		객체에 "equals()"가 반드시! 오버라이딩 되어있어야 한다.
	
	public void ex1() {
		
		Set<String> set = new HashSet<String>();
		
		// HashSet : Set의 대표적인 자식 클래스
		// 사용조건 1 : 저장되는 객체에 equals() 오버라이딩 필수
		// 사용조건 2 " 저장되는 객체에 hashCode() 오버라이딩 필수
		
		// ** Hash 라는 단어가 붙은 컬렉션은 반드시 저장되는 객체에 
		// equals(), hashCode() 오버라이딩 해야함.
		//(String은 내부적으로 equals()와 hasCode 오버라이딩 한것.)
		
		
		set.add("네이버");
		set.add("카카오");
		set.add("쿠팡");
		set.add("당근마켓");
		set.add("배민");
		set.add("배민");
		set.add("배민");
		set.add(null);
		set.add(null);
		set.add(null);
		
		System.out.println(set); //[null, 당근마켓, 카카오, 네이버, 쿠팡, 배민]
		// 확인된것 : 순서X / 중복X / null도 중복X
		
		// size() : 저장된 데이터의 개수 반환
		System.out.println("저장된 데이터 수 : " + set.size());
		//6
		
		// remove(String e) : Set에 저장된 객체 중 매개변수 e와 
		//					  필드값이 같은 객체를 제거
		
		System.out.println( set.remove("당근마켓")); //true
		System.out.println( set.remove("라인")); //false
		
		System.out.println(set); //[null, 카카오, 네이버, 쿠팡, 배민]
		
		// Set은 순서가 없어서 저장된 객체 하나를 얻어올 수 있는 방법이 없다!
		// -> 대신에 Set 전체의 데이터를 하나씩 반복적으로 얻어올 순 있다!
		
		// 1. Iterator(반복자)
		
		// - 컬렉션에서 제공하는 컬렉션 객체 반복 접근자
		// ( 컬렉션에 저장된 데이터를 임의로 하나씩 반복적으로 꺼내는 역할 )
		
		Iterator<String> it = set.iterator();
		// Itrator가 얻어온 데이터의 타입은 모두 String임을 알려줌.
		
		// set.iterator() : Set을 Iterator로 하나씩 꺼내갈 수 있는 모양으로 변환
		
		while(it.hasNext()) { // hasNext() : 다음 값이 있으면 true반환
			
			// it.next() : 다음 값(객체)을 얻어옴
			System.out.println( it.next() );
		}
		
		System.out.println("-----------------------------");
		
		//2. 향상된 for문 사용
		// for(하나씩 꺼내서 저장할 변수 : 컬렉션)
		for(String temp:set) {
			System.out.println(temp);
		}

	}
	
	
	
	public void ex2() {
		
		Set<Member> memberSet = new HashSet<Member>();
		
		memberSet.add( new Member("user01", "pass01", 30) );
		memberSet.add( new Member("user01", "pass01", 30) );
		memberSet.add( new Member("user02", "pass02", 25) );
	
		for(Member mem : memberSet) {
			System.out.println(mem);
		}
		
		// hashCode와 equals에 오버라이딩 안하면
		// Member [id=user01, pw=pass01, age=30]
		// Member [id=user02, pw=pass02, age=25]
		// Member [id=user01, pw=pass01, age=30]
		
		// hashCode와 equals 오버라이딩 하면
		// Member [id=user01, pw=pass01, age=30]
		// Member [id=user02, pw=pass02, age=25]
		
		// Object의 equals(), hasCode() 오버라이딩
		
		// A.equals(B) : A와 B가 가지고 있는 필드 값이 모두같으면 true, 아니면 false
		
		// Hash 함수 : 입력된 단어를 지정된 길이의 문자열로 변환하는 함수 (절대 중복되지 않음.)
		// ex) 입력 : 111 -> "asdfg"(5글자)
		// ex) 입력 : 1233242 -> "qwezg"(5글자)
		// 지정된 길이로 중복되지 않지 않게 변환.
		
		// hashCode() : 필드 값이 다르면 중복되지 않는 숫자를 만드는 메서드
		
		// -> 왜 만들까? 빠른 데이터 검색을 위해서 (객체가 어디에 있는지 빨리 찾기 위해서)
		
		// HashSet() : 중복 없이 데이터 저장하고, 데이터 검색이 빠름(Hash 덕분에)
		
		
	}
	
	
	
	public void ex3() {
		
		// Wrapper 클래스 : 기본 자료형 -> 객체로 포장하는 클래스
		
		// - 컬렉션에 기본 자료형 값을 저장할 때 사용
		// - 기본 자료형에 없던 추가 기능, 값을 이용하고 싶을 때 사용
		
		//<Wrapper 클래스 종류>
		// int -> Integer
		// char -> Character
		// 나머지는 첫글자만 대문자로
		// double -> Double
		// boolean -> Boolean
		// float -> Float
		// byte -> Byte
		// short -> Short
		// long -> Long
		
		int iNum = 10;
		double dNum = 3.14;
		
		//기본 자료형 -> 포장
		Integer w1 = new Integer(iNum); // int가 Integer로 포장
		Double w2 = new Double(dNum);
		// 삭제선 == 해당 구문은 삭제될 예정이다.
		// ==> 사용을 권장하지 않는다.
		
		
		// Wrapper 클래스 활용
		
		System.out.println( "int 최대값 : " + w1.MAX_VALUE);
		System.out.println( "dobule 최소값 : " + w2.MIN_VALUE);
		// 기울어진 글씨? == static
		// 노란색 줄 워닝 : 
		// static은 클래스명.필드명 / 클래스명.메소드명() 호출가능
		
		System.out.println("static 방식으로 Wrapper 클래스 사용하기");
		
		System.out.println( "int 최대값 : " + Integer.MAX_VALUE);
		System.out.println( "dobule 최소값 : " + Double.MIN_VALUE);
		
		// **************************************************
		
		// parsing : 데이터 형식을 변환
		
		int num1 = Integer.parseInt("100"); 
		// 문자열 "100"을 int 형식으로 변환
		double num2 = Double.parseDouble("1.23456");
		// 문자열 "1.23456"을 double 형식으로 변환
		
		System.out.println( num1 + num2 );
		//문자면 연결, 숫자면 더하기.
		//101.23456
	}
	
	
	
	
	public void ex4() {
		
		// Wrapper 클래스의 AutoBoxing / AutoUnboxing
		
		Integer w1 = new Integer(100);
		
		Integer w2 = 100;
		Integer w3 = 200;
	// (Integer형)  (int형->Integer) 자동포장
		
		// w2와 100은 원래 연산이 안되어야 하지만 
		// Integer는 int의 포장 형식이라는 것을 Java가 인식하고 있어서
		// 위와 같은 경우 int를 Integer로 자동 포장해준다. 
		// (AutoBoxing)
		
		
		System.out.println("w2 + w3 = " + (w2 + w3));
		
		// w2 ( Integer 객체 )
		// w3 ( Integer 객체 )
		// w2 + w3 == 객체 + 객체 --> 원래는 불가능
		
		// Integer는 int의 포장형태라는걸 Java가 인식하고 있어서
		// + 연산 시 포장을 벗겨내고
		// Integer + Integer -> int + int (자동 포장 해제)
		// (AutoUnboxing)
		
	}
	
	
	
	
	public void lotto() {
		
		// 로또 번호 생성기 Version.2
		
		// 6개 난수 1 ~ 45 사이
		// 중복X
		
// 내가 푼 것.
//		Set lotto = new HashSet();
//				
//		lotto.add(   ( (int)(Math.random()*45 +1 ) )   );
//		lotto.add(   ( (int)(Math.random()*45 +1 ) )   );
//		lotto.add(   ( (int)(Math.random()*45 +1 ) )   );
//		lotto.add(   ( (int)(Math.random()*45 +1 ) )   );
//		lotto.add(   ( (int)(Math.random()*45 +1 ) )   );
//		lotto.add(   ( (int)(Math.random()*45 +1 ) )   );
//		
//		System.out.println(lotto);
//      //정렬은 안된듯...
		
		
		
		
		// 로또 번호 생성기 Version.2
		
		// 6개 난수 1 ~ 45 사이
		// 중복X
		
		//Set<Integer> lotto = new HashSet<Integer>();
		// HashSet은 자동정렬이 안되므로
		
		Set<Integer> lotto = new TreeSet<Integer>();	
		// 자동정렬 Set
		
		//Set<Integer> lotto = new LinkedHashSet<Integer>();
		//나온 순서 유지 Set
		
		// Integer는 equals(), hashcode() 이미 오버라이딩 완료상태
		
		while( lotto.size() <6 ) {
			//lotto에 저장된 값이 개수가 6개 미만이면 반복
			
			int random = (int)( Math.random() *45 + 1 );
			
			System.out.println(random);
			
			lotto.add(random);
			// int값이 자동으로 Integer로 포장되어 lotto에 추가
			
		}
		
		System.out.println("로또 번호 : " + lotto);
		
	}
		
}