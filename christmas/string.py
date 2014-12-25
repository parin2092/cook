def getInput():
	return raw_input().rstrip('\n').rstrip('\r').rstrip('\n\r').rstrip('\r\n')

s = list(getInput())
m = int(getInput())
qs = []
for i in xrange(m):
	qs.append(getInput().split(' '))

# s =list("abcdbcaab")

# m = 5
# qs =[
# 	['2', 'a' ],
# 	['1', 'c' ],
# 	['1', 'd' ],
# 	['3', 'b' ],
# 	['2', 'a' ]
# ]

d = {}

for ix in xrange(len(s)):
	c = s[ix]
	if d.get(c) is None:
		d[c] = list()
	d[c].append(ix)

for i in xrange(m):
	query = qs[i]
	c = query[1] # char
	occ = int(query[0]) # which occurence of char 'c'
	sidx = d[c].pop(occ-1) # id of char 'c' in string 's'
	s[sidx] = '-'

finalStr = ''

for c in s:
	if c != '-':
		finalStr += c

print finalStr
