#중앙키를 누를 때
def cal_distance(hand, num):
    if num == 0: num += 11
    if hand == 0: hand += 11
    
    #손가락이 이미 중앙에 있는 경우
    if hand in [2, 5, 8, 11]: 
        return (abs(num - hand)) / 3
        
    #손가락이 좌측 또는 우측에 있는 경우
    distance = abs(hand - num)
    if distance in [2, 4]:
        return 2
    elif distance in [5, 7]:
        return 3
    elif distance in [8, 10]:
        return 4
    else: return 1

def solution(numbers, hand):
    answer = ''
    l_hand = 10 #초기값이 *
    r_hand = 12 #초기값이 #
    l_dis = 0
    r_dis = 0
    
    for num in numbers:
        if num in [1,4,7]:
            answer += 'L'
            l_hand = num
            print("L")
        elif num in [3,6,9]:
            answer += 'R'
            r_hand = num
            print("R")

        else:
            l_dis = cal_distance(l_hand, num)
            r_dis = cal_distance(r_hand, num)
            print(type(l_dis))
            print(type(r_dis))
            if l_dis > r_dis: #왼손의 거리가 더 멀면 오른손이 클릭
                answer += 'R'
                r_hand = num
            elif l_dis < r_dis: #오른손의 거리가 더 멀면 왼손이 클릭
                answer += 'L'
                l_hand = num
            else: #거리가 같으면 왼손잡이면 왼손으로 오른손잡이면 오른손으로 클릭
                if hand == 'right':
                    answer += 'R'
                    r_hand = num
                else:
                    answer += 'L'
                    l_hand = num 
    return answer
