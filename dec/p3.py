def getInput():
	return raw_input().rstrip('\n').rstrip('\r').rstrip('\n\r').rstrip('\r\n')

def min(a,b):
	if a < b:
		return a
	else:
		return b

# n = int(getInput())
# arr = getInput().split(' ')
# arr = map(int, arr)

n = 7
# 1
# 4
# 5
# 4
# 1
arr = [1,1,4,2,5,8,20]

sarr = arr[:]

sarr[0] = 0
sarr[n-1] = 0

for i in xrange(1,n-1):
	sarr[i] = min(arr[i-1],arr[i+1])

print sarr
print sum(sarr)