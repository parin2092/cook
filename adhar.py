def isAnagram(s1,s2):
	c1 = list(s1)
	c2 = list(s2)
	c1.sort()
	c2.sort()
	return c1 == c2

tc = int(raw_input())
strs = [""] * tc

for t in xrange(tc):
	strs[t] = raw_input()


for t in xrange(tc):
	s = strs[t].split(' ')
	s1 = s[0]
	s2 = s[1]
	if isAnagram(s1, s2):
		print 'YES'
	else:
		print 'NO'
