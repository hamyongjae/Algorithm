#include <iostream>

#define MAX_SIZE 55
using namespace std;

int main()
{
	int N, M, y, x, d, sum = 1;
	int arr[MAX_SIZE][MAX_SIZE];
	bool flag[MAX_SIZE][MAX_SIZE];
	int dy[4] = { -1, 0, 1, 0 };
	int dx[4] = { 0, 1, 0, -1 };

	cin >> N >> M >> y >> x >> d;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 1)
				flag[i][j] = true;
			else
				flag[i][j] = false;
		}
	}

	while (true)
	{
		if (!arr[y][x])// 현재 위치가 0 이면, 즉 청소되있지 않으면
		{
			arr[y][x] = sum++;
			//sum++;
		}
		else //현재 위치가 1 이면 즉, 청소되있으면
		{
			bool check = false; // 청소를 4번 다 되있는지 체크하려면????

			for (int i = 0; i < 4; i++)
			{
				d = (d + 3) % 4;
				if (arr[y + dy[d]][x + dx[d]] == 0)//왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
				{
					// 회전
					y = y + dy[d];
					x = x + dx[d];

					check = true; //청소를 한번이라도 하는 경우!
					break;
				}

			}

			if (!check) // check가 그대로 false 이면 청소 한번도 못한거, 즉 4바퀴 다돈거
			{
				// 후진
				int dd = (d + 2) % 4;
				int temp_y = y + dy[dd];
				int temp_x = x + dx[dd];

				if (temp_x < 0 || M <= temp_x || temp_y < 0 || N <= temp_y || (flag[temp_y][temp_x] == true))
					break;

				y = temp_y;
				x = temp_x;
			}
		}
	}
	cout << sum - 1;
}
