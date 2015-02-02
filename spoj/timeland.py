'''input
2
10 1
1 2 -3 -5 4 6 -3 2 -1 2
10 2
1 2 -3 -5 4 6 -3 2 -1 2
'''


tc = int(raw_input())

for t in xrange(tc):
	n,k = map(int,raw_input().split())
	arr = map(int, raw_input().split())

	dp = [0 for i in xrange(n)]
	dp[0] = 0
	dp[0] = max(0,arr[0])

	for i in xrange(1,n):
		if arr[i] < 0:
			dp[i] = dp[i-1]
		elif i-k-1 < 0:
			dp[i] = max(dp[i-1],arr[i])
		else:
			dp[i] = max(dp[i-1],dp[i-k-1] + arr[i])

	print dp[n-1]