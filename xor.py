#!/usr/bin/env python
import json
def getRightMost(arr,elem):
	diff = 100000000000;
	for i in xrange(n-1,-1,-1):
		if  arr[i] <= elem:
			return i
	return len(arr)

def getLeftMost(arr,elem):
	diff = 100000000000;
	for i in xrange(0,n):
		if arr[i] >= elem:
			return i

	return 0

def solveCase(n,arr,q,lrs):
	print n , arr , q , lrs
	arr.sort()
	cache = {}
	for i in xrange(n-1):
		for j in xrange(i+1,n):
			cache[str(arr[i])+'#'+str(arr[i])] = arr[i]
			key = str(arr[i]) + '#' +str(arr[j])
			prevKey = str(arr[i]) + '#' +str(arr[j-1])
			cache[key] = cache[prevKey] ^ arr[j]
			print prevKey,cache[prevKey],key,cache[key]
	print json.dumps(cache,indent=4)
	qans = [""] * q
	for qi in xrange(q):
		l = getLeftMost(arr, lrs[qi][0])
		r = getRightMost(arr, lrs[qi][1])
		key = str(l)  + '#' + str(r)
		qans[qi] = pow(2, r-l+1)

	return qans

tc = int(raw_input())
ans = [""] * tc

for t in xrange(tc):
	n = int(raw_input())
	arr = [int(elem) for elem in ((raw_input()).split(" "))]
	q = int(raw_input())
	lrs = [""] * q;

	for qi in xrange(q):
		lrs[qi] = [int(elem) for elem in ((raw_input()).split(" "))]
	ans[t] = solveCase(n,arr,q,lrs)


for t in xrange(tc):
	print ans[t]