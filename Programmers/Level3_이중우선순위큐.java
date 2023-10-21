import java.util.*;

class Solution {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		List<Integer> numbers = new ArrayList<>();

		for (String o : operations) {
			if (o.equals("D -1")) {
				if (numbers.isEmpty()) {
					continue;
				}

				numbers.remove(0);
			} else if (o.equals("D 1")) {
				if (numbers.isEmpty()) {
					continue;
				}
				numbers.remove(numbers.size() - 1);
			} else {
				String[] splited = o.split(" ");
				numbers.add(Integer.parseInt(splited[1]));
				Collections.sort(numbers);
			}
		}

		if (!numbers.isEmpty()) {
			answer[1] = numbers.get(0);
			answer[0] = numbers.get(numbers.size() - 1);
		}

		return answer;
	}
}
