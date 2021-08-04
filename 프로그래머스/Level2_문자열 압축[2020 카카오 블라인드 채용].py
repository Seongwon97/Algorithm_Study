def solution(s):
    answer = len(s)
    final_leng = 0
    for leng in range(1, int(len(s)/2)+1):
        result =''
        start = 0

        
        while start < (len(s)):
            move = leng
            count = 1
            while s[start:(start+leng)] == s[(start+move):(start+move+leng)]:
                move += leng
                count += 1
            
            if count > 1: 
                result += str(count) + s[start:(start+leng)] 
            elif len(s[start:]) < leng:
                result += s[start: ] 
            else: 
                result += s[start:(start+leng)] 
                
            start += move
                    
        if len(result) < answer:
            answer = len(result)

    return answer
