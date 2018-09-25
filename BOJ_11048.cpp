#include <iostream>
#include <algorithm>
using namespace std;
//Compiler version g++ 6.3.0

int main()
{
	int n, m;
	int arr[1001][1001];
	int arr2[1001][1001];

	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> arr[i][j];
		}
	}
	arr2[0][0] = arr[0][0];
	for (int i = 1; i < n; i++)
	{
		arr2[i][0] = arr2[i - 1][0] + arr[i][0];
	}
	for (int i = 1; i < m; i++)
	{
		arr2[0][i] = arr2[0][i - 1] + arr[0][i];
	}
	for (int i = 1; i < n; i++)
	{
		for (int j = 1; j < m; j++)
		{
			arr2[i][j] = arr[i][j] + max(arr2[i - 1][j - 1], max(arr2[i - 1][j], arr2[i][j - 1]));
		}
	}
	cout << arr2[n - 1][m - 1] << endl;
}
