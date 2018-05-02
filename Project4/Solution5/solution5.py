#!/bin/python3

import sys
from collections import defaultdict

def size_cc(root, unvisited, edges):
    size = 1
    neighbors = edges[root]
    for neighbor in neighbors:
        if neighbor in unvisited:
            unvisited.remove(neighbor)
            size += size_cc(neighbor, unvisited, edges)
    return size


ncases = int(input().strip())
for _ in range(ncases):
    nl, nr, cl, cr = map(int, input().strip().split(' '))
    if cr > cl:
        print(nl*cl)
        for _ in range(nr):
            input()
        continue
    
    edges = defaultdict(list)
    unvisited = set(range(1, nl + 1))
    for _ in range(nr):
        citya, cityb = map(int, input().strip().split(' '))
        edges[citya].append(cityb)
        edges[cityb].append(citya)
    
    cost = 0
    while len(unvisited):
        root = unvisited.pop()
        cost += cl + cr*(size_cc(root, unvisited, edges) - 1)
    print(cost)
