#include <stdio.h>
#include <string.h>
#include <stdio.h>
#include <string.h>
#include <iostream>
#include <vector>
#include <map>
using namespace std;
int jobMachine(char * input1[])
{
	//Write code here
	int i = 0;
	while(input1[i] != '\0'){
		cout << input1[i];
	}
	return 1;
}
int main(int argc, char const *argv[])
{
	char * arr[2]= {"parin","kataria"};
	jobMachine(arr);
	return 0;
}
