'''
dp(n) = max(i * (n-i) , dp(n-i) * i )
'''

from math import ceil

def maxProduct(n):
	dp = [0 for i in xrange(n+1)]
	dp[2] = 1

	for i in xrange(3,n+1):
		iby2 = i >> 1
		dp[i] = 0
		for j in xrange(iby2+1):
			dp[i] = max(dp[i] , (i-j) * j , dp[i-j] * j)

	return dp[n]

print maxProduct(2)
print maxProduct(3)
print maxProduct(4)
print maxProduct(5)
print maxProduct(10)
