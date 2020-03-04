import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class solution_6 {
	public static void main(String[] args) {
//		int nums[] = { 1, 2, 3, 4 };
		int nums[] = { 1, 2, 7, 6, 4 };
		System.out.println(solution(nums));

	}

	public static int solution(int[] nums) {
		int answer = -1;
		// 소수 결과 목록
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		// 3자리 수 체크
		List<Integer> tmp = new ArrayList<>();
		sosu(nums, ret, tmp);
		answer = ret.size();
		return answer;
	}

	// 재귀함수
	public static void sosu(int[] nums, List<List<Integer>> ret, List<Integer> tmp) {

		List<Integer> sortList = new ArrayList<>(tmp);
		
		// base case
		if (tmp.size() == 3) {
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < tmp.size(); i++) {
				sum += tmp.get(i);
			}
			for (int i = 1; i <= sum; i++) {
				if (sum % i == 0) {
					cnt++;
				}
			}
			if (cnt == 2) {
				Collections.sort(sortList);
				if (!ret.contains(sortList)) {
					ret.add(new ArrayList<Integer>(sortList));
				}
			}
			return;
		}

		// 재귀 반복
		for (int num : nums) {
			if (tmp.contains(num))
				continue;
			tmp.add(num);
			sosu(nums, ret, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}

}
