import json
fp = open('ip81.json')
mat = json.load(fp)

def psum(i,j):
	n = len(mat)
	if ((n-1)) == i == j:
		return mat[i][j]
	elif (n-1) == i and (n-1) != j:
		return mat[i][j] + psum( i, j+1)
	elif (n-1) != i and (n-1) == j:
		return mat[i][j] + psum( i+1, j)
	else:
		return mat[i][j] + min(psum(i+1,j),psum(i,j+1))


print psum( 0, 0)
