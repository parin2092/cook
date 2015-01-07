'''
f(n) = 1 + min(f(n-1), f(n/2) , f(n/3))
'''
def dpr(n):
	if n == 1:
		return 0
	r = dpr(n-1) + 1
	if n % 2 == 0:
		r = min(r,dpr(n/2)+1)
	if n % 3 == 0:
		r = min(r,dpr(n/3)+1)
	return r

def f(n):
	dp = [0 for i in xrange(n+1)]
	dp[0] = 0
	dp[1] = 0
	for i in xrange(2,n+1):
		dp[i] = dp[i-1] + 1
		if i % 2 == 0:
			dp[i] = min(dp[i],dp[i/2]+1)
		if i % 3 == 0:
			dp[i] = min(dp[i],dp[i/3]+1)

	return dp[n]

print f(1),dpr(1)
print f(2),dpr(2)
print f(3),dpr(3)
print f(4),dpr(4)
print f(5),dpr(5)
print f(10),dpr(10)
print f(100),dpr(100)