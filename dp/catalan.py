'''
c(0) = 1

c(n) =
		for i = 0 to n-1
		c(i) * c(n-i)


c(n) = (2n)C(n) / (n+1)

'''

def catalan(n):
	if n <= 1:
		return 1
	res = 0

	for i in xrange(n):
		res += catalan(i) * catalan(n-1-i)

	return res



def catalanDp(n):
	c = [0 for i in xrange(n+1)]
	c[0] = 1
	c[1] = 1
	for i in xrange(2,n+1):
		c[i] = 0
		for j in xrange(i):
			c[i] += c[j] * c[i-j-1]

	return c[n]

def binomial(n,k):
	res = 1

	if k > (n-k):
		k = n - k

	for i in xrange(k):
		res *= (n-i)
		res /= (i+1)

	return int(res)

def catalanBinomialCoeff(n):
	return binomial(2*n,n) / (n+1)

print catalan(5)
print catalanDp(5)
print catalanBinomialCoeff(5)
