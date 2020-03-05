package coding_test;
import java.util.ArrayList;

/**
 * @작성자 : YunTeaIl
 * @작성일자 : 2020. 3. 4.
 * @프로그램 설명 : 2018 KAKAO BLIND RECRUITMENT > 다트 게임
 */
public class solution_8 {

	public static void main(String[] args) {
		String dartResult= "";
		solution(dartResult);
	}
	
	public static int solution(String dartResult) {

		int answer = 0;
		int subSum = 0;

		boolean isNum = false;
		boolean star = false;
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i <= dartResult.length() - 1; i++) {
			if (Character.isDigit(dartResult.charAt(i))) {
				if(Character.isDigit(dartResult.charAt(i + 1))) {
					subSum = Integer.parseInt(String.valueOf(dartResult.charAt(i)) 
							+ Integer.parseInt(String.valueOf(dartResult.charAt(i +1))));
					i += 1;
				} else {
					subSum = Integer.parseInt(String.valueOf(dartResult.charAt(i)));
				}
				isNum = true;
			} else if (isNum) {
				switch (String.valueOf(dartResult.charAt(i))) {
				case "S":
					subSum = subSum * 1;
					list.add(subSum); 
					break;
				case "D":
					subSum = subSum * subSum;
					list.add(subSum);
					break;
				case "T":
					subSum = subSum * subSum * subSum;
					list.add(subSum);
					break;
				case "*":
					if(list.size() == 3) {
						for (int j = 1; j < list.size(); j++) {
							list.set(j, list.get(j) * 2);
						}
					} else {
						for (int j = 0; j < list.size(); j++) {
							list.set(j, list.get(j) * 2);
						}
					}
					star = true;
					break;
				case "#":
					if(star) {
						if(list.size() == 3) {
							for (int j = 1; j < 3; j++) {
								list.set(j, list.get(j) * (-1));
							}
						} else {
							for (int j = 0; j < 3; j++) {
								list.set(j, list.get(j) * (-1));
							}
						}
					} else {
						list.set(list.size()-1, list.get(list.size()-1) * (-1));
					}

					break;
				default:
					break;
				}
				
			}
		}

		for (Integer integer : list) {
			answer += integer;
		}
		
		return answer;
	}
	
	
}
