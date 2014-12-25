import math
def getInput():
	return raw_input().rstrip('\n').rstrip('\r').rstrip('\n\r').rstrip('\r\n')

def processTestCase(tcase):
	ip = tcase
	[a,H,theta_max] = map(lambda x : int(x),ip.split())

	# H = 40
	# a = 50
	pi = 3.141593
	# theta_max = 30

	h = H-math.floor(((1/2.0)*a*math.tan(theta_max* pi/180)))
	return int(h)


t = int(getInput())
tcases = []
ans = []
for i in xrange(t):
	c = getInput()
	tcases.append(c)
	ans.append(processTestCase(c))

for i in xrange(t):
	print ans[i]