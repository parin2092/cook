#!/usr/bin/env python
import math
n = 10

isPrime = [True for i in xrange(n)]
isPrime[0] = False
isPrime[1] = False

sqrn = int(math.floor(n ** (1/2.0)))

for i in xrange(2,sqrn):
	if isPrime[i]:
		for j in xrange(i ** 2,n,i):
			isPrime[j] = False

primes = []
for i in xrange(n):
	if isPrime[i]:
		primes.append(i)


print primes
print sum(primes)