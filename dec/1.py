def getInput():
	return raw_input().rstrip('\n').rstrip('\r').rstrip('\n\r').rstrip('\r\n')

line1 = getInput().split(' ')
n = int(line1[0])
q = int(line1[1])

line2 = getInput().split(' ')

arr = map(int, line2)

qs = []
for i in xrange(q):
	qs.append(getInput().split(' '))

ans = []
cache = {}

for iq in xrange(q):
	op = qs[iq][0]
	i = int(qs[iq][1])
	j = int(qs[iq][2])

	if op == 'S':
		ans.append(sum(arr[i:j+1]))
	elif op == 'U':
		arr[i] += j
	elif op == 'V':
		arr[i] -= j


for j in xrange(len(ans)):
	print ans[j]
