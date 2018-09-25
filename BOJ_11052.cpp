#include <iostream>
//#include <algorithm>

using namespace std;
int main()
{
	int DP[10001]; //DP[n] n개 잇을때 최대가격
	int P[10001];
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> P[i];
	}

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= i; j++) {
			DP[i] = max(DP[i], DP[i - j] + P[j]);
		}
	}
	cout << DP[n] << endl;
}