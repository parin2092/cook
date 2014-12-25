#include "stdio.h"
#include "string.h"
int max(int i,int j){
	return (i>j)?i:j;
}

int lcs(char *x ,char *y,int m,int n){
	if (m == 0 || n == 0 )
	{
		return 0;
	}
	if (x[m-1] == y[n-1])
	{
		return 1 + lcs(x,y,m-1,n-1);
	}else{
		return max( lcs(x,y,m-1,n) , lcs(x,y,m,n-1) );
	}
}

int main(){
	char x [] = "parin";
	char y [] = "abcpamrfidfn";
	int len1 = strlen(x);
	int len2 = strlen(y);
	printf("%d\n",lcs(x,y,len1,len2) );
}