'''
vars:
- track length
- number of opposing pacas

- ray gun formula : (100-X)/100 where X is the effeciveness of the gun
- number of times your ray gun cna be used

- speed of other alpacas and your alpaca
'''
import math
def useGun(alpaca, gunPrecent):
    # given alpaca speed and gun effectiveness, return new speed
    return math.floor(alpaca * (100-gunPrecent)/(100))

def getOpposingAlpacas(alpacaNum):
    # user inputs other alpacas' speeds
    count = 0
    speeds = []
    while(count < alpacaNum):
        speeds.append(int(input()))
        count+=1
    return speeds

def sort(array):
    for n in range(len(array)):
        for i in range(len(array)-1-n):
            if (array[i] > array[i+1]):
                temp = array[i+1]
                array[i+1] = array[i]
                array[i] = temp


def evaluate(alpacas, alpaca, gunEffect, gunUseNum):
    # alpacas array of other alpacas' speed, your own alpaca speed, gun effectivess, gun's number of uses, track's length
    while (gunUseNum > 0):
        if (alpaca <= alpacas[len(alpacas)-1]):
            alpacas[len(alpacas)-1] = useGun(alpacas[len(alpacas)-1], gunEffect)
            sort(alpacas)
            gunUseNum-=1
        else:
            gunUseNum = 0

    return (alpaca > alpacas[len(alpacas)-1])

    

print("Enter 4 numbers: number of opposing alpacas, the track's length, amount of uses on gun, the gun's effectiveness (seperate with spaces)")
inputs = input()
inputs = inputs.split()
for n in range(len(inputs)):
    inputs[n] = int(inputs[n])

alpacaNum = inputs[0]
trackLength = inputs[1]
gunUses = inputs[2]
gunEffect = inputs[3]
opposingPacas = (getOpposingAlpacas(alpacaNum))
ownPaca = int(input())
sort(opposingPacas)

if (alpacaNum < 1 or alpacaNum > 10**6):
    raise Exception("Number of competing alpacas must be between 1 and 10^6")
elif (gunUses < 1 or gunUses > 10**6):
    raise Exception("Gun useage rate cannot must be between 1 and 10^6")
elif (trackLength < 1 or trackLength > 10**16):
    raise Exception("Track's length must be between 1 and 10^16")
elif (opposingPacas[0] < 1 or opposingPacas[len(opposingPacas)-1] > 10**16 or ownPaca < 1 or ownPaca > 10**16):
    raise Exception("Speed of any alpacas must be between 1 and 10^16")
elif (gunEffect < 1 or gunEffect > 100):
    raise Exception("Effectiveness of the gun must be between 1 and 100")





result = evaluate(opposingPacas, ownPaca, gunEffect, gunUses)

if (result):
    print("YES")
else:
    print("NO")

print(opposingPacas)
print(ownPaca)