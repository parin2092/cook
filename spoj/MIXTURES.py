'''input
2
18 19
3
40 60 20
'''

'''
F(i, j) = min(F(i, k) + F(k + 1, j) + C[i][k] * C[k + 1][j]) for i <= k < j

Let dp[a][b]=minimum smoke produced on mixing mixtures a to b

SO its all about splitting the mixtures into 2 subsets and each of that subsets into 2 sub-subsets and so on
such that smoke produced
	(smoke generated in mixing subsets s1 ans s2 is
	sum(elements in s1)%100 X sum(elements in s2)%100
	is minimized.
Aim of the problem  boils down to minimizing the product of the 2 mixtures to be mixed.
'''
def count():
	arr = [40,60,20]
	n = len(arr)
	dp = [[100000000000 for j in xrange(n)] for i in xrange(n)]
	csum = [[0 for j in xrange(n)] for i in xrange(n)]

	for i in xrange(n):
		dp[i][i] = 0

	for i in xrange(n):
		for j in xrange(i,n):
			csum[i][j] = (csum[i][j-1] + arr[j]) % 100

	dp[0][0] = 0

	for i in xrange(n):
		for j in xrange(n):
			for k in xrange(i,j):
				dp[i][j] = min(dp[i][j],(dp[i][k] + dp[k+1][j] + csum[i][k] * csum[k+1][j]))
	print dp

count()