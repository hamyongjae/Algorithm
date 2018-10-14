#include <fstream>
#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;
typedef long long ll;

int bruteForce(ll remaining, int speed)
{
	int ret = 0;
	while (remaining > 0)
	{
		if (remaining > speed * 2)
		{
			ret += 2;
			remaining -= speed * 2;
			speed++;
		}
		else
		{
			int quotient = remaining / speed;
			remaining -= quotient * speed;
			ret += quotient;
			speed--;
		}
	}
	return ret;
}

int main()
{
	int cases;
	cin >> cases;
	for (int i = 0; i < cases; i++)
	{
		ll x, y;
		cin >> x >> y;

		cout << bruteForce(y - x, 1) << endl;
	}

	return 0;
}