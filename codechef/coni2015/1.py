'''input
23
LWLW
'''
import math

x = int(raw_input())
wl = list(raw_input().strip())

for r in wl:
	if r == 'W':
		x = x * 2 + 11
	else:
		if x % 2 == 0:
			x = x >> 1
		else:
			x = ( x >> 1 )+ 1

print x
