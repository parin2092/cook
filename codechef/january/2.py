def gcd(a,b):
	while a != 0:
		temp = a
		a = b%a
		b = temp
	return b


def givemered(n, q, arr, qs):
	qa = [""] * q

	for i in xrange(q):
		qa[i] = reduce(gcd, arr[:qs[i][0]]+arr[qs[i][1]+1:])

	return qa


tc = int(raw_input())
ans  = [0 for i in xrange(10000000000)]

for t in xrange(tc):
	[n,q] = map(int,(raw_input().split()))
	arr = map(int,(raw_input().split()))
	qs = [""] * q

	for i in xrange(q):
		qs[i] = map(lambda x:int(x)-1, raw_input().split())

	# print n,q,arr,qs
	qs = givemered(n, q, arr, qs)
	ans = ans + qs


for i in xrange(len(ans)):
	print ans[i]
