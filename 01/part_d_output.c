void f(int x, int y) {
return x+y;
}
void f(int, int);
#define ALPHA 10
#define F(X,Y) X*Y-2*X*Y
int main (){
int j;
j = F(2,ALPHA);
printf(j);
return 0;
}

