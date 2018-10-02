#include <iostream>
#include <string.h>
using namespace std;

int main()
{
	int cnt;
	int arr[4] = {};
	for (int i = 0; i < 3; i++)
	{
		cnt = 0;
		memset(arr, 0, 4);
		for (int j = 0; j < 4; j++)
			scanf("%d", &arr[j]);

		for (int j = 0; j < 4; j++)
		{
			if (arr[j] == 1)
				cnt++;
		}

		if (cnt == 0)
			printf("D\n");
		else if (cnt == 1)
			printf("C\n");
		else if (cnt == 2)
			printf("B\n");
		else if (cnt == 3)
			printf("A\n");
		else if (cnt == 4)
			printf("E\n");
	}
}