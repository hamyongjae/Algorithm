#include <iostream>
using namespace std;
//Compiler version g++ 6.3.0

int main()
{
	long long int arr[91];
	int n;
	cin >> n;

	arr[1] = 1;
	arr[2] = 1;
	for (int i = 3; i < 91; i++) {
		arr[i] = arr[i - 2] + arr[i - 1];
	}
	cout << arr[n] << endl;
}