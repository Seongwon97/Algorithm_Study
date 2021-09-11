import java.util.*;
class Car {
    String carNum;
    int hour;
    int minute;
    boolean isExist = true; // 주차장 안에 존재하는지 여부
    int fee = 0;
    int parkingTime = 0;
    
    public Car(String carNum, int hour, int minute) {
        this.carNum = carNum;
        this.hour = hour;
        this.minute = minute;
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        // fees는 기본시간, 기본요금, 단위시간, 단위요금
        // records는 출입차시간, 차량번호, 출차정보(in/out)
        
        HashMap<String, Car> carHash = new HashMap<>();
        
        for (String s: records){
            String[] splitStr = s.split(" ");
            String[] time = splitStr[0].split(":");
            
            // 차번호가 HashMap에 없다면 정보를 추가
            if (!carHash.containsKey(splitStr[1])) {
                
                Car carTemp = new Car(splitStr[1], Integer.parseInt(time[0]), Integer.parseInt(time[1]));  
                carHash.put(splitStr[1], carTemp);
            }
            
            // 차가 출차하는 경우
            if (splitStr[2].equals("OUT")) {
                calculateTime(time, carHash.get(splitStr[1]));
            }            
            // 출차하였던 차가 다시 입차하는 경우
            if (splitStr[2].equals("IN") && carHash.containsKey(splitStr[1])) {
                Car carTemp = carHash.get(splitStr[1]);
                carTemp.hour = Integer.parseInt(time[0]);
                carTemp.minute = Integer.parseInt(time[1]);
                carTemp.isExist = true;
            } 
        }
        
        // 차가 입차하고 출차기록이 없는 경우 (11:59 출차로 계산) & answer에 값 추가
        String[] answer = new String[carHash.size()];
        int count = 0;
        for (String s: carHash.keySet()){
            if (carHash.get(s).isExist){
                String[] time = {"23", "59"};
                calculateTime(time, carHash.get(s));
            }
            calculateFee(carHash.get(s), fees);
            
            answer[count] = s+ String.valueOf(carHash.get(s).fee);
            count++;
        }
        
        // 값 정렬 후 출력
        Arrays.sort(answer);
        int[] realAnswer = new int[carHash.size()];
        count = 0;
        for (String s: answer){
            s = s.substring(4, s.length());
            //System.out.println(s);
            
            realAnswer[count] = Integer.parseInt(s);
            count++;
        }
         

        return realAnswer;
    }
    
    public void calculateTime(String[] time, Car car) {
        int outHour = Integer.parseInt(time[0]);
        int outMinute = Integer.parseInt(time[1]);
        
        // 총 시간 계산
        int totalTime = 0;
        if (car.minute < outMinute){
            totalTime += outMinute - car.minute  + (outHour - car.hour)*60;
        }
        else {
            outHour--;
            totalTime += 60+ outMinute - car.minute  + (outHour - car.hour)*60;
        }
        
        car.parkingTime += totalTime;
        car.isExist = false; // 출차완료
    }
    public void calculateFee(Car car, int[] fees){
        
        // 기본 요금보다 낮으면 기본요금만
        if (car.parkingTime <= fees[0])
            car.fee = fees[1];
        
        // 기본요금 이상이면 단위시간요금 더하기
        else {
            car.fee = (int)(Math.ceil((float)(car.parkingTime - fees[0])/fees[2])* fees[3]) + fees[1];
        }

    }
}