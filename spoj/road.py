'''input
1
9 6
7 8 6
6 9 6
2 5 8
3 6 10
1 7 6
2 9 1
'''
def min(a,b):
	if a != 0 and a <= b:
		return a
	return b

tc = int(raw_input())

for t in xrange(tc):
	n,k = map(int,raw_input().split())

	ip = [""] * (k+1)
	for i in xrange(1,k+1):
		ip[i] = map(int, raw_input().split())

	print n,k,ip
	ddp = [111 for i in  xrange(n+1)]
	ddp[0] = 0
	for i in xrange(1,k+1):
		start = ip[i][0]
		end = ip[i][1]
		cost = ip[i][2]
		for j in xrange(start,end+1):
			ddp[end] = min(ddp[end], ddp[j] + cost)
			print start,j,end,cost,ddp
	print ddp[n]


'''
I am currently fixing some bugs and will work on new feature in new branch
'''
