# 2
# 5 3
# 1 2 4 5 6
# 5 3
# 1 2 4 5 7
n = 5
K = 3

dp = [[0 for i in xrange(2**n)] for k in xrange(K+1)]
a = [1,2,4,5,6]
# a = [1,2,4,5,7]
x = int(sum(a) / K)

dp[0][0] = 1


for k in xrange(K):
    for bitmask in xrange(2**n):
        if not dp[k][bitmask]:
            continue
        s = 0
        for i in xrange(n):
            if (bitmask & (1 << i)):
                s += a[i]
        s -= (k * x)
        for i in xrange(n):
            if (bitmask & (1 << i)):
                continue
            new_mask = bitmask | (1 << i)
            if (s + a[i]) == x:
                dp[k + 1][new_mask] = 1
            elif (s + a[i]) < x:
                dp[k][new_mask] = 1

if dp[K][2**n - 1] == 1:
    print "yes"
else:
    print "no"


# Try running this locally.
def send_simple_message():
    import requests
    return requests.post(
        "https://api.mailgun.net/v2/samples.mailgun.org/messages",
        auth=("api", "key-3ax6xnjp29jd6fds4gc373sgvjxteol0"),
        data={"from": "sanskar.com",
              "to": ["parin2092@gmail.com"],
              "subject": "Hello",
              "text": "Testing some Mailgun awesomeness!"})


print send_simple_message()