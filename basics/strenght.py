'''input
3
4 4
1 2 3 4
3 4 5 6
4 5
1 2 3 4
1 2 3 5 6
4 13
5 6 7 4
1 2 3 8 9 29 99 98 97 7 4 5 6
'''
t = int(raw_input())
ans = [0 for i in xrange(t)]

for tc in xrange(t):
	n,m = map(int,(raw_input().split()))

	ns = map(int,raw_input().split())
	ms = map(int,raw_input().split())
	# print n , m , ns ,ms
	cache = {}

	for elem in ns:
		cache[elem] = cache.get(elem,0) + 1
	# print cache
	for elem in ms:
		cache[elem] = cache.get(elem,0) + 1
	# print cache
	strength = 0
	for key in cache:
		if cache[key] > 1:
			strength += 1
	ans[tc] = strength

for tc in xrange(t):
	print ans[tc]
