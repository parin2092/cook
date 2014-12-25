#!/usr/bin/env python

for c in range(500):
	for b in range(c):
		for a in range(b):
			if pow(a,2) + pow(b,2) == pow(c,2):
				print (a +  b + c) == 1000
				if (a+b+c) == 1000:
					print a,b,c, a * b * c
