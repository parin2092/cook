'''
'''

def arithmeticThree(arr):
	n = len(arr)

	for j in xrange(1,n-1):
		i = j-1
		k = j+1

		while i >= 0 and k <= (n-1):
			if (arr[i] + arr[k]) == 2 * arr[j]:
				return True
			elif (arr[i] + arr[k]) > 2*arr[j]:
				i -= 1
			elif (arr[i]+arr[k]) < 2*arr[j]:
				k += 1
	return False

arr =  [1, 7, 10, 15, 27, 29]
print arithmeticThree(arr)
