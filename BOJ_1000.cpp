#include <stdio.h>
int main()
{
	int a, b;
	scanf("%d %d", &a, &b);

	if (0 < a < 10 && 0 < b < 10) {
		printf("%d", a + b);
	}

}