def find(s):
	n = len(s)
	maxlen = 0

	dp = [[0 for j in xrange(n)] for i in xrange(n)]

	for i in xrange(n):
		dp[i][i] = int(s[i])

	for l in xrange(2,n+1):
		for i in xrange(n-l+1):
			j = i + l - 1
			k = l >> 1
			dp[i][j] = dp[i][j-k] + dp[j-k+1][j]
			if l % 2 == 0 and (dp[i][j-k] == dp[j-k+1][j]) and l > maxlen:
				maxlen = l

	return maxlen

print find('123123')
print find('1538023')