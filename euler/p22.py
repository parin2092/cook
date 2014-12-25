import json
fp = open('input/p22.txt')
names = json.load(fp,encoding='UTF8')

names.sort()
al = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

def getSum(name):
	lt = list(name)
	s = map(lambda x: al.index(x.upper())+1,lt)
	return reduce(lambda x,y : x+y, s)

ts = 0

for i in xrange(len(names)):
	ts += ((i+1) * getSum(names[i]))

print ts
