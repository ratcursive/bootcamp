# mewhen comment
'''
mewhen comment againagain
'''
astring = '''
hello
    we
        are
            ironman?
'''
anint = 1
afloat = 1.02
achar = 'c'
abool = True #or False
print(type(afloat))

print (4//3) #int division
print (2**3) #exponent
#no ++ / --

print (5%2)

# STRINGS
string1 = "new"
print(string1.center(20, "4"))
print(string1.center(20))

print(f"{string1} and hello {anint}")
print (string1*9)

i = 0
while (i < 5):
    i+=1

if (i == 5):
    print("hi")
if (not 1 == 10):
    print("fokoff")

for num in range(0,10): # range(x) - from [0,x), range(x,y,z) - from [x,y) with each jumping z
    print(num)

list = [1,2,3]
for num in list:
    print(num)

# LISTS

lst = []
lst.append(1)
lst.append(10)
lst.append(39)
print(lst)

lst.reverse()

print(lst+lst)
print([lst]+[lst])
print([lst]+lst)

print(lst[:1])
print(lst[::])

lst[2] = 4
print(lst)

# TUPLES

tup = (2,3)

print(tup)
print(tup[0])

tup2 = ([5,6,7], 901)

print(tup2)
tup2[0][1] = 1
print(tup2)

# DICTIONARIES

d = {'sand': 123}
d['wood'] = 5
print(d)

y = {}
years = [2002,2003,2004]
months = ['jan', 'feb', 'mar']
days = [1,2,3]

for t in years:
    y[t] = {}
    for i in months:
        y[t][i] = []
        for l in days:
            y[t][i].append(l)

print(y)

# DEFINE FUNCTIon

def function():
    print("this is a bucket")

function()

# SETS
# immutable, unrepeatable

s = set()
s.add(90)
s.add(109)
print(s)

# USER INPUT

x = input()
print(type(x))
x = int(x)
print(type(x))

