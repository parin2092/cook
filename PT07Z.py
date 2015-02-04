'''input
3
1 2
2 3
'''

d = {
	1:2,
	2:3,
	5:4,
	4:6,
	7:9,
	6:7
}

v = {}
m = 0

for k in d:
	t = d[k]
	c = 1

	while t in d and not v.get(t,False):
		v[t] = True
		t = d[t]
		c += 1

	# print t
	if m < c:
		m = c

print m