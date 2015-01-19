'''
f(s + c1)(t + c2)={
	f(s+c1)(t) + Insert
	f(s)(t+c2) + Delete
	f(s)(t) + Replace or Same
}
'''

s = "BOOK"
# s = "SUNDAY"
t = "TOOK"
# t = "SATURDAY"

INSERT_COST = 1
DELETE_COST = 1
REPLACE_COST = 1

dp = [[0 for i in xrange(len(t)+1)] for i in xrange(len(s)+1)]

for i in xrange(len(s)):
	dp[i][0] = DELETE_COST * len(s)

for j in xrange(len(t)):
	dp[0][j] = INSERT_COST * len(t)

dp[0][0] = 0

for i in xrange(1,len(s)+1):
	for j in xrange(1,len(t)+1):
		TEMP_REPLACE_COST =  0 if s[i-1] == t[j-1] else REPLACE_COST

		delete = dp[i-1][j] + DELETE_COST
		insert = dp[i][j-1] + INSERT_COST
		replace = dp[i-1][j-1] + TEMP_REPLACE_COST

		dp[i][j] = min(insert,delete,replace)

print dp[len(s)][len(t)]
