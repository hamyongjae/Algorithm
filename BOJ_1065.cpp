//� ���� ���� X�� �ڸ����� ���������� �̷�ٸ�, �� ���� �Ѽ���� �Ѵ�. ���������� ���ӵ� �� ���� ���� ���̰� ������ ������ ���Ѵ�.
//N�� �־����� ��, 1���� ũ�ų� ����, N���� �۰ų� ���� �Ѽ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
//ex 110 >>>>> 99��
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
