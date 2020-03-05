package coding_test;

import java.util.Stack;

/**
 * @작성자 : YunTeaIl
 * @작성일자 : 2020. 3. 5.
 * @프로그램 설명 : 2017 팁스타운 > 짝지어 제거하기
 */
public class solution_9 {
	public static void main(String[] args) {
//		 String dirs = "cdcd";
		String dirs = "baabaa";
		System.out.println(solution(dirs));
	}

	public static int solution(String s) {
		int answer = -1;

		Stack<Character> stack = new Stack<>();
		char[] char_array = s.toCharArray();
		
		for (char c : char_array) {
			stack.push(c);
			if(stack.size() >= 2) {
				
				char first = stack.pop();
				char second = stack.pop();
				
				if(first != second) {
					stack.push(second);
					stack.push(first);
				} 
			}
		}
		if(stack.isEmpty()) {
			answer = 1;
		} else {
			answer = 0;
		}
		return answer;
	}

}
