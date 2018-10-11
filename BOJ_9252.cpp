#include<cstdio>
#include<algorithm>
using namespace std;
char s1[1002], s2[1002];
int dp[1001][1001];
void f(int x, int y) {
	if (!dp[x][y]) return;
	if (s1[x] == s2[y]) {
		f(x - 1, y - 1);
		putchar(s1[x]);
	}
	else dp[x - 1][y] > dp[x][y - 1] ? f(x - 1, y) : f(x, y - 1);
}
int main() {
	scanf("%s%s", s1 + 1, s2 + 1);
	int i, j;
	for (i = 1; s1[i]; i++)
		for (j = 1; s2[j]; j++)
			dp[i][j] = max({ dp[i - 1][j - 1] + (s1[i] == s2[j]),dp[i - 1][j],dp[i][j - 1] });
	printf("%d\n", dp[--i][--j]);
	f(i, j);
	return 0;
}