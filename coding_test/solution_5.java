package coding_test;
import java.util.ArrayList;
import java.util.List;

/**
 * @작성자 : YunTeaIl
 * @작성일자 : 2020. 3. 4.
 * @프로그램 설명 : 서머코딩/윈터코딩(~2018) > 영어 끝말잇기
 */
public class solution_5 {
	public static void main(String[] args) {
		
//		int n = 3;
//		int n = 5;
		int n = 2;
//		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
//		String [] words = { "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive" };
		String [] words = { "hello", "one", "even", "never", "now", "world", "draw"};
		solution(n, words);
	}
	public static int[] solution(int n, String[] words) {
		int[] answer = {};
		answer = new int[2];
		
		// 글자수
		int wordsLength = words.length;
		String word1 = ""; 
		String word2 = "";
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < wordsLength; i++) {
			
			if(i + 1 == wordsLength) {
				break;
			}
			word1 = words[i];
			word2 = words[i+1];
			// 맨 뒤 글자
			word1= word1.substring(word1.length()-1, word1.length());
			// 맨 앞 글자
			word2= word2.substring(0, 1);
			// 맨뒤글자와 맨앞글자가 같을 경우 word1 체인지
			if(word1.equals(word2)) {
				if(list.contains(words[i+1])) {
					answer[0] = (i+1)%n + 1;	//번호
					answer[1] = (i+1)/n + 1;	//차례
					break;
				} else {
					list.add(words[i]);
				}
				// 맨뒤글자와 맨앞글자가 다르면 처리
			} else {
				answer[0] = (i+1)%n + 1;	//번호
				answer[1] = (i+1)/n + 1;	//차례
				break;
			}
		}
		return answer;
	}

}
