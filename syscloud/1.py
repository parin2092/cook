'''input
3
5.0000 3.0000 4.0000
12.0000 13.0000 5.0000
1000.0000 1000.0000 1000.0000
'''


import math

def processTc():
	[a,b,c] = map(float,raw_input().split())


	aa = a + b + c
	bb = a + b - c
	cc = a - b + c
	dd = b + c - a

	num = a * b * c
	denom = math.sqrt(aa * bb * cc * dd)

	radius = num / denom

	area = 3.1415 * (radius ** 2)

	return round(area,4)

tc = int(raw_input())
ans = [""] * tc

for t in xrange(tc):
	ans[t] = processTc()

for t in xrange(tc):
	print ans[t]
