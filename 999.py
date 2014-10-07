def find(num):
	notFound = True
	last = 9
	res = 9

	while notFound:
		if res % num == 0:
			notFound = False
		else:
			if last == 0:
				last = 9
				res += 9
			else:
				last = 0
				res *= 10
	return res

# assert find(3) == 9
# assert find(10) == 90
# assert find(99) == 99
# assert find(33) == 99
# assert find(333) == 999
assert find(300) == 900
# assert find(303) == 909
# assert find(3033) == 9099
# assert find(3303) == 9909
