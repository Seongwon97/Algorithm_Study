#basket에서 인형을 삭제할지 판단하는 함
def determinator(answer, basket):
    if(basket[-1] == basket[-2]):
        basket.pop()
        basket.pop()
        answer += 2
        return answer
    else: 
        return answer

#각각의 칸에서 가장 높은 곳에 있는 인형을 찾는 함수
def find_top(board, m):
    for height in range(len(board)):
        if board[height][m] == 0:
            continue
        else: 
            temp_v = board[height][m]
            board[height][m] = 0
            return temp_v
    
    

def solution(board, moves):
    answer = 0
    basket = [] 
    #크레인으로 옮긴 인형이 쌓일 임시 리스트
    
    for m in moves:
        top = find_top(board, m-1)
        if top is not None:
            basket.append(top)
            if len(basket) > 1:   
                answer = determinator(answer, basket)
        
    return answer
