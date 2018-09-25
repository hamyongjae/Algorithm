#include <iostream>
using namespace std;
//Compiler version g++ 6.3.0

int main()
{
	int DP[12] = { 0, };
	DP[1] = 1;
	DP[2] = 2;
	DP[3] = 4;
	//DP[3]=3;
	for (int i = 4; i < 11; i++)
	{
		DP[i] += DP[i - 1];
		DP[i] += DP[i - 2];
		DP[i] += DP[i - 3];
	}

	int n, T;
	cin >> T;
	while (T--)
	{
		cin >> n;
		//	if(n<=3)
		//		cout << DP[n]-1 << endl;
		//	else
		cout << DP[n] << endl;
	}
}