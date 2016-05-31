#include <stdio.h>

int main(int argc, char *argv[]) {
	long long N;
	//''long long A[N];
	scanf("%lld", &N);
	long long x, A;
	long long sum = 0;
	for(x = 0; x < N; x++){
		fscanf(stdin, "%lld", &A);
		sum += A;
	}
	printf("%lld", sum);
}