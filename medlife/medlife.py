n = 567

t = 0

while n > 10:
	t += n % 10
	n = int(n/10)
	if n < 10:
		n += t
		t = 0

# n = n + t
print n