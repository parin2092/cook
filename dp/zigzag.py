arr 	= 	[1,7,4,9]
diff 	= 	[-6,3,-5]

arr 	= [ 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 ]
diff 	= [-16,12,-5,-3,-2,5,5,-11,8]

'''
f(i) = max zigzag till i^th num

f(0) = 0
f(1) = 1
f(i) = max(1 + f(j)) 0 <= j < i   if alternating diff
		if diff[j] * diff[i] is -ve

f(i) = f(i-1)
'''
n = len(arr)
dp = [1 for i in xrange(n+1)]
dp[0] = 0


for i in xrange(2,n):
	for j in xrange(i):
		print i , j
		if diff[i-1] * diff[j-1] < 0 and dp[i] < (dp[j] + 1):
			dp[i] = dp[j] + 1

print dp
