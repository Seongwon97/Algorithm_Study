######################
#   Priority Queue   #
######################

# PriorityQueue(): 데이터마다 우선순위를 넣어서, 우선순위가 높은 순으로 데이터 출력
## 데이터를 넣을때 우선순위를 같이 넣어서 우선순위가 높은 것부터 빠져나온다.
## 우선순위는 숫자가 낮을수록 높은 것이다!!
## (우선순위, data)로 tuple의 형태로 데이터를 넣는다

import queue

data_queue = queue.PriorityQueue()

data_queue.put((10, "korea"))
data_queue.put((5, 1))
data_queue.put((15, "china"))

data_queue.qsize()

data_queue.get()
