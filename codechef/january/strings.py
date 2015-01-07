
ip = [3,0,1,5,2,4]
n = 6
dp = [[0 for j in xrange(3)] for i in xrange(n)]

for i in xrange(n):
	curr = ip[i]%3
	dp[i][curr] += 1
	if i:
		for j in xrange(3):
			if curr % 3 == 0:
				dp[i][j] += dp[i-1][j]
			if curr % 3 == 1:
				dp[i][j] += dp[i-1][(j+2)%3]
			if curr % 3 == 2:
				dp[i][j] += dp[i-1][(j+1)%3]

s = 0
for i in xrange(n):
	s += dp[i][0]
print dp , s