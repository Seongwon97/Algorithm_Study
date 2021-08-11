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
