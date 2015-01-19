#include<bits/stdc++.h>

using namespace std;

#define MOD 1000000007
#define s(a) scanf("%d",&a);

vector<int> edges[100009];
long long int visited[100009];
long long int  count1[100009];
long long int B[100009],C[100009],D[100009];

void dfs(int x, int temp)
{
    if(visited[x] == 0)
        visited[x] = temp;
    for(int i = 0 ; i< edges[x].size() ; i++)
    {
        if(visited[edges[x][i]] == 0)
            dfs(edges[x][i],temp);
    }
    return;
}

int main()
{
    int n,i,a,b;
    char c;
    s(n);
    for(i=0 ; i< n -1 ; i++)
    {
        s(a);
        s(b);
        cin>>c;
        if( c != 'r')
        {
            edges[a].push_back(b);
            edges[b].push_back(a);
        }
    }
    int temp = 1;
    for(i=1 ; i<=n ; i++)
    {
        if(visited[i] == 0)
        {
            dfs(i,temp);
            temp++;
        }
    }
    for(i=1 ; i<= n ; i++)
        count1[visited[i]]++;
    long long int sum = 0;
    B[n-1] = count1[n];
    for(i=n-2;i>=0;i--) B[i] = (B[i+1] + count1[i+1])%MOD;
    for(i=1;i<n-1;i++) C[i] = (count1[i+1]*B[i+1])%MOD;

    D[n-2] = C[n-2];
    for(i=n-3;i>=1;i--) D[i] = (D[i+1] + C[i])%MOD;

    for(i=0;i<n-2;i++) sum = (sum + count1[i+1]*D[i+1])%MOD;
    cout<< ( MOD + sum )%MOD<<endl;
    return 0;
}
