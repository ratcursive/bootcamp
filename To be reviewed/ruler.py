def drawTicks(t):
    line = ""
    for i in range(t):
        line += "-"
    return line
def drawNumberedTick(i):
    return "-"+" "+str(i)
def drawHalfRuler(t,i):
    if(t == 1 and i != None):
        return drawNumberedTick(i)
    if(t == 1):
        return drawTicks(1)
    ruler = "-"+drawHalfRuler(t-1,i)+"\n"
    ruler+=drawHalfRuler(t-1,None)
    return ruler
def drawRuler(ticks,inches):
    ruler = ""
    if(ticks <= 1):
        return drawTicks(1)
    for i in range(inches):
        ruler += "-"+drawHalfRuler(ticks-1,i)+"\n"
        ruler+= drawHalfRuler(ticks-1,None)+"\n"
    ruler+=drawTicks(ticks)+" "+str(inches)
    return ruler

print(drawRuler(5,3))