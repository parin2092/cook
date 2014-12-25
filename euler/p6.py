#!/usr/bin/env python
firstN = 100

def fn(n):
	return n*(n+1)/2

def fnsqr(n):
	return n * (n+1) * (2*n + 1) / 6

print pow(fn(firstN),2) - fnsqr(firstN)