#include "stdio.h"
#include "assert.h"

int callCount = 0 ;

int countTrees(int n){
	callCount++;
	if(n == 0 || n == 1){
		return 1;
	}else{
		int sum = 0, left = 0, right = 0,k;
		for(k = 1; k <= n ; k++){
			left = countTrees(k-1);
			right = countTrees(n-k);
			sum += (left * right);
		}
		return sum;
	}
}

int main(){
	printf("\n %d",countTrees(1));
	printf("\n %d",countTrees(2));
	printf("\n %d",countTrees(3));
	printf("\n %d",countTrees(4));
	printf("\n %d",countTrees(5));
	printf("\n %d",countTrees(4));
}