//어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
//N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
//ex 110 >>>>> 99개
#include <iostream>
using namespace std;
int dydwo(int n) // 101
{
	int i, j, count = 0, temp;
	for (i = 1; i <= n; i++)
	{
		temp = i / 10 % 10 - i % 10;
		for (j = i / 10; j > 9; j /= 10) if (temp != j / 10 % 10 - j % 10) break;
		count += (j < 10);
	}
	return count;
}
int main()
{
	int n;
	cin >> n;
	cout << dydwo(n);
}
