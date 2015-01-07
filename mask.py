n = 5

for mask in xrange(1<<n):
	for i in xrange(n):
		# print i , mask , 1 << i ,  (mask & (1 << i))
		print i , bin(i), mask ,bin(mask), 1 << i,bin( 1 << i)