import sys

def getInput():
	return raw_input().rstrip('\\n').rstrip('\\r').rstrip('\\n\\r').rstrip('\\r\\n')

def processTestCase(n,arr):
	cache = {}
	max_elem = 2000000
	max_count = 0

	for elem in arr:
		if cache.get(elem) is None:
			cache[elem] = 0
		cache[elem] = cache.get(elem) + 1

		if cache[elem] == max_count and elem < max_elem:
			max_elem = max_elem
			max_count = cache[elem]
		if cache[elem] > max_count:
			max_count = cache[elem]
			max_elem = elem

	return "" + str(max_elem) + " " + str(max_count)

def main() :
	t = int(getInput())
	ans = [""] * t

	for it in xrange(t):
		n = int(getInput())
		line = getInput().split(' ')
		line = map(int,line)
		ans[it] = (processTestCase(n,line))


	for it in xrange(t):
		print ans[it]


if __name__ == '__main__':
	main()