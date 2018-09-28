#include <iostream>

using namespace std;

int main()
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N, a, b;

	cin >> N;

	while (N--)
	{
		cin >> a >> b;
		cout << a + b << '\n';
	}

}