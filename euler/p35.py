import math

n = 100
isPrime = [True for i in range(n)]
isPrime[0] = False
isPrime[1] = False
isPrime[2] = True
isPrime[3] = True


def perm(arr,pre,curr):
	if len(curr) == 0:
		arr.append(pre)
	for i in xrange(len(curr)):
		perm(arr, pre+curr[i], curr[0:i]+curr[i+1:])


def circPrime(n):
	if n < 10:
		return True
	digits = set(list(str(n)))
	usualSuspect = set(['0', '2', '4', '5', '6', '8'])

	return True

def getAllCircPrimes():
	sqrn = int(math.floor(math.sqrt(n)))+1

	for i in xrange(2,sqrn):
		if isPrime[i]:
			for j in xrange(i*i,n,i):
				isPrime[j] = False

	primes = []
	for i in xrange(n):
		if isPrime[i]:
			primes.append(i)

	# print primes
	s = 0

	for prime in primes:
		if circPrime(prime):
			s += 1

	print s


getAllCircPrimes()