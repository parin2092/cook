'''input
9
MANAMA
PANAMA
ABCDEFABC
PANDORA
BB
BOB
B
parin
madma
'''
t = int(raw_input())
ans = [0 for i in xrange(t)]

for tc in xrange(t):
	word = raw_input().rstrip('\n').rstrip('\r').rstrip('\n\r').rstrip('\r\n')
	wl = len(word)
	ans[tc] = "NOT NICE"
	r = range(1,int(wl/2)+1)
	if len(r) == 0:
		r.append(1)

	for plength in r:
		Nice = "NICE"
		for i in xrange(plength):
			if word[i] == word[(wl - plength + i)]:
				pass
			else:
				Nice = "NOT NICE"
		if Nice == "NICE":
			ans[tc] = "NICE"
			break


for tc in xrange(t):
	print ans[tc]
