'''
f(l,h) = {
	f(l+1,h-1)
		if s[l] == s[h]
	min(f(l+1,h),f(l,h-1)) + 1
}
'''

# d = {}

# def insertions(s,l,h):
# 	d[s[l:h+1]] = d.get(s[l:h+1],0) + 1

# 	if l == h :
# 		return 0

# 	if l == h-1:
# 		return 0 if s[l] == s[h] else 1

# 	if s[l] == s[h]:
# 		return insertions(s, l+1, h-1)
# 	else:
# 		return min(insertions(s,l+1,h),insertions(s,l,h-1)) + 1



def insertionsDP(s):
	n = len(s)
	dp = [[0 for j in xrange(n+1)] for i in xrange(n+1) ]


	for gap in xrange(1,n):
		l = 0
		h = gap

		while h < n:
			if s[l] == s[h] :
				dp[l][h] = dp[l+1][h-1]
			else:
				dp[l][h] = min(dp[l+1][h],dp[l][h-1]) + 1

			h += 1
			l +=1

	return dp[0][n-1]

# print insertions('abcda', 0, 4)
# print insertions('abcde', 0, 4)
print insertions('geeks', 0, 4)
print d

# t = int(raw_input())
# for tc in xrange(t):
# 	print insertionsDP(raw_input().strip())
