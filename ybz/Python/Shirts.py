'''
Variables:

- number of starting shirts
- amount of days to evaluate
- number of events

- given the amount of events, each event will be attributed a day which they take place
'''

def eventsInput(numEvents):
    events = []
    for n in range(numEvents):
        events.append(int(input()))
    return events

def sort(array):
    for n in range(len(array)):
        for i in range(len(array)-1-n):
            if (array[i] > array[i+1]):
                temp = array[i+1]
                array[i+1] = array[i]
                array[i] = temp

def sort(array):
    for n in range(len(array)):
        for i in range(n, len(array)-1):
            if (array[i] > array[i+1]):
                temp = array[i+1]
                array[i+1] = array[i]
                array[i] = temp

print("Enter 3 numbers: number of starting shirts, amount of days, number of events (seperate with spaces)")

inputs = input()
inputs = inputs.split()
for n in range(len(inputs)):
    inputs[n] = int(inputs[n])

maxShirts = inputs[0]
numDays = inputs[1]
numEvents = inputs[2]

print("Enter event days (seperate with spaces)")
eventsDays = input()
eventsDays = eventsDays.split()
for n in range(len(eventsDays)):
    eventsDays[n] = int(eventsDays[n])
sort(eventsDays)

print()

shirtCount = maxShirts
totalTimesWashed = 0

for n in range(1, numDays+1):
    print(f'Day {n}')
    if (shirtCount < 1):
        print('- Shirts Washed!')
        shirtCount = maxShirts
        totalTimesWashed+=1
    shirtCount-=1
    if (isIn(n, eventsDays)):
        print('- Event Attended!')
        shirtCount+=1
        maxShirts+=1

print(f'Total times washed: {totalTimesWashed}')