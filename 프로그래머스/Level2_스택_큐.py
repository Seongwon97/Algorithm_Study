def solution(progresses, speeds):
    answer = []
    front = 0
    count = 1
    for i in range(100):
        for j in range(len(progresses)):
            progresses[j] += speeds[j]
            
        if progresses[front] >= 100:
            for k in range(front+1, len(progresses)):
                if progresses[k] >= 100:
                    front += 1
                    count += 1
                else:
                    break
            front += 1
            answer.append(count)
            
            count = 1
            
        
        if front == len(progresses):
            print(answer)
            break
                    
    return answer
