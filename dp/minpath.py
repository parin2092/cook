mat = [[1, 2, 3],[4, 8, 2],[1, 5, 3] ];
print mat
R = len(mat)
C = len(mat[0])

for i in xrange(R):
	for j in xrange(C):
		if i and j:
			mat[i][j] += min(mat[i-1][j],mat[i][j-1],mat[i-1][j-1])
		elif i:
			mat[i][j] += mat[i-1][j]
		elif j:
			mat[i][j] += mat[i][j-1]

print mat[-1][-1]
