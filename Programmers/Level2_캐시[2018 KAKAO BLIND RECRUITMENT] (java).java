import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        HashMap<String, Integer> cache = new HashMap<>();
        int time = 0;
        String maxKey;
        int maxBit;
        
        for (String city: cities) {
            city = city.toLowerCase(); // 대소문자 구분을 없애기 위해 LowerCase로 변환
            if (cache.containsKey(city)) { // cache hit
                cache.put(city, 0);
                time++;
            }
            else {  // cache miss
                // cache에 빈 공간이 없을 때
                if (cache.size() >= cacheSize) {
                    maxBit = -1;
                    maxKey = "";
                    // Reference Bit이 가장 높은 것 탐색
                    for (String key: cache.keySet()) { 
                        if(cache.get(key) > maxBit) {
                            maxKey = key;
                            maxBit = cache.get(key);
                        }
                    }
                    cache.remove(maxKey);
                }
                cache.put(city, 0); // cache에 값 추가
                
                // cacheSize가 0일 경우 값을 바로 삭제
                if (cacheSize == 0) cache.remove(city); 
                time+=5;
            }
            for (String key: cache.keySet()) { // reference bit증가 
                if (key.equals(city)) { // 참조한 값은 이전에 0으로 초기화하여 pass
                    continue;
                }
                int temp = cache.get(key);
                cache.put(key, ++temp);
            }
        }

        return time;
    }
}