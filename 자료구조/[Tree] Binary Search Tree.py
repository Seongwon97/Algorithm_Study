class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
        
class BinaryTree:
    def __init__(self, node):
        self.head = node


    # value값을 갖고 새로운 Node를 추가하는 함
    def insert(self, value):
        self.currentNode = self.head
        
        while True:
            if value < self.currentNode: # value가 current node보다 작은 경우
                if self.currentNode.left == None:
                    self.currentNode.left = Node(value) # Left node가 없으면 left node가 새로운 node가 된다.
                    break
                else:
                    self.currentNode = self.currentNode.left # Left node가 있으면 해당 node로 이동
                    
            else: # value가 current node보다 같거나 큰 경우
                if self.currentNode.right == None:
                    self.currentNode.right = Node(value)
                    break
                else:
                    self.currentNode = self.currentNode.right
    
    # 해당 값이 tree안에 있는지 탐색하는 함수
    def search(self, value):
        self.currentNode = self.head
        
        while self.currentNode:
            if value == self.currentNode.value:
                return True
            
            elif value < self.currentNode.value:
                self.currentNode = self.currentNode.left
            
            else:
                self.currentNode = self.currentNode.right
        
        return False

        

    
