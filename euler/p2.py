#!/usr/bin/env python

a = 1
b = 2
c = 0
s = 2
while( a + b < 4000000):
	c = a+b
	a = b
	b = c
	print c
	if c % 2 == 0:
		s += c

print s