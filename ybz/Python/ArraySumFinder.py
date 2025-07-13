# maybe better soluton? this'll do for now

def findSumInArray(array, lookFor):
    if (lookFor < array[0]):
        return False
    for n in array:
        for i in range(n, len(array)):
            if (n + array[i] == lookFor):
                return True
    return False

def sort(array):
    for n in range(len(array)):
        for i in range(len(array)-1-n):
            if (array[i] > array[i+1]):
                temp = array[i+1]
                array[i+1] = array[i]
                array[i] = temp

print("Enter Array (seperate with spaces): ")
array = input()
array = array.split()
for n in range(len(array)):
    array[n] = int(array[n])

print("Enter a Number to Find: ")
number = int(input())
sort(array)

print(findSumInArray(array, number))