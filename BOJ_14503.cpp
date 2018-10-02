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
		if (!arr[y][x])// ���� ��ġ�� 0 �̸�, �� û�ҵ����� ������
		{
			arr[y][x] = sum++;
			//sum++;
		}
		else //���� ��ġ�� 1 �̸� ��, û�ҵ�������
		{
			bool check = false; // û�Ҹ� 4�� �� ���ִ��� üũ�Ϸ���????

			for (int i = 0; i < 4; i++)
			{
				d = (d + 3) % 4;
				if (arr[y + dy[d]][x + dx[d]] == 0)//���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� �� ĭ�� �����ϰ� 1������ �����Ѵ�.
				{
					// ȸ��
					y = y + dy[d];
					x = x + dx[d];

					check = true; //û�Ҹ� �ѹ��̶� �ϴ� ���!
					break;
				}

			}

			if (!check) // check�� �״�� false �̸� û�� �ѹ��� ���Ѱ�, �� 4���� �ٵ���
			{
				// ����
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
