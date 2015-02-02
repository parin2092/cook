'''
f[n] = 3 * f[n-1] - f[n-2]
f[0] = 0
f[1] = 1
f[2] = 3
'''
tc = int(raw_input())
for t in xrange(tc):
	n = int(raw_input())
	if n == 1:
		print 1
	elif n == 2:
		print 3
	else:
		a = 1
		b = 3
		c = 0

		for i in xrange(3,n+1):
			c = (3 * b) % 1000000007 - a
			a = b
			b = c

		print c % 1000000007