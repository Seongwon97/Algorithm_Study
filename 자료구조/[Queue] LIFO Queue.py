##################
#   LIFO Queue   #
##################

# LifoQueue(): 나중에 입력된 데이터가 먼저 출력되는 구조 (스택 구조라고 보면 됨)
import queue
data_queue = queue.LifoQueue()

data_queue.put("funcoding")
data_queue.put(1)

# Queue의 사이즈 확인
data_queue.qsize()

# Data를 꺼내올때는 get을 사용
data_queue.get()
