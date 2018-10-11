#include <iostream>
using namespace std;

int main()
{
	int T, N;
	long long int DP[110] = { 1,1,1,2,2, };
	scanf("%d", &T);
	while (T--) {
		scanf("%d", &N);
		for (int i = 0; i < N; i++) {
			if (i < 5)
				continue;
			else
				DP[i] = DP[i - 1] + DP[i - 5];
		}
		printf("%lld\n", DP[N - 1]);
	}
}