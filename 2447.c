#include<stdio.h>

void init();
void solve(int n, int x, int y);
char arr[6562][6562];
int main() {

	int SIZE;
	scanf("%d", &SIZE);

	init();
	solve(SIZE, 0, 0);

	for (int i = 0; i < SIZE; i++) {
		for (int j = 0; j < SIZE; j++) {
			printf("%c", arr[i][j]);
		}
		printf("\n");
	}

}

void init() {
	for (int i = 0; i < 6562; ++i) {
		for (int j = 0; j < 6562; ++j) {
			arr[i][j] = ' ';
		}
	}
}

void solve(int n, int x, int y) {
	if (n == 1) {
		arr[x][y] = '*';
		return;
	}
	int div = n / 3;
	for (int i = 0; i < 3; ++i) {
		for (int j = 0; j < 3; ++j) {
			if (i == 1 && j == 1) {
				continue;
			}
			solve(div, x + (div * i), y + (div * j));
		}
	}
	return;
}
