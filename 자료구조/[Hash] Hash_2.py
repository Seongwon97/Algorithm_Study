# Chaining기법을 활용한 충돌 해결 알고리즘
# Open Hashing: 해쉬테이블 외에 새로운 저장공간을 만드는 것
# 충돌이 일어나면 Linked list를 사용하여 뒤에 연결 (해시테이블에 새로운 저장공간 생성)
hash_table = list([0 for i in range(8)])

def hash_function(key):
    return key % 8


def save_data(data, value):
    index_key = hash(data) # 동일한 Hash address에 있는 데이터들을 구분하기 위해 사용
    hash_address = hash_function(index_key)
    
    if hash_table[hash_address] != 0: # 0이 아니면 해당 Hash address의 slot이 비어있음
        for index in range(len(hash_table[hash_address])):
            if hash_table[hash_address][index][0] == index_key:
                hash_table[hash_address][index][1] = value
                return 
        hash_table[hash_address].append([index_key, value])
        
    else: # Slot이 비어있지 않은 경우
        hash_table[hash_address] = [[index_key, value]]
    
def load_data(data):
    index_key = hash(data)
    hash_address = hash_function(index_key)
    
    if hash_table[hash_address] != 0:
        for index in range(len(hash_table[hash_address])):
            if hash_table[hash_address][index][0] == index_key:
                return hash_table[hash_address][index][1]
        
        print("Data does not exist.")
        return None
    
    else:
        print("Data does not exist.")
        return None
