#include "stdio.h"

int n = 10;

int findWays(int start,int end,int k){
	if (end < 0) return 0;
	if (end == 0 && k != 0) return 0;
	if(end != 0 && k == 0) return 0;
	if (start == n && k != 0)return 0;
	if(end == 0 && k == 0) {
		return 1;
	}

	return findWays(start+1,end-start,k-1) + findWays(start+1,end,k);
}

int main(){
	printf("%d",findWays(1,10,4));
	return 0;
}