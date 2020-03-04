import java.util.Arrays;

public class solution_1 {

	public static void main(String[] args) {
		
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
