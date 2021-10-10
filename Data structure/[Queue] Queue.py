##################
#   기본 Queue   #
##################

# Queue(): 가장 일반적인 큐 자료 구조
import queue

data_queue = queue.Queue()

# funcoding, 1이라는 data를 넣는 코드
data_queue.put("funcoding")
data_queue.put(1)

# Queue의 사이즈 확인
data_queue.qsize()

# Data를 꺼내올때는 get을 사용
data_queue.get()

data_queue.qsize()

data_queue.get()
