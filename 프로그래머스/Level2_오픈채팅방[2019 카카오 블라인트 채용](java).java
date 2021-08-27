class Solution {
    public String[] solution(String[] record) {
                
        User[] userList = new User[record.length];
        int count = 0;
        int changeCount = 0;
        for (String message: record){
            String[] strArr = message.split(" ");
            // Enter인데 현재 없는 user면 user객체생성
            if (strArr[0].equals("Enter") && !isExist(userList, strArr[1], count)){
                userList[count] = new User(strArr[1], strArr[2]);
                count++;
            }
            // Enter인데 user의 이름이 바껴서 접속한 경우
            else if(strArr[0].equals("Enter") && isExist(userList, strArr[1], count)){
                int userPosition = findUser(userList, strArr[1], count);
                if(userList[userPosition].getName() != strArr[2]){
                    userList[userPosition].setName(strArr[2]);   
                }
            }
            // 현재 존재하는 User이고 enter이면 이름이 같은지 확인 후 이름이다르면 변경
            else if (strArr[0].equals("Change")){
                int userPosition = findUser(userList, strArr[1], count);
                changeCount++;
                if(userList[userPosition].getName() != strArr[2]){
                    userList[userPosition].setName(strArr[2]);   
                }
            }
            
        }
        
        
        String[] answer = new String[record.length-changeCount];
        // String array의 크기는 length를 사용, length()가 아님
        int temp = 0;
        for (String message: record){
            String[] strArr = message.split(" ");
            if (strArr[0].equals("Enter")){          
                int userPosition = findUser(userList, strArr[1], count);
                //System.out.println(userList[userPosition].getName()+"님이 들어왔습니다.");
                answer[temp] = userList[userPosition].getName()+"님이 들어왔습니다.";
                temp++;
            }
            else if (strArr[0].equals("Leave")){          
                int userPosition = findUser(userList, strArr[1], count);
                //System.out.println(userList[userPosition].getName()+"님이 나갔습니다.");
                answer[temp] = userList[userPosition].getName()+"님이 나갔습니다.";
                temp++;
            }
        }
        
        return answer;
    }
    
    public int findUser(User[] userList, String userId, int count){
        for (int i=0; i< count; i++){
            if(userList[i].getUserId().equals(userId))
                return i;
        }
        return -1;
    }
                
    // userId가 리스트에 존재하는지 확인
    public boolean isExist(User[] userList, String userId, int count){
        if (userList[0] != null) {
            for (int i=0; i<count; i++){
                if (userId.equals(userList[i].getUserId())){
                    return true;
                }
            }
        }
        
        return false;
    }
}

// 유저 정보를 보관하는 class
class User {
    private String userId;
    private String name; 
    
    public User(){}
    
    public User(String userId, String name){
        this.userId = userId;
        this.name = name;
    }
    
    public String getUserId(){
        return userId;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
}