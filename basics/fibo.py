'''input
2
0
3
'''

import math



def fibo(n):
	if n == 0:
		return [1,0]
	elif n == 1:
		return [0,1]
	elif n == 2:
		return [1,1]

	c0 = [0 for i in xrange(n+1)]
	c1 = [0 for i in xrange(n+1)]
	c0[0] = 1
	c1[1] = 1
	for i in xrange(2,n+1):
		c0[i] = c0[i-1] + c0[i-2]
		c1[i] = c1[i-1] + c1[i-2]

	# print c0
	# print c1
	return [c0[n],c1[n]]

t = int(raw_input())
ans = [0 for i in xrange(t)]

for tc in xrange(t):
	n = int(raw_input())
	ans[tc] = fibo(n)

for tc in xrange(t):
	print str(ans[tc][0]) + " " + str(ans[tc][1])
