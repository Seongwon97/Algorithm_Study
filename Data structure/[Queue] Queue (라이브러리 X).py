queue_list = list()

def enqueue(data):
    queue_list.append(data)
    
def dequeue():
    data = queue_list[0]
    del queue_list[0]
    return data

# del을 하면 해당 데이터가 삭제됨!!


# 데이터 삽입
for index in range(10):
    enqueue(index)


len(queue_list)

# 데이터 빼내
dequeue()
