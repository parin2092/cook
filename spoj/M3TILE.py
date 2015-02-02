'''
f(n) = f(n-2) + 2 g(n-1) // tilings of 3xn rectangle
g(n) = f(n-1) + g(n-2)   // tilings of 3xn rectangle with one corner square removed
f(0) = 1
f(1) = 0
g(0) = 0
g(1) = 1
'''

def findOut(n):
	if n == 0:
		return 1

	if n % 2 != 0:
		return 0
	fn 		= [0 for i in xrange(n+1)]
	gn 		= [0 for i in xrange(n+1)]

	fn[0] 	= 1
	fn[1] 	= 0
	gn[0] 	= 0
	gn[1] 	= 1

	for i in xrange(2,n+1):
		fn[i] = fn[i-2] + 2 * gn[i-1]
		gn[i] = fn[i-1] + gn[i-2]

	return fn[n]

print findOut(0)
print findOut(1)
print findOut(2)
print findOut(8)
print findOut(12)
print findOut(30)