import java.util.HashMap;
class Solution {
    public int solution(String str1, String str2) {		
		int combination = 0; // 합집합 정보
		int intersection = 0; // 교집합 정보
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		// 첫번쨰 string에 대한 값들 hashmap에 추가
		HashMap<String, Integer> map = new HashMap<>();
		for (int i=0; i<str1.length()-1; i++) {
			String subStr = str1.substring(i, i+2);
			// 영문자가 아닌 경우 pass
			if ('a' > subStr.charAt(0) || subStr.charAt(0) > 'z' || 'a' > subStr.charAt(1) || subStr.charAt(1) > 'z') 
				continue;
			
			if (map.containsKey(subStr)) {
				map.put(subStr, map.get(subStr)+1);
			}
			else {
				map.put(subStr, 1);
			}
			combination++;
		}
		
		
		// hashmap에 있는 정보와 string2의 값들을 비교하여 합집합과 교집합 구하기
		for (int i=0; i<str2.length()-1; i++) {
			String subStr = str2.substring(i, i+2);
			// 영문자가 아닌 경우 pass
			if ('a' > subStr.charAt(0) || subStr.charAt(0) > 'z' || 'a' > subStr.charAt(1) || subStr.charAt(1) > 'z') 
				continue;

            // map에 해당 문자가 있는 경우
			if (map.containsKey(subStr)) {	
                int temp = map.get(subStr);
                if (temp == -1) { // 값이 -1이면 두번쨰 문장에서 추가된 것이기에 합집합 +1
                    combination++;
                    continue;
                }
                    
				intersection++;
				// 해당 subString을 겹치는 것을 제외했을때 남는게 없다면 map에서 삭제
				if (--temp <= 0) {
					map.remove(subStr);
					continue;
				}
				map.put(subStr, temp);
			}
			else {		
				map.put(subStr, -1); // 두번쨰 문장에서 추가된 원소는 음수로관리
				combination++;
			}
		}
        // 둘 다 공집합이 되는 경우 return 0;
		if (combination == 0) return 65536; 

        double tmp = (double)intersection/ (double)combination;
        int answer = (int)(65536 * tmp);
		
		return answer;
    }
}