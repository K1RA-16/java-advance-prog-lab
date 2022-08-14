#include<stdio.h>
#include<stdlib.h>
void iterFib(int n){
long long first = 0, second = 1, result, i;
for (i = 0; i < n; i++)
{
if (i <= 1)
result = i;
else
{
result = first + second;
first = second;
second = result;
}
printf(" %d", result);
}
}
long long recFib(long long n){
if(n == 0){
return 0;
} else if(n == 1) {
return 1;
} else {
return (recFib(n-1) + recFib(n-2));
}
}
void main(){
long long n;
scanf("%d", &n);
printf("%d",recFib(n));
}
