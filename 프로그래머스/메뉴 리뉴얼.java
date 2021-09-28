package programmers;
import java.util.*;
public class menuRenuer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {1,2,3};
		
		solution(orders, course);
	}
	
	public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        HashMap<String, Integer> menu = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (String str: orders) {
            for (int len: course) {
            	result.setLength(0);
            	StringBuilder order = new StringBuilder("ABCFG");
            	makeCombination(menu, order, result, len, 0);
            }
        }
        for(String combi : menu.keySet()) {
        	System.out.println(combi);
        }
        
        return answer;
    }

	public static void makeCombination(HashMap<String, Integer> menu, StringBuilder order, StringBuilder result, int max_depth, int depth) {
		// depth가 max depth보다 낮을 때
		for (int i=0; i< order.length(); i++) {
			result.append(order.charAt(i));
			order.deleteCharAt(i);
			
			// depth가 max depth일때
			if (max_depth == depth+1) {
				int count = 1;
				if (menu.containsKey(result.toString())) {
					 count = menu.get(result.toString()) + 1;	
				}
				menu.put(result.toString(), count);
			}
			else {
				makeCombination(menu, order, result, max_depth, depth+1);
			}
			
		}
		
		

		

		
		
		
	}
}
