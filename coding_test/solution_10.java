package coding_test;

public class solution_10 {

	public static void main(String[] args) {

		String[] strs = { "ba", "na", "n", "a" };
		// String[] strs = { "app","ap","p","l","e","ple","pp"};
		// String[] strs = { "ba","an","nan","ban","n" };
		String t = "banana";
		// String t = "apple";

		System.out.println(solution(strs, t));

	}

	public static int solution(String[] strs, String t) {
		int answer = 0;

		answer = Integer.MAX_VALUE;
		int[] dp = new int[t.length()];

		for (int i = 1; i < t.length() + 1; i++) {
			for (int j = 0; j < strs.length; j++) {

				String puzzle = strs[j];
				if (i - puzzle.length() < 0)
					continue;
				if (puzzle.equals(t.substring(i - puzzle.length(), i))) {
					if (i - puzzle.length() == 0) {
						dp[i - 1] = 1;
						continue;
					}
					if (dp[i - puzzle.length() - 1] > 0) {
						dp[i - 1] = dp[i - 1] == 0 ? dp[i - puzzle.length() - 1] + 1
								: Math.min(dp[i - 1], dp[i - puzzle.length() - 1] + 1);
					}
				}
			}
		}

		answer = dp[dp.length - 1];
		if (answer == 0)
			return -1;
		return answer;

	}


}
