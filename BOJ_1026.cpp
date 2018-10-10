using namespace std;

#include <iostream>
#include <vector>
#include <algorithm>

int main()
{
	vector<int> A;
	vector<int> B;
	int N, input;
	int ans = 0;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> input;
		A.push_back(input);
	}

	for (int i = 0; i < N; i++) {
		cin >> input;
		B.push_back(input);
	}

	sort(A.begin(), A.end());
	sort(B.begin(), B.end(), greater<int>());

	for (int i = 0; i < N; i++)
		ans = ans + A[i] * B[i];

	cout << ans;
}