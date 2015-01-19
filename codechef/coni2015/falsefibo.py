'''input
3
1
2
300000000
'''

'''
F(n)=2*F(n-1)+3*F(n-2); and F(0)=2 and F(1)=5;
'''

tc = int(raw_input())
ans = [0 for i in xrange(tc)]
ns = [0 for i in xrange(tc)]

for i in xrange(tc):
	n = int(raw_input())
	dp = [i for i in xrange(n+1)]
	dp[0] = 2
	dp[1] = 5

	for i in xrange(2,n+1):
		dp[i] = (2*dp[i-1]   + 3 * dp[i-2]) % 1000000007

	print dp[n]
