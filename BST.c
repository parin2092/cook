#include <stdio.h>
#include <malloc.h>
typedef struct node {
	int data;
	struct node * left;
	struct node * right;
}Node;

Node * createNewNode(int data);
void insert(Node ** root,int data);
int deleteNode(Node ** root,int data);
void inorder(Node * root);
int maxDepth(Node * root);
void printPath(int path[],int length);
void printAllPath(Node * root,int * path,int pathLen);

int main(){
	Node * root = NULL;
	insert(&root,2);
	insert(&root,1);
	insert(&root,3);
	insert(&root,5);
	insert(&root,8);
	inorder(root);

	printf("\n");
	int mdepth = maxDepth(root) ;
	printf("Max depth is : %d\n",mdepth);


	int path[10];
	printAllPath(root,path,0);
	// printf("\n");
	// deleteNode(&root,5);
	// inorder(root);

	// printf("\n");
	// deleteNode(&root,3);
	// inorder(root);

	printf("\n");
	deleteNode(&root,2);
	inorder(root);

	return 0;
}

void insert(Node ** root,int data){

	if (*(root) == NULL){
		*root = createNewNode(data);
	}else if((*root)->data >= data){
		return insert(&((*root)->left),data);
	}else{
		return insert(&((*root)->right),data);
	}

}

Node * createNewNode(int data){
	Node * newNode;
	newNode = (Node *) malloc(sizeof(Node));
	if (newNode == NULL)
	{
		printf("\n Overflow : memory not allocated !\n");
	}
	newNode->data = data;
	newNode->left = NULL;
	newNode->right = NULL;
	return newNode;
}

void inorder(Node * root){
	if (root == NULL){
		return;
	}else{
		inorder(root->left);
		printf(" %d ", root->data);
		inorder(root->right);
	}
}

int deleteNode(Node ** root,int data){
	if ((*root) == NULL){
		return 0;
	}else if((*root)->data == data){
		if ((*root)->left == NULL && (*root)->right == NULL){
			// both right and left not  available
			free(*root);
			*root = NULL;
			return 1;
		}else if((*root)->left == NULL ){
			// no left child
			Node * temp = (*root);
			(*root) = (*root)->right;
			free(temp);
			return 1;
		}else if((*root)->right == NULL ){
			// no right child
			Node * temp = (*root);
			(*root) = (*root)->right;
			free(temp);
			return 1;
		}else{
			Node * temp = (*root)->right;
			while(temp->left != NULL){
				temp = temp->left;
			}
			temp->left = (*root)->left;
			temp = (*root);
			*root = (*root)->right;
			free(temp);
			return 1;
		}
	}else if((*root)->data < data){
		return deleteNode(&((*root)->right),data);
	}else{
		return deleteNode(&((*root)->left),data);
	}
}

int maxDepth(Node * root){
	if (root == NULL){
		return 0;
	}
	else{
		int ldepth = maxDepth(root->left);
		int rdepth = maxDepth(root->right);
		return 1 + ( ( ldepth > rdepth ) ? ldepth : rdepth );
	}
}

void printAllPath(Node * root,int path[],int pathLen){
	if (root == NULL){
		return;
	}
	path[pathLen++] = root->data;
	if (root->left == NULL && root->right == NULL){
		printPath(path,pathLen);
	}else {
		printAllPath(root->left,path, pathLen);
		printAllPath(root->right,path, pathLen);
	}
}

void printPath(int path[],int length){
	int i ;
	for(i = 0;i< length;i++ ){
		printf("=> %d ",path[i]);
	}
	printf("\n");
	return;
}