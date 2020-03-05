package coding_test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @작성자 : YunTeaIl
 * @작성일자 : 2020. 3. 4.
 * @프로그램 설명 : 서머코딩/윈터코딩(~2018) > 스킬트리
 */
public class solution_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

		System.out.println(solution(skill, skill_trees));

	}

	   public static int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
	        Iterator<String> it = skillTrees.iterator();

	        while (it.hasNext()) {
	            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
	                it.remove();
	            }
	        }
	        answer = skillTrees.size();
	        return answer; 
	    }

}
