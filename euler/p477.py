def si(n):
	b = 0
	for i in xrange(n):
		if b == 0:
			yield 0
		c = (pow(b, 2) + 45 ) % 1000000007
		b = c
		yield c

ans = 0

nnn = pow(10,4)
nextTurn = 1
arr = list(si(nnn))

low = 0
high = nnn-1
ans1 = 0
ans2 = 0

while (low < high):
	if nextTurn == 1:
		if arr[low] > arr[high]:
			ans1 += arr[low]
			low += 1
		else:
			ans1 += arr[high]
			high -= 1
		nextTurn = 2
	else:
		if arr[low] > arr[high]:
			ans2 += arr[low]
			low += 1
		else:
			ans2 += arr[high]
			high -= 1
		nextTurn = 1

print max(ans1,ans2)