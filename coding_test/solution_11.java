package coding_test;

import java.util.TreeSet;

/**
 * @작성자 : YunTeaIl
 * @작성일자 : 2020. 3. 6.
 * @프로그램 설명 : 찾아라 프로그래밍 마에스터 > 폰켓몬
 */
public class solution_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 1, 2, 3 };
//		int[] nums = { 3,3,3,2,2,4 }; 
//		int[] nums = { 3,3,3,2,2,2 };
		
		System.out.println(solution(nums));
	}

	public static int solution(int[] nums) {
		
		TreeSet<Integer> hs = new TreeSet<>();
		
		for(int i =0; i < nums.length; i++) {
			hs.add(nums[i]);
		}
		if(nums.length/2 < hs.size()) {
			return nums.length /2;
		} else {
			return hs.size();
		}
		
	}
	

}
