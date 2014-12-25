#include <stdio.h>
#include <malloc.h>

typedef struct node{
	int data;
	struct node * next;
}Node;


Node * createNew(int data);

void insertBeg(Node ** start,int data);
void insertEnd(Node ** start,int data);

void delEnd(Node ** start);
void delBeg(Node ** start);

int count(Node * start);
int isEmpty(Node * start);
void printAll(Node * start);

int main(int argc, char const *argv[])
{
	Node * start = NULL;
	insertBeg(&start,2);
	insertBeg(&start,1);

	printAll(start);

	insertEnd(&start,3);

	printAll(start);

	delBeg(&start);

	return 0;
}



Node * createNew(int data){
	Node * nptr = (Node *)malloc(sizeof(Node));
	nptr->data = data;
	return nptr;
}

void insertBeg(Node ** start,int data){

}
void insertEnd(Node ** start,int data);

void delEnd(Node ** start){
	if (isEmpty(*start)){
		printf("Error : empty list.");
	}else{
		int onlyOneNode = 1;

		while((*start)->next->next != NULL){
			(*start) = (*start)->next;
			onlyOneNode = 0;
		}
		if (onlyOneNode == 1){
			free((*start));
			*start = NULL;
		}else{
			free((*start)->next);
			(*start)->next = NULL;
		}
	}
}

void delBeg(Node ** start){
	if (isEmpty(*start)){
		printf("Error : empty list.");
	} else {
		Node * temp = *start;
		(*start) = (*start)->next;
		free(temp);
	}
}

int count(Node * start){
	int count = 0;
	while(start != NULL){
		count++;
	}
}

int isEmpty(Node * start){
	return (start == NULL);
}

void printAll(Node * start){
	printf("\n");
	while(start != NULL){
		printf(" => [%d]",start->data);
	}
}
