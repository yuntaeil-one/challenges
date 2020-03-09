package coding_test;

import java.util.ArrayList;
import java.util.List;

/**
 * @작성자 : YunTeaIl
 * @작성일자 : 2020. 3. 6.
 * @프로그램 설명 : 2018 KAKAO BLIND RECRUITMENT > [1차] 뉴스 클러스터링
 * @ 결과 : 정확성이 53.8.... 좀더 보완을 해야되는 코드
 */
public class solution_12 {

	public static void main(String[] args) {
		String str1 = "FRANCE";
		String str2 = "french";

//		 String str1= "handshake";
//		 String str2 = "shake hands";

//		 String str1 = "aa1+aa2";
//		 String str2 = "AAAA12";

		// String str1= "E=M*C^2";
		// String str2 = "e=m*c^2";

		System.out.println(solution(str1, str2));
	}

	public static <T> int solution(String str1, String str2) {
		int answer = 0;

		char[] char1 = str1.toLowerCase().toCharArray();
		char[] char2 = str2.toLowerCase().toCharArray();

		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();

		for (int i = 0; i < char1.length; i++) {
			if (i == char1.length - 1)
				break;

			String chk = String.valueOf(char1[i]) + String.valueOf(char1[i + 1]);

			if (chk.matches("[a-zA-Z]{2}+")) {
				list1.add(String.valueOf(char1[i]) + String.valueOf(char1[i + 1]));
			}
		}
		for (int i = 0; i < char2.length; i++) {
			if (i == char2.length - 1)
				break;

			String chk = String.valueOf(char2[i]) + String.valueOf(char2[i + 1]);

			if (chk.matches("[a-zA-Z]{2}+")) {
				list2.add(String.valueOf(char2[i]) + String.valueOf(char2[i + 1]));
			}
		}
		
		if(list1.size() * list2.size() == 0) {
			return 65536;
		}
		
		// 교집합
		List<String> list3 = new ArrayList<>();
		list3 = union(list1, list2);

		// 합집합
		int value = intersection(list1, list2, list3);

		answer = (int) ((double) list3.size() / value * 65536);

		return answer;
	}

	// 교집합
	public static <T> List<T> union(List<T> list1, List<T> list2) {
		List<T> list = new ArrayList<T>();
		if (list1.size() < list2.size()) {
			for (T t : list1) {
				if (list2.contains(t)) {
					list.add(t);
				}
			}
		} else {
			for (T t : list2) {
				if (list1.contains(t)) {
					list.add(t);
				}
			}
		}
		return list;
	}

	// 합집합
	public static int intersection(List<String> list1, List<String> list2, List<String> list3) {

		int intersection = 0;
		
		for (String string : list3) {
			list1.remove(string);
			list2.remove(string);
		}
		
		intersection = list3.size() + list1.size() + list2.size();
		
        return intersection; 

	}

}
