x = "AGGTAB"
y = "GXTXAYB"

def lcs(x,y):
	"dp[i][j] = length of max lcs x[0...i] y[0....j]"

	n = len(x)
	m = len(y)
	dp = [[0 for i in xrange(m+1)] for j in xrange(n+1)]

	for i in xrange(1,n+1):
		for j in xrange(1,m+1):
			if x[i-1] == y[j-1]:
				dp[i][j] = 1 + dp[i-1][j-1]
			else:
				dp[i][j] = max(dp[i-1][j],dp[i][j-1])

	return dp[n][m]

print lcs(x, y)


a = list('parinrocks')
[m,n] = [a[4],a[8]]
