#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

int xdir[] = { 0,-1,0,1 }, ydir[] = { 1,0,-1,0 }, ptr, sz = 1, buf;
string ans[55][55];
int main()
{
	int r1, c1, r2, c2, x = 0, y = 0, cx, cy, sn = 1, mxl = 0;

	cin >> r1 >> c1 >> r2 >> c2;
	cx = -r1, cy = -c1;

	for (int i = 0; i <= 30000; i++)
	{
		if ((r1 <= x && x <= r2) || (c1 <= y && y <= c2))
		{
			int tx = x, ty = y;
			for (int j = 0, k = sn; j <= sz; j++, k++)
			{
				if (r1 <= tx && tx <= r2 && c1 <= ty && ty <= c2)
				{
					ans[tx + cx][ty + cy] = to_string(k);
					mxl = max(mxl, (int)to_string(k).length());
				}
				tx += xdir[ptr], ty += ydir[ptr];
			}
		}
		x += sz * xdir[ptr];
		y += sz * ydir[ptr];
		sn += sz;
		buf++;
		if (buf == 2) sz++, buf = 0;
		ptr = (ptr + 1) % 4;
	}
	for (int i = r1 + cx; i <= r2 + cx; i++)
	{
		for (int j = c1 + cy; j <= c2 + cy; j++)
		{
			while (ans[i][j].length() < mxl) ans[i][j] = " " + ans[i][j];
			cout << ans[i][j] << " ";
		}
		cout << "\n";
	}
}