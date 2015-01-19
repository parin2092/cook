'''
c(n,k) = c(n-1,k-1) + c(n-1,k)
c(n,0) = c(n,n) = 1
'''
n = 50
k = 20

c = [[0 for j in xrange(k+1)] for i in xrange(n+1)]

c[n][k] = 1

for i in xrange(1,n+1):
	c[i][0] = 1
	for j in xrange(1,k+1):
		if i == j:
			c[i][j] = 1
		else:
			c[i][j] = c[i-1][j-1] + c[i-1][j]

print c[10][10]
print c[0][0]
print c[10][5]
print c[3][2]
