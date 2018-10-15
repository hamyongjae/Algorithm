#include <iostream>
#include <cstdio>
#include <deque>
using namespace std;
deque<int> deq;
deque<int>::iterator iter;
int main()
{
	int N, M, count = 0;
	scanf("%d %d", &N, &M);

	for (int i = 1; i <= N; i++)
		deq.push_back(i);
	while (M--)
	{
		int target, index = 1;
		int size = deq.size();
		scanf("%d", &target);
		for (iter = deq.begin(); iter != deq.end(); iter++)
		{
			if (*iter == target)break;
			index++;
		}
		int f = index - 1;
		int b = size + 1 - index;

		if (f < b)
		{
			for (int i = 0; i < f; i++)
			{
				int temp = deq.front();
				deq.pop_front();
				deq.push_back(temp);
				count++;
			}
			deq.pop_front();
		}
		else
		{
			for (int i = 0; i < b; i++)
			{
				int temp = deq.back();
				deq.pop_back();
				deq.push_front(temp);
				count++;
			}
			deq.pop_front();
		}
	}
	cout << count << endl;
}