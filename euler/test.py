
a = []

def test(a,c):
	if c == 0:
		return
	else:
		a.append(1)
		test(a, c-1)

test(a,5)

print a