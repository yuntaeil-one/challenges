import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class solution_3 {

	public static void main(String[] args) {
		String[] test = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		solution(test);
	}

	public static String[] solution(String[] record) {
		String[] answer = {};

		HashMap<String, String> codeMap = new HashMap<>();
		codeMap.put("enter", "들어왔습니다.");
		codeMap.put("leave", "나갔습니다.");
		
		HashMap<String, String> enterMap = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		for (String str : record) {
			
			String[] split = str.split(" ");
			String code = split[0];
			String uid = split[1];
			
			// 입장
			if(split.length > 2) {
				String name = split[2];
				enterMap.put(uid, name);
			}
			if(!"Change".equalsIgnoreCase(code)) {
				list.add(code + " " + uid);
			}
		}
		
		answer = new String[list.size()];
		
		for (int i = 0; i < answer.length; i++) {
			
			String[] split = list.get(i).split(" ");
			String name = enterMap.get(split[1]);
			
			answer[i] = String.format("%s님이 %s", name, codeMap.get(split[0].toLowerCase()));
		}
		return answer;
	}
}
