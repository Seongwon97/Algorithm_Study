class Node:
    def __init__(self, data, next=None):
        self.data = data
        self.next = next
        
class NodeControl:
    def __init__(self, data):
        self.head = Node(data)
    
    # Data 삽입
    def insert(self, data):
        if self.head == '':
            self.head = Node(data)
        
        else:
            node = self.head
            while node.next:
                node = node.next
            
            node.next = Node(data)
    
    # data 삭제
    def delete(self, data):
        if self.head == '':
            print("The list is empty")
            return False
        
        if self.head.data == data:
            temp = head
            head = head.next
            del temp
        else:
            node = self.head
            while node.next:
                if node.next.data == data:
                    temp = node.next
                    node.next = node.next.next
                    del temp
                    print("Delete completed")
                else:
                    node = node.next
    
    # Linked list data출력
    def printing(self):
        node = self.head
        while node:
            print(node.data)
            node = node.next
                    
        
