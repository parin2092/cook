#!/usr/bin/env python
def gcd(a,b):
	if b == 0 :
		return a
	else:
		return gcd(b,a%b)

def lcm(a,b):
	return (a*b)/gcd(a, b)

arr = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]

print reduce(lcm, arr)