import sys

def intToChar(i):
	return chr(i)

def charToInt(c):
	return ord(c)

def getInput():
	return sys.stdin.read().split('\n')

# lines =  getInput()
lines = [
	"iAmTheProjectHead",
	"i#am#the#project#head",
	"IAmTheProjectHead",
	"i#Am#the#project#head"
]
output = lines[:]

def processString(s):
	n = len(s)
	if 65 <= s[0] <= 90 :
		return 'Error!'
	for i in xrange(1,n):
		if 65 <= charToInt(s[i]) <= 90:
			return capitalToHash(s)
		elif 35 == charToInt(s[i]):
			return hashToCapital(s)


def hashToCapital(s):
	n = len(s)
	hashed = ""+ s[0]

	for i in xrange(1,n-1):

		if 65 <= charToInt(s[i-1]) <= 90:
			return 'Error!'
		elif 35 == charToInt(s[i-1]):
			hashed += intToChar(charToInt(s[i]) - 32)
		elif 97 <= charToInt(s[i]) <= 122:
			hashed += s[i]

	hashed += s[n-1]

	return hashed


def capitalToHash(s):
	n = len(s)
	capped = ""+ s[0]
	capNext = False
	for i in xrange(0,n-1):

		if 65 <= charToInt(s[i]) <= 90:
			return 'Error!'
		elif 35 == charToInt(s[i]):
			capNext = True
		elif capNext:
			capped += intToChar(charToInt(s[i]) - 32)
			capNext = False
		else:
			capped += s[i]

	capped += s[n-1]

	return capped
for s in output:
	print processString(s)