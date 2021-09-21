parent = dict() # 부모 node에 대한 값을 저장
rank = dict() # 각각의 node의 rank번호


def find(node): # Root node를 탐색
    # path compression 기법
    if parent[node] != node: # 자신이 root node가 아닌지 확인(자신의 부모가 자신이 아닌지 체크)
        parent[node] = find(parent[node]) # 자신의 부모가 자신이 아니라면 부모node의 부모를 찾는다. (recursive하게 호출)
    return parent[node] 


def union(node_v, node_u): # 두 node의 set을 합친다.
    root1 = find(node_v)
    root2 = find(node_u)
    # 각각의 root node를 알아내고 Rank를 비교
    
    # union-by-rank 기법
    if rank[root1] > rank[root2]: # Root1의 rank가 더 높은지 확인
        parent[root2] = root1 # Root2를 1에 연결
    else: # rank가 동일하거나 2가 더 큰 경우
        parent[root1] = root2 # rank가 동일하거나 2가 더 큰 경우 root1을 root2에 연결
        if rank[root1] == rank[root2]: # rank가 둘 다 같다면 root2의 rank를 1증가
            rank[root2] += 1
    
    
def make_set(node): # 새로운 집합 만들기
    parent[node] = node # 새로운 Set이라 해당 node의 parent는 자기 자신이 되며
    rank[node] = 0  # Rank는 자기 자신뿐이라 0이다.

def kruskal(graph):
    mst = list() # mst에는 Cycle이 없는 집합이 들어간다.
    
    # 1. 초기화
    for node in graph['vertices']: # 모든 vertices에 대해서 각각의 집합으로 만든다.
        make_set(node)
    
    # 2. 간선 weight 기반 sorting
    edges = graph['edges']
    edges.sort()
    
    # 3. 간선 연결 (사이클 없는)
    for edge in edges:
        weight, node_v, node_u = edge # (11, 'G', 'F')와 같은 값들을 하나씩 대입
        if find(node_v) != find(node_u): # 두 node의 root node가 다른지 확인
            union(node_v, node_u)  # root node가 다르면 두 집합을 합친다.
            mst.append(edge)
    
    return mst