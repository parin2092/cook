ps = '0123456789'

def swap(s,i,j):
	t = s[i]
	s[i] = s[j]
	s[j] = t

allPerm = []

def perm(prefixed,cstr):
	if len(cstr) == 0:
		allPerm.append(prefixed)
		return

	for i in xrange(len(cstr)):
		perm(prefixed + cstr[i], cstr[0:i] + cstr[i+1:])

perm('', ps)

allPerm.sort()
print allPerm[999999]
