package coding_test;
import java.util.Arrays;

/**
 * @작성자 : YunTeaIl
 * @작성일자 : 2020. 3. 4.
 * @프로그램 설명 : 서머코딩/윈터코딩(~2018)> 예산  
 */
public class solution_1 {
	public static void main(String[] args) {
		int[] d = {1,3,2,5,4};
		int budget = 9;
		solution(d, budget);
	}
	
	public static int solution(int[] d, int budget) {
		int answer = 0;
		int sum = 0;
		Arrays.sort(d);
		for(int i=0; i<d.length; i++) {
			sum += d[i];
			if(budget >= sum) {
				answer++;
			}
		}
		return answer;
	}
}
