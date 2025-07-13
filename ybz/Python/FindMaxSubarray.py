def findSubArray(array):
    print()

print("Enter an array of positive and negative numbers (seperate each index with spaces): ")

array = input()
array = array.split()
for n in range(len(array)):
    array[n] = int(array[n])

print(array)

maxSum = array[0]
curSum = 0

for n in array:
    if (curSum + n > n):
        curSum+=n
    else:
        curSum=n
    if (curSum > maxSum):
        maxSum = curSum

print(f'largest sum is: {maxSum}')