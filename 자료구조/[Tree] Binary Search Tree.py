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
            if value < self.currentNode:
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
        
