class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        // matrix초기화
        int[][] matrix = new int[rows][columns];
        int count=1;
        for(int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                matrix[i][j] = count++;
            }
        }
        
        count =0; // 여기서부터는 answer에 데이터를 추가할 index로 사용
        
        System.out.println(queries.length);
        for (int[] query: queries){
            
            // x가 행, y가 열
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            
            int temp = matrix[x1][y1];
            int min = matrix[x1][y1];
            
            for (int i = x1; i < x2; i++){
                matrix[i][y1] = matrix[i+1][y1];
                if (matrix[i][y1] < min) min=matrix[i][y1]; 
            }
            
            for (int i = y1; i < y2; i++){
                matrix[x2][i] = matrix[x2][i+1];
                if (matrix[x2][i] < min) min=matrix[x2][i]; 
            }
            
            for (int i = x2; i > x1; i--){
                matrix[i][y2] = matrix[i-1][y2];
                if (matrix[i][y2] < min) min=matrix[i][y2]; 
            }
            
            for (int i = y2; i > y1; i--){
                matrix[x1][i] = matrix[x1][i-1];
                if (matrix[x1][i] < min) min=matrix[x1][i]; 
            }
            
            matrix[x1][y1+1] = temp;
            answer[count++] = min; 
       
        }     
        return answer;
    }
}