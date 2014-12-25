#include <stdio.h>
#include <malloc.h>
typedef struct node {
	int data;
	struct node * next;
}Node;

Node * createNewNode(int data);
void insertBeg(Node ** head,int data);
void insertEnd(Node * head,int data);
void printAll(Node * start);
void deleteBeg(Node ** start);

int main(){
	Node * head = NULL;
	head = createNewNode(1);
	insertBeg(&head,0);
	insertEnd(head,2);
	deleteBeg(&head);
	printAll(head);
	return 0;
}

void printAll(Node * start){
	while(start != NULL){
		printf("=>[%d]",start->data);
		start = start->next;
	}
	printf("\n");
}

Node * createNewNode(int data){
	Node * newNode;
	newNode = (Node *) malloc(sizeof(Node));
	if (newNode == NULL)
	{
		printf("\n Overflow : memory not allocated !\n");
	}
	newNode->data = data;
	newNode->next = NULL;
	return newNode;
}

void insertBeg(Node ** head,int data){
	Node * nptr = createNewNode(data);
	nptr->next = *head;
	*head = nptr;
}

void insertEnd(Node * head,int data){
	Node * nptr= createNewNode(data);
	while(head->next != NULL){
		head = head->next;
	}
	head->next = nptr;
}

void deleteBeg(Node ** start){
	Node * temp = *start;
	(*start) = (*start)->next;
	free(temp);
}