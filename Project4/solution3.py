#!/bin/python3

import sys

def quickSort(arr):
    #identify the pivot
    pivot = arr[0]
    
    #create arrays for left, right, and equal
    left = []
    right = []
    equal = [pivot]  #equal's only element is the pivot element
    
    #iterate through array
    for item in arr:
        if item > pivot:
            right.append(item)
        elif item < pivot:
            left.append(item)
    
    #return left + equal + right
    return left + equal + right

if __name__ == "__main__":
    n = int(input().strip())
    arr = list(map(int, input().strip().split(' ')))
    result = quickSort(arr)
    print (" ".join(map(str, result)))

