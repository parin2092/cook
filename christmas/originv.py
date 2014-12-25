import random
n = 200000
a = []
b = []
mi = 1
ma = 1000000

for i in xrange(n):
	a.append(random.randint(mi,ma))
	b.append(random.randint(mi,ma))

# n = int(raw_input())
# a = raw_input().split(' ')
# b = raw_input().split(' ')
# a = map(lambda x : int(x),a);
# b = map(lambda x : int(x),b);
# a[i]>b[j] and i < j

pair = 0
# print a , b

for i in xrange(len(a)):
	for j in xrange(i+1,len(a)):
		if a[i] > b[j]:
			pair += 1

print pair