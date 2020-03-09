package coding_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @작성자 : YunTeaIl
 * @작성일자 : 2020. 3. 9.
 * @프로그램 설명 : 2019 KAKAO BLIND RECRUITMENT > 실패율
 * @ 정확성이 70.4인데 어떤 케이스에서 처리가 누락되는지 모르겠다...
 */
public class solution_13 {

	public static void main(String[] args) {

//		int N = 5;
//		int N = 4;
		int N = 2;
//		int stages[] = { 2, 1, 2, 6, 2, 4, 3, 3 };
//		int stages[] = { 4,4,4,4,4 };
		int stages[] = {3, 3, 3, 3, 3, 3};

		solution(N, stages);
	}

	public static int[] solution(int N, int[] stages) {
		int[] answer = {};
		
		// 전체 사용자 수
		int user = stages.length;
		// 스테이지 통과 사용자 수
		int clearUser = stages.length;
		// 스테이지 및 실패율 map
		HashMap<Double, String> map = new HashMap<Double, String>(); 
		// 실패율 list
		List<Double> list = new ArrayList<Double>();
		HashSet<Double> set = new HashSet<>(list);
		
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 0; j < user; j++) {
				if(i == stages[j]) {	// 스테이지 통과한 유저 체크
					cnt++;
				}
			}
			
			if(map.containsKey((double)cnt/clearUser)) {
				map.put((double)cnt/clearUser, String.format("%s,%s", map.get((double)cnt/clearUser), i));
			} else {
				map.put((double)cnt/clearUser, String.valueOf(i));
			}
			set.add((double)cnt/clearUser);
			clearUser -= cnt;
		}
		
		list = new ArrayList<>(set);
		
		Collections.sort(list);
		Collections.reverse(list);

		List<Integer> result = new ArrayList<>();
		
		for (Double failRate : list) {
			String value = map.get(failRate);
			if(value.split(",").length > 1) {
				String[] split = value.split(",");
				for (String val : split) {
					result.add(Integer.parseInt(val));
				}
			} else {
				result.add(Integer.parseInt(value));
			}
		}
		answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		
		System.out.println(result);
		
		return answer;
	}

}
