def givemered(n,k,mi,bi):
	max_profit = -1
	for i in xrange(n):
		profit = int(k/mi[i]) * bi[i]
		if profit > max_profit:
			max_profit = profit
	return max_profit

def processTc():
	[n,k] = map(int,(raw_input().split()))
	mi = map(int,(raw_input().split()))
	bi = map(int,(raw_input().split()))
	return givemered(n,k,mi,bi)

tc = int(raw_input())
ans  = [""] * tc

for t in xrange(tc):
	ans[t] = processTc()


for t in xrange(tc):
	print ans[t]
