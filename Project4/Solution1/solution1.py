#!/bin/python3

import sys

def introTutorial(V, arr):
    #enumerate array and iterate through
    for (index, element) in enumerate(arr):
        #if current element == V, then return the index
        if element == V:
            return index



if __name__ == "__main__":
    V = int(input().strip())
    n = int(input().strip())
    arr = list(map(int, input().strip().split(' ')))
    result = introTutorial(V, arr)
    print(result)
