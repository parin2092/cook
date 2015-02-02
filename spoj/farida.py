'''input
25114
1111111111
3333333333
0
'''
import sys


def countDP(s):
	n = len(s)
	dp = [0 for i in xrange(n+1)]
	dp[0] = 1
	dp[1] = 1

	for i in xrange(2,n+1):
		if s[i-1] > '0':
			dp[i] += dp[i-1]

		if (s[i-2] < '2') or (s[i-1] < '7' and s[i-2] == '2'):
			dp[i] += dp[i-2]


	return dp[n]

# print countDP('1234')
print sys.stdin.read()
