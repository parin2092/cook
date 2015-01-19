'''input
2
6 3
arjit
tijra
genius
chanda
ashish
arjit
4 2
bond
coder
bond
lol
'''


tc = int(raw_input())

for t in xrange(tc):
	n,one_camp = map(int, raw_input().split())
	assert(n>0 and n<1001)
	assert(one_camp>0 and one_camp<1001)
	assert(n>=one_camp)
	kmap = {}
	for i in xrange(n):
		elem = len(raw_input().rstrip('\n').rstrip('\r').rstrip('\n\r').rstrip('\r\n'))
		kmap[elem] = kmap.get(elem,0)+1

	possible = True
	for key in kmap:
		if kmap.get(key) != one_camp:
			possible = False
			break

	if possible:
		print "Possible"
	else:
		print "Not possible"

