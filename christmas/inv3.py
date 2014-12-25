def getInput():
	return raw_input().rstrip('\n').rstrip('\r').rstrip('\n\r').rstrip('\r\n')

def bs(arr,key):
	low = 0
	high = len(arr)-1
	if arr[low] > key:
		return 0
	elif arr[high] < key:
		return len(arr)

	while low <= high:
		mid = int((low+high) / 2)
		# print low,high,mid , arr[mid]
		if arr[mid] == key:
			return mid
		elif arr[mid] < key and arr[mid+1] > key:
			return mid + 1
		elif arr[mid] > key and arr[mid-1] < key:
			return mid
		elif arr[mid] < key:
			low = mid + 1
		elif arr[mid] > key:
			high = mid - 1

	return -1

n = int(getInput())
a = getInput().split(' ')
b = getInput().split(' ')

# for test
# 3

# a = [5,6,7]
# b = [1,3,2]
# b = [2,4,6,8,10]


a = map(lambda x : int(x),a);
b = map(lambda x : int(x),b);

sb = b[:]

# step 1 merge sort

sb.sort()

# step 2
invs = 0

for i in xrange(len(a)):
	origElem = a[i]
	idSortedArr = bs( sb, origElem )
	# print origElem,idSortedArr
	invs += idSortedArr  - (i+1)

print invs