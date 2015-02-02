'''input
singh king
'''

s1,s2 = raw_input().split()
n1 = len(s1)
n2 = len(s2)

dp = [[0 for j in xrange(n2+1)] for i in xrange(n1+1)]
dp[0][0] = 0

def min(a,b):
	if a != 0 and b != 0 and a <= b:
		return a
	return b

m = 0

for i in xrange(1,n1+1):
	for j in xrange(1,n2+1):
		if s1[i-1] == s2[j-1] and s1[i-1] not in ['a','e','i','o','u'] :
			dp[i][j] = dp[i-1][j-1] + 1
		else:
			dp[i][j] = min(dp[i-1][j],dp[i][j-1])
		if dp[i][j] > m:
			m = dp[i][j]

print m
print dp