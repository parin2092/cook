'''input
2
6
11
'''

import math

def getNextPrime(num):

	def isPrime(n):
		if n == 0 or n == 1:
			return False
		elif n == 2 or n == 3 or n == 5:
			return True
		elif n % 2 == 0:
			return False
		elif n % 3 == 0:
			return False
		for i in xrange(2,int(math.sqrt(n))):
			if n % i == 0:
				return False
		return True

	for pr in xrange(num+1,2*num):
		if isPrime(pr) == True:
			return pr


t = int(raw_input())
ans = [0 for i in xrange(t)]

for tc in xrange(t):
	n = int(raw_input())
	ans[tc] = getNextPrime(n)

for tc in xrange(t):
	print ans[tc]
