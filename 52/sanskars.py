'''input
2
6 3
arjit
tijra
genius
chanda
ashish
arjit
4 2
bond
coder
bond
lol
'''

def getSanskars(n,k,arr):
    NOT_POSSIBLE = "Not possible"
    POSSIBLE = "Possible"

    tsum = sum(arr)
    x = 0
    if tsum % k != 0:
        return ""
    else:
        x = tsum / k

    dp = [[0 for j in xrange(2**n)] for i in xrange(k+1)]
    dp[0][0] = 1
    for ki in xrange(k):
        for mask in xrange(2**n):
            if not dp[ki][mask]:
                pass
            else:
                csum = 0
                for i in xrange(n):
                    if mask & (1 << i):
                        csum += arr[i]
                csum = csum - (ki * x)
                for i in xrange(n):
                    if mask & (1 << i):
                        pass
                    new_mask = mask | (1 << i)
                    if (csum + arr[i]) == x:
                        dp[ki+1][new_mask] = 1
                    elif (csum + arr[i]) < x:
                        dp[ki][new_mask] = 1
    if dp[k][(2**n)-1] == 1:
        return POSSIBLE
    else:
        return NOT_POSSIBLE

tc = int(raw_input())

for t in xrange(tc):
    n,one_camp = map(int, raw_input().split())
    k = int(n / one_camp)
    arr = range(n)

    for i in xrange(n):
        arr[i] = len(raw_input())
    print n,k,arr
    print getSanskars(n,k,arr)
