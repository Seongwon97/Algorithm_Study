class Heap:
    def __init__(self, value):
        self.array = list()
        self.array.append(None)
        self.array.append(value)
    
    def insert_check(self, inserted_idx):
        if inserted_idx <= 1:
            return False
        parent_idx = inserted_idx // 2
        if self.array[inserted_idx] > self.array[parent_idx]:
            return True
        else:
            return False
    
    def insert(self, value):
        if len(self.array) == 1:
            self.array.append(None)
            self.array.append(value)
            return True
        
        self.array.append(value)
        inserted_idx = len(self.array) - 1
        
        while self.insert_check(inserted_idx):
            parent_idx = inserted_idx // 2
            self.array[inserted_idx], self.array[parent_idx] = self.array[parent_idx], self.array[inserted_idx]
            inserted_idx = parent_idx
        return True
    
    
    def delete_check(self, delete_idx):
        left_child = delete_idx * 2
        right_child = delete_idx * 2 + 1
        
        # child 가 모두 없을 때
        if left_child >= len(self.array):
            return False
        
        # left child만 있을 때
        elif right_child >= len(self.array):
            if self.array[delete_idx] < self.array[left_child]:
                return True
            else:
                return False

        # child가 모두 있을 때
        else:
            if self.array[left_child] > self.array[right_child]: 
                if self.array[delete_idx] < self.array[left_child]:
                    return True
                else:
                    return False
            else:
                if self.array[delete_idx] < self.array[right_child]:
                    return True
                else:
                    return False
        
        
    def delete(self):
        if len(self.array) <= 1:
            return None
        
        delete_data = self.array[1]
        self.array[1] = self.array[-1]
        del self.array[-1]
        delete_idx = 1
        
        while self.delete_check(delete_idx):
            left_child = delete_idx * 2
            right_child = delete_idx * 2 + 1
            
            # left child만 있을 때
            if right_child >= len(self.array):
                if self.array[delete_idx] < self.array[left_child]:
                    self.array[delete_idx], self.array[left_child] = self.array[left_child], self.array[delete_idx]
                    delete_idx = left_child


            # child가 모두 있을 때
            else:
                if self.array[left_child] > self.array[right_child]: 
                    if self.array[delete_idx] < self.array[left_child]:
                        self.array[delete_idx], self.array[left_child] = self.array[left_child], self.array[delete_idx]
                        delete_idx = left_child
                else:
                    if self.array[delete_idx] < self.array[right_child]:
                        self.array[delete_idx], self.array[right_child] = self.array[right_child], self.array[delete_idx]
                        delete_idx = right_child
                        
        return delete_data
