import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        List<Stage> stageList = new ArrayList<>();
        Stage tempStage = new Stage(0);
        for (int i=1; i<=N; i++) {
            stageList.add(new Stage(i));
        }
        
        // Stages의 정보들 반영
        for(int user: stages){
            if (user == N+1) { // 모든 stage를 통과한 경우
                for (int i=0; i<user-1; i++){
                    stageList.get(i).pass++;
                }
            }
            else { // 중간에서 막힌 경우
                for (int i=0; i<user; i++){
                    tempStage = stageList.get(i);
                    if (i==user-1){
                        stageList.get(i).current++;
                        stageList.get(i).pass++;
                    }
                    else {
                        stageList.get(i).pass++;
                    }
                }
            }
        }
        
        // failPercent계산
        for (int i=0; i< N; i++) {
            if (stageList.get(i).pass == 0){
                stageList.get(i).failPercent = 0;
            }
            else {
                stageList.get(i).failPercent = ((float)stageList.get(i).current / stageList.get(i).pass);
            }
        }
        
        // 내림차순으로 정렬
        stageList.sort(Comparator.naturalOrder());
        
        // answer에 stage값들 추가
        for (int i=0; i< N; i++)
        	answer[i] = stageList.get(i).stageNum;
            
        return answer;
    }
}

class Stage implements Comparable<Stage>{
    int stageNum;
    int pass = 0;   // Stage를 통과한 사람 수+ Stage에 있는 사람 수
    int current = 0;   // 현재 Stage에 있는 사람 수
    float failPercent = 0;
    
    public Stage(int stageNum){
        this.stageNum = stageNum;
    }

	@Override
	public int compareTo(Stage o) {
		// TODO Auto-generated method stub
		if (failPercent == o.failPercent)
    		return 0;
    	else if (failPercent < o.failPercent)
    		return 1;
    	else
    		return -1;
	}
}