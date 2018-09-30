#include <iostream>
#include <algorithm>

using namespace std;
int main()
{
	int DP[17] = { 0, };
	int T[17] = { 0, }; // 상담 완료까지 걸리는 기간
	int P[17] = { 0, }; // 상담했을 때 받는 금액
	int N;
	cin >> N;
	for (int i = 1; i <= N; i++)
		cin >> T[i] >> P[i];

	for (int i = N; 0 < i; i--)
	{
		if (i + T[i] <= N + 1)
			DP[i] = max(DP[i + 1], DP[i + T[i]] + P[i]);
		else
			DP[i] = DP[i + 1];
	}
	cout << DP[1] << endl;
}