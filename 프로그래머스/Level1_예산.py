#내가 작성한 코드
def solution(d, budget):
    answer = 0
    for i in range(len(d)):
        if (budget - min(d)) >= 0:
            budget -= min(d)
            answer += 1
            d[d.index(min(d))] = 100001
        else:
            break
    return answer


#다른 사람의 간결한 코드
"""
def solution(d, budget):
    d.sort()
    while budget < sum(d):
        d.pop()
    return len(d)

"""
