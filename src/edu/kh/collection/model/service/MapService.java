package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kh.collection.model.vo.Member;

public class MapService {

	// Map : Key와 Value 한 쌍이 데이터가 되어 이를 모아둔 객체
	
	// - Key를 모아두면 Set의 특징 (중복X)
	// - Value를 모아두면 List의 특징 (중복O)
	
	public void ex1() {
		
		// HashMap<K, V> : Map의 자식 클래스 중 가장 대표되는 Map
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		//Map.put(Integer Key, String Value) : 추가
		map.put(1, "홍길동");
		map.put(2, "고길동");
		map.put(3, "김길동");
		map.put(4, "박길동");
		map.put(5, "이길동");
		map.put(6, "최길동");
		
		// key 중복
		// key는 중복허용X.
		// key 중복해볼때
		map.put(1, "홍홍홍"); 
		// 중복허용하지않는대신, value를 덮어쓰기함.
		
		// value 중복
		map.put(7,  "최길동");
		// key가 다르면, value 중복은 상관 없음.
		
		System.out.println( map ); // map.toString() 오버라이딩 되어있음.
	}
	
	
	
	public void ex2() {
		
		// Map 사용 예제
		
		//VO(값 저장용 객체)는 특정 데이터 묶음의 재사용이 많은 경우 주로 사용
		// -> 재사용이 적은 VO는 오히려 코드 낭비
		// -> Map을 이용해서 VO와 비슷한 코드를 작성할 수 있다.
		
		// 1) VO버전
		Member mem = new Member();
		
		// 값세팅
		mem.setId("user01");
		mem.setPw("pass01");
		mem.setAge(30);
		
		// 값 출력
		System.out.println( mem.getId() );
		System.out.println( mem.getPw() );
		System.out.println( mem.getAge() );
		
		System.out.println("------------------------------");
		
		
		// 2) Map 버전
		
		Map<String, Object> map = new HashMap<String, Object>();
		// value가 Object 타입 == 어떤 객체든 Value에 들어올 수 있다.
		//						  (문자와 숫자를 동시에 가능)
		
		// 값세팅
		map.put("id", "user02");
		map.put("pw", "pass02");
		map.put("age", 25);
		
		//값출력 (키와 연결된 밸류 출력)
		System.out.println( map.get("id"));
		System.out.println( map.get("pw"));
		System.out.println( map.get("age"));
		
		//한번 쓸 것은 Map을 쓰는 것이 코드, 메모리 관리에 효율적.
		
		System.out.println("------------------------------");
		
		
		// **** Map에 저장된 데이터 순차적으로 접근하기 ****
		
		// Map에서 Key만 모아두면 Set의 특징을 가진다.
		// -> 이를 활용할 수 있도록 Map에서
		//	  keySet() 메서드 제공
		// -> Key만 모아서 Set으로 반환
		
		Set<String> set = map.keySet(); // id, pw, age가 저장된 Set 반환
		
		System.out.println("keySet() : " + set);
		
		// 향상된 for문
		for (String key : set) {
			System.out.println( map.get(key) );
		}
		
		// map에 저장된 데이터가 많거나
		// 어떤 key가 있는지 불분명할때
		// 또는 map에 저장된 모든 데이터에 접근해야할 때
		// keySet() + 향상된 for문 코드 사용

	}
	
	
	
	
	public void ex3() {
		
		List< Map<String, Object> > list = new ArrayList< Map<String, Object>>();
		
		for(int i=0; i <10; i++) {
			
			// Map 생성
			Map<String, Object> map = new HashMap<String, Object>();
			
			// Map에 데이터 추가
			map.put("id", "user0" + i);
			
			// Map을 List에 추가
			list.add(map);
		}
		
		//for문 종료시 list에 10개의 Map객체가 추가되어 있다.
		
		for( Map<String, Object> temp : list) {
			System.out.println( temp.get("id"));
			//키값 찍으면 밸류값 나옴.
		}
	}
	
}
