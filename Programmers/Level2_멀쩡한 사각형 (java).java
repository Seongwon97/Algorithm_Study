class Solution {
    public long solution(int w, int h) {
        long answer;
        
        int whGcd = gcd(w, h);
        long wRate = (long)w/whGcd;
        long hRate = (long)h/whGcd;

        answer = (long)w*(long)h - (wRate+hRate-1) * whGcd;
        
        return answer;
    }
    
    public int gcd(int a, int b){
        if(a%b == 0) return b;
        else return gcd(b, a%b);
    }
}