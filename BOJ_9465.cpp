#include <iostream>
#include <algorithm>
using namespace std;
int main()
{

	int n, T, result;
	cin >> T;
	while (T--)
	{
		int DP[2][100010] = { 0, };
		int Arr[2][100010] = { 0, };
		cin >> n;

		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < n; j++)
			{
				cin >> Arr[i][j];
			}
		}
		DP[0][0] = Arr[0][0];
		DP[1][0] = Arr[1][0];
		DP[0][1] = Arr[1][0] + Arr[0][1];
		DP[1][1] = Arr[1][1] + Arr[0][0];
		for (int i = 2; i < n; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				if (j == 0)
					DP[0][i] += (max(DP[1][i - 1], DP[1][i - 2]) + Arr[0][i]);
				else if (j == 1)
					DP[1][i] += (max(DP[0][i - 1], DP[0][i - 2]) + Arr[1][i]);
			}
		}
		result = max(DP[0][n - 1], DP[1][n - 1]);
		cout << result << endl;
	}
}