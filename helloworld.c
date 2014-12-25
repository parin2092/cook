#include <stdio.h>
#include <assert.h>

typedef struct Node {
	int data;
	struct Node * next;
}Node;

void createGraph(Node * adjList[],int nodeCount){
	int i ;
	for(i = 0 ; i < nodeCount ; i++){
		adjList[ i ] = NULL;
	}
}

int main()
{
	Node * nodes[];

	return 1;
}