/*input
3
9 6
2 7 10
7 8 3
3 4 8
0 8 2
5 6 4
3 7 1

9 6
7 8 6
6 9 6
2 5 8
3 6 10
0 7 6
2 9 1

3 4
0 3 8
0 2 4
0 1 10
2 3 8
*/

#include <bits/stdc++.h>
using namespace std;

struct node {
    int start,end,cost;
};

const int inf=0x3f3f3f3f;
const int N=1010;

int dp[N];
node a[N];

bool comp(node a,node b) {
    return a.start < b.start;
}
int main() {
    int tt;
    scanf("%d",&tt);
    while(tt--) {
        int L,n;
        scanf("%d%d",&L,&n);
        for(int i=0;i<n;i++) {
            scanf("%d%d%d",&a[i].start,&a[i].end,&a[i].cost);
        }
        sort(a,a+n,comp);
        for(int i=0;i<=L;i++) {
            dp[i]=inf;
        }
        dp[0]=0;
        for(int i=0;i<n;i++) {
            for(int j=a[i].start;j<=a[i].end;j++) {
                dp[a[i].end] = min(dp[a[i].end] , dp[j]+a[i].cost);
            }
        }
        if(dp[L]==inf) {
            dp[L]=-1;
        }
        printf("%d\012",dp[L]);
    }
    return 0;
}
