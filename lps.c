#include "stdio.h"
#include "string.h"

int max(int i , int j){
	return (i > j ? i : j);
}

int longestPalindrom(char * x, int start, int end){
	if (start == end){
		return 1;
	}
	if ((start + 1) == end && x[start] == x[end]){
		return 2;
	}
	if (x[start] == x[end]){
		return 2 + longestPalindrom(x,start+1,end-1);
	}else{
		return max(longestPalindrom(x,start+1,end),longestPalindrom(x,start,end-1));
	}
}
int main(){
	char c[]= "nayfan";
	char c1[]= "a";
	char c2[]= "ab";
	char c3[]= "aa";

	int len = strlen(c);
	int len1 = strlen(c1);
	int len2 = strlen(c2);
	int len3 = strlen(c3);

	printf("%d\n", longestPalindrom(c,0,len-1));
	printf("%d\n", longestPalindrom(c1,0,len1-1));
	printf("%d\n", longestPalindrom(c2,0,len2-1));
	printf("%d\n", longestPalindrom(c3,0,len3-1));

}