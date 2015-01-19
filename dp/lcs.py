'''
if x[i-1] == y[j-1]
	f(i)(j) = 1 + f(i-1)(j-1)
else:
	f(i)(j) = max(f(i-1)(j),f(i)(j-1))
'''
