'''input
12
18
19
1111111000
'''
import sys
s = sys.stdin.read().rstrip()
nums = map(int,s.split())
ans = [0 for i in xrange(len(nums))]

n = 100
f = [0 for i in xrange(n+1)]
f[0] = 0
f[1] = 0
f[2] = 2
f[3] = 3
f[4] = 4

for i in xrange(5,n):
	n2 = int(i/2)
	n3 = int(i/3)
	n4 = int(i/4)
	f[i] = max(i,f[n2]+f[n3]+f[n4])

last = n

for i,num in enumerate(nums):
	try:
		ans[i] = f[num]
	except Exception, e:
		f.extend(range(last+1,num+1))

		for j in xrange(last+1,num+1):
			n2 = int(j/2)
			n3 = int(j/3)
			n4 = int(j/4)
			f[j] = max(j,f[n2]+f[n3]+f[n4])
		last = num
	ans[i] = f[num]
for a in ans:
	print a
# print f[12]
# print f[18]
# print f[19]

'''
f(n) = max(n,f(n/2)+f(n/3)+f(n/4))
'''
