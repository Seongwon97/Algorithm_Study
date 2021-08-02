def solution(n):
    strN = str(n)
    answer = 0
    strN = sorted(strN, reverse=True) 
    temp = "".join(strN)
    answer = int(temp)
    
    return answer
