#!/bin/python3

for _ in range(int(input())):
    n, m = list(map(int, input().strip().split(' ')))
    graph = {}
    for i in range(n):
        graph[i+1] = []
    for _ in range(m):
        a, b = list(map(int, input().strip().split(' ')))
        if b not in graph[a]:
            graph[a].append(b)
        if a not in graph[b]:
            graph[b].append(a)

start = int(input())

shortest_paths = [0]*(n+1)
    
    queue = [start]
    next_queue = []
    count = 0
    visited = set()
    while queue:
        vertex = queue.pop(0)
        if shortest_paths[vertex] == 0:
            shortest_paths[vertex] = count
            for next in graph[vertex]:
                if shortest_paths[next] == 0:
                    next_queue.append(next)
        if not queue:
            queue = next_queue
            next_queue = []
            count += 6
del shortest_paths[start]

answer = ""
    for num in shortest_paths[1:]:
        if num == 0:
            answer += (str(-1) + " ")
        else:
            answer += (str(num) + " ")
print(answer)
