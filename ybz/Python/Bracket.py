def findBracket(brackets):
    d = {"{" : "}", "[" : "]", "(" : ")", "<" : ">"}
    stack = []
    for n in range(len(brackets)):
        if (brackets[n] in d):
            stack.append(brackets[n])
        else:
            if (not d[stack[-1]] == brackets[n]):
                return f'False, Error at Index {n}'
            else:
                del stack[-1]
    return "True"

print("Enter Bracket String: ")
brackets = input()
print(findBracket(brackets))