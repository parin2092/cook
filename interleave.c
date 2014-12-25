#include "stdio.h"
#include "malloc.h"
#include "string.h"

void interleave(char * s1,char * s2,char * s,int len){
	if (s1[0] == '\0' && s2[0] == '\0'){
		printf("%s\n",s-len );
		return;
	}
	if (s1[0] != '\0'){
		s[0] = s1[0];
		interleave(s1+1,s2,s+1,len+1);
	}
	if (s2[0] != '\0'){
		s[0] = s2[0];
		interleave(s1,s2+1,s+1,len+1);
	}
}

int main(){
	char s1[] = "AB";
	char s2[] = "12";
	int len1 = strlen(s1);
	int len2 = strlen(s2);
	int len = len1 + len2;

	char * s = (char *)malloc(sizeof(char)*(len+1));
	memset(s,0,len+1);

	interleave(s1,s2,s,0);

	return 0;
}