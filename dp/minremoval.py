'''
removemin(arr,low,high):
	if (min * 2 ) >= max:
		return 0
	return min(removemin(arr,low+1,high),removemin(arr,low,high+1)) + 1
'''
def removemin(arr,low,high):
	min_ar = min(arr[low:high+1])
	max_ar = max(arr[low:high+1])

	if min_ar * 2 >= max_ar:
		return 0

	return min(removemin(arr,low+1,high),removemin(arr,low,high-1)) + 1



def removeminDp(arr):
	dp = [[0 for j in xrange(n+1)] for i in xrange(n+1)]


arr = [20, 7, 5, 6]
print removemin(arr, 0, len(arr)-1)
print removeminDp(arr)
