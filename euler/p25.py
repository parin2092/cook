#F12 = 144
#The 12th term, F12, is the first term to contain three digits.

#What is the first term in the Fibonacci sequence to contain 1000 digits?
a = 1
b = 1
c = 0
t = 2

while( len(str(c)) < 1000):
	c = a + b
	a = b
	b = c
	t+=1

print t