
public class solution_2 {

	public static void main(String[] args) {
		int arr1[] = {9, 20, 28, 18, 11};
		int arr2[] = {30, 1, 21, 17, 28};
		
		System.out.print(solution(5, arr1, arr2));
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = {};
		String[] result = new String[n];
		
		for (int i = 0; i < n; i++) {
			result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
			System.out.println(Integer.toBinaryString(arr1[i] | arr2[i]));
		}

		
		
		for (int i = 0; i < n; i++) {
			result[i] = result[i].replaceAll("1", "#");
			result[i] = result[i].replaceAll("0", " ");
		}
		
		answer = result;
		
		return answer;
	}
}
