'''input
3 30
3
2 5 7
'''

sk , lk = map(int, raw_input().split())
n = int(raw_input())
ks =  map(int, raw_input().split())
ks.sort(reverse=True)

def findOut(n):
	# global ks
	# print n
	if n == 0 or n == 1:
		return 0
	else:
		for elem in ks:
			if n % elem == 0:
				return 1 + findOut(int(n/elem))
		return -1

if lk % sk == 0:
	print findOut(lk/n)
else:
	print -1
