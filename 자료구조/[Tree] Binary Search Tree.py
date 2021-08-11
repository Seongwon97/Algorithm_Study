class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
        
class BinaryTree:
    def __init__(self, node):
        self.head = node
        
    def insert(self, value):
        self.currentNode = self.head
        
        while True:
            if value < self.currentNode.value:
                if self.currentNode.left == None:
                    self.currentNode.left = Node(value)
                    break
                else:
                    self.currentNode = self.currentNode.left
                    
            else:
                if self.currentNode.right == None:
                    self.currentNode.right = Node(value)
                    break
                else:
                    self.currentNode = self.currentNode.right
        
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
                
    
    def delete(self, value):
        searched = False
        self.currentNode = self.head
        self.parentNode = self.head
        
        while self.currentNode:
            if self.currentNode.value == value:
                searched = True
                break
            elif value < self.currentNode.value:
                self.parentNode = self.currentNode
                self.currentNode = self.currentNode.left
            else:
                self.parentNode = self.currentNode
                self.currentNode = self.currentNode.right
        
        if searched == False:
            return False
        
        # 삭제하려는 Node가 leaf Node일 때
        if self.currentNode.left == None and self.currentNode.right == None:
            if value < self.parentNode.value:
                self.parentNode.left = None
            else:
                self.parentNode.left = None
            del currentNode
        
        
        # 삭제하려는 Node가 하나의 Child Node를 갖는 경우
        elif self.currentNode.left == None and self.currentNode.right != None:
            if value < self.parentNode.value:
                self.parentNode.left = self.currentNode.right
            else:
                self.parentNode.right = self.currentNode.right
        elif self.currnetNode.left != None and self.currentNode.right == None:
            if value < self.parentNode.value:
                self.parrentNode.left = self.currentNode.left
            else:
                self.parrentNode.right = self.currentNode.left
        
        
        # 삭제하려는 Node가 두개의 child node를 갖는 경우
        elif self.currentNode.left != None and self.currentNode.right != None:
            if value < self.parentNode.value: 
                self.childNode = self.currentNode.right
                self.parent_temp = self.parentNode.right
            while self.childNode:
                if self.childNode.left == None:
                    self.parent_temp = self.childNode
                    self.childNode = self.childNode.left
                    break
                else:
                    self.parent_temp = self.childNode
                    self.childNode = self.childNode.left
            
            if self.childNode.right == None:
                self.parent_temp.left = None
            else:
                self.parent_temp.left = childNode.right
            
            self.parentNode.left = self.childNode
            self.childNode.left = self.currentNode.left
            self.childNode.right = self.currentNode.right
        
        else:
            self.childNode = self.currentNode.right
            self.parent_temp = self.parentNode.right
            while self.childNode:
                if self.childNode.left == None:
                    self.parent_temp = self.childNode
                    self.childNode = self.childNode.left
                    break
                else:
                    self.parent_temp = self.childNode
                    self.childNode = self.childNode.left
            
            if self.childNode.right == None:
                self.parent_temp.left = None
            else:
                self.parent_temp.left = childNode.right
            
            self.parentNode.right = self.childNode
            self.childNode.left = self.currentNode.left
            self.childNode.right = self.currentNode.right
            
        
        return True
                
    
