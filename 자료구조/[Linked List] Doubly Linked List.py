class Node:
    def __init__(self, data, pre=None, next=None):
        self.data = data
        self.pre = pre
        self.next = next
        
class NodeControl:
    def __init__(self, data):
        self.head = Node(data)
        self.tail = self.head
    
    
    # Data 삽입
    def insert(self, data):
        if self.head == '':
            self.head = Node(data)
            self.tail = self.head
        
        else:
            node = self.head
            while node.next:
                node = node.next
            
            newNode = Node(data)
            node.next = newNode
            newNode.pre = node
            
            self.tail = newNode
    
    
    # 잎에서부터 탐색 후 data 삭제
    def delete_head(self, data):
        if self.head == '':
            print("The list is empty")
            return False
        
        if self.head.data == data:
            temp = head
            head = head.next
            head.pre = None
            del temp
        else:
            node = self.head
            while node.next:
                if node.next.data == data:
                    temp = node.next
                    node.next = node.next.next
                    node.next.pre = node
                    del temp
                    print("Delete {} completed\n".format(data))
                else:
                    node = node.next
    
    
    # 뒤에서부터 탐색 후 data 삭제
    def delete_tail(self, data):
        if self.tail == '':
            print("The list is empty")
            return False
        
        if self.tail.data == data:
            temp = tail
            if tail.pre:
                tail = tail.pre
            tail.next = None
            del temp
            
        else:
            node = self.tail
            while node.pre:
                if node.pre.data == data:
                    temp = node.pre
                    if node.pre.pre:
                        node.pre = node.pre.pre
                    node.pre.next = node
                    del temp
                    print("Delete {} completed\n".format(data))
                else:
                    node = node.pre
          
        
    # 앞에서부터 탐색
    def search_from_head(self, data):
        if self.head == None:
            return False
    
        node = self.head
        while node:
            if node.data == data:
                return node
            else:
                node = node.next
        return False
    
    
    # 뒤에서부터 탐색
    def search_from_tail(self, data):
        if self.head == None:
            return False
    
        node = self.tail
        while node:
            if node.data == data:
                return node
            else:
                node = node.pre
        return False
    
    
    # Linked list data출력
    def printing(self):
        node = self.head
        print("\nList")
        while node:
            print(node.data)
            node = node.next
                    
        
