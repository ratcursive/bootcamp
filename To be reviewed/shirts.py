#0. Define Merge Sort
def merge(left,right):
    leftPos = 0
    rightPos = 0
    mergedLst = []
    while leftPos < len(left) and rightPos < len(right):
        if left[leftPos] < right[rightPos]:
            mergedLst.append(left[leftPos])
            leftPos += 1
        else:
            mergedLst.append(right[rightPos])
            rightPos += 1
    mergedLst += left[leftPos:]
    mergedLst += right[rightPos:]
    return mergedLst

def mergeSort(lst):
    if len(lst) == 1:
        return lst
    mid = len(lst) // 2
    left = mergeSort(lst[:mid])
    right = mergeSort(lst[mid:])
    return merge(left,right)

#1. Gathering Data
cleanShirts, events, days = input().split()
eventDays = []
for i in range(int(events)):
    eventDays.append(int(input()))
#2. sort the events by day when they are going to happen
eventDays = mergeSort(eventDays)
#3. Computation to find out the amount of washes
totalShirts = int(cleanShirts)
cleanShirts = totalShirts
laundryCount = 0
nextEvent = 0
for i in range(int(days)):
    if cleanShirts == 0:
        laundryCount += 1
        cleanShirts = totalShirts
    while nextEvent < len(eventDays) and eventDays[nextEvent]-1 == i:
        cleanShirts += 1
        totalShirts += 1
        nextEvent += 1
    cleanShirts -= 1
print(laundryCount)
