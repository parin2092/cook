#include "stdio.h"
char chars [] = "ABCD";

void print(int * arr,int n){
	int i ;
	for(i=0;i<n;i++){
		if (arr[i] == 1)
		{
		printf("%c",chars[i]);
		}
	}
	printf("\n");
}

void comb(int * arr,int k,int n){
	if ( k == n ){
		print(arr,n);
	}else{
		arr[k] = 0;
		comb(arr,k+1,n);
		arr[k] = 1;
		comb(arr,k+1,n);
	}
}


int main(){
	int arr[] = {0,0,0,0};
	int maxSize = 4;
	comb(arr,0,maxSize);
	return 1;
}