#include <iostream>
#include <vector>
#include <algorithm>
#define MAX_SIZE 8
using namespace std;

vector<pair<int, int>> vec;
int arr[MAX_SIZE][MAX_SIZE];
int temp_arr[MAX_SIZE][MAX_SIZE];
int X[4] = { 1,0,-1,0 }; //오른쪽에서 시계방향으로 회전
int Y[4] = { 0,1,0,-1 };
int N, M;

void DFS_VIRUS(int x, int y)
{
	for (int i = 0; i < 4; i++)
	{
		int newX = x + X[i];
		int newY = y + Y[i];
		if (0 <= newX && newX < M && 0 <= newY && newY < N)
		{
			if (temp_arr[newY][newX] == 0) {
				temp_arr[newY][newX] = 2;
				DFS_VIRUS(newX, newY);
			}
		}
	}
}
int main()
{
	cin >> N >> M;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> arr[i][j];
			temp_arr[i][j] = arr[i][j];
			if (!arr[i][j])
				vec.push_back(make_pair(i, j));
		}
	}

	int MAX = 0;

	for (int i = 0; i < vec.size() - 2; i++)
	{
		for (int j = i + 1; j < vec.size() - 1; j++)
		{
			for (int k = j + 1; k < vec.size(); k++)
			{
				pair<int, int> one = vec[i];
				pair<int, int> two = vec[j];
				pair<int, int> three = vec[k];

				for (int i = 0; i < N; i++)
				{
					for (int j = 0; j < M; j++)
					{
						temp_arr[i][j] = arr[i][j];
					}
				}

				temp_arr[one.first][one.second] = 1;
				temp_arr[two.first][two.second] = 1;
				temp_arr[three.first][three.second] = 1;

				for (int i = 0; i < N; i++)
				{
					for (int j = 0; j < M; j++)
					{
						if (temp_arr[i][j] == 2)
							DFS_VIRUS(j, i); // (x,y)
					}
				}



				int cnt = 0;
				for (int i = 0; i < N; i++)
				{
					for (int j = 0; j < M; j++)
					{
						if (temp_arr[i][j] == 0)
						{
							cnt++;
						}
					}
				}

				MAX = max(cnt, MAX);
			}
		}
	}
	cout << MAX;
}