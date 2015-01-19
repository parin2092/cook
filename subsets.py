'''input
2
40
2 3 -2 -1 2 3 -2 -1 2 3 -2 -1 2 3 -2 -1 2 3 -2 -1 2 3 -2 -1 2 3 -2 -1 2 3 -2 -1 2 3 -2 -1 2 3 -2 -1
4
2 3 -2 -1
'''
tc = int(raw_input())
for t in xrange(tc):
	n = int(raw_input())
	arr = map(int,raw_input().split())
	c = 0
	for mask in xrange(2**n):
		s = 0
		for j in xrange(n):
			new_mask = mask & (1 << j)
			if new_mask != 0:
				s += arr[j]
				# print arr[j],
				# print mask,bin(mask),j,"th bit",new_mask != 0
		# print "==>",s

		if s == 0:
			c += 1

	print c - 1
