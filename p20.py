#!/usr/bin/python

n = 100
fact = reduce(lambda x,y : x * y,range(1,n))
print reduce(lambda x,y : int(x)+int(y),list(str(fact)))
