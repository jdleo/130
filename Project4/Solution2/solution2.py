#!/bin/python3

import sys

#helper function to print array in the format we want
def printArr(arr):
    #convert every element to string from int
    arr = [str(i) for i in arr]
    #print array with space in between each element
    print(" ".join(arr))


def insertionSort1(n, arr):
    #get a reference to the number in the right
    r = arr[len(arr) - 1]
    
    #flag for if arr is sorted or not
    sorted = False
    
    #keep going as long as arr is not sorted
    index = len(arr) - 2
    while (not sorted):
        #if index is -1, it means the that r is the lowest value
        #so it goes at the front
        if index == -1:
            arr[0] = r
            sorted = True
        elif arr[index] > r:
            arr[index+1] = arr[index]
        elif arr[index] < r:
            arr[index+1] = r
            sorted = True
        printArr(arr)
        index -= 1


if __name__ == "__main__":
    n = int(input().strip())
    arr = list(map(int, input().strip().split(' ')))
    insertionSort1(n, arr)
