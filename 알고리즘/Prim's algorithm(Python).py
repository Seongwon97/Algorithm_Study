from collections import defaultdict
from heapq import *

def prim(start_node, edges):
    mst = list() # MST의 edge들이 저장되는 list
    adjacent_edges = defaultdict(list) 
    for weight, n1, n2 in edges: # 각각 node별로 인접한 edge의 정보를 넣어준다.
        adjacent_edges[n1].append((weight, n1, n2))
        adjacent_edges[n2].append((weight, n2, n1))

    connected_nodes = set(start_node) # connected_node는 현재 연결된 node들의 set이다.
    candidate_edge_list = adjacent_edges[start_node] # 초기에 시작하는 node의 인접 edge들 list에 추가
    heapify(candidate_edge_list) # 인접한 edge의 list를 heap구조로 변경(pop를 하면 weight이 작은 값부터 나온다.)
    
    while candidate_edge_list: # candidate_edge_list에 데이터가 존재할때 계속 실행
        weight, n1, n2 = heappop(candidate_edge_list)
        if n2 not in connected_nodes: # n1은 이미 접해 있는 것이고, 연결된 n2가 연결 node 집합에 있는지 확인 
            connected_nodes.add(n2) # 없다면 n2를 추가
            mst.append((weight, n1, n2))
            
            for edge in adjacent_edges[n2]: # n2에 연결된 edge들을 candidate_edge_list에 추가
                if edge[2] not in connected_nodes: # n2에 연결된 edge가 conneced_node에 속한 node에 연결된 경우는 추가하지 않음
                    heappush(candidate_edge_list, edge)

    return mst