'''
This problem can be solved using Dynamic Programming.

Let a[i] be the number of binary strings of length i
	which do not contain any two consecutive 1's and which end in 0.
We can append either 0 or 1 to a string ending in 0,

Let b[i] be the number of binary strings of length i
	which do not contain any two consecutive 1's and which end in 1.
but we can only append 0 to a string ending in 1.


This yields the recurrence relation:

a[i] = a[i - 1] + b[i - 1]
b[i] = a[i - 1]

a[i] = b[i] = 1

a[1] = 1 # 0
b[1] = 1 # 1

a[2] = a[1] + b[1] # 00 and 10
b[2] = a[1] # 01
a[4] = []

a[3] = a[2] + b[2] # 000 , 100 , 010
b[3] = a[2] # 001 , 101
'''


n = 2
def findOut(n):
	a = [0 for i in xrange(n+1)]
	b = [0 for i in xrange(n+1)]

	a[1] = b[1] = 1

	for i in xrange(2,n+1):
		a[i] = a[i-1] + b[i-1]
		b[i] = a[i-1]

	return a[n] + b[n]

print findOut(2)
print findOut(3)
print findOut(4)
