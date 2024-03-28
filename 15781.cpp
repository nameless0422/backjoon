#include <bits/stdc++.h>
#include <stdio.h>
using namespace std;
// https://www.acmicpc.net/problem/15781
/*
헬멧과 조끼

문제
배틀그라운드라는 게임에서는 머리와 몸을 보호하기 위해 헬멧과 조끼를 입는다.

맵에는 다양한 헬멧과 조끼가 있으며 각각 방어력을 갖고 있다. 또한 최대 1개의
헬멧과 조끼밖에 입지 못한다. 경수는 배틀그라운드에서 승리하고 싶기 때문에 시간이
걸리더라도 최고의 헬멧과 조끼를 주워서 최대의 방어력을 얻고 싶어한다.

맵에 존재하는 조끼와 헬멧의 방어력이 주어졌을 때 경수를 도와 경수가 얻을 수 있는
방어력의 최댓값을 구해주자.

입력
입력의 첫째 줄에 맵에 존재하는 헬멧의 개수 N(N은 1000이하의 자연수)과 조끼의
개수 M(M은 1000이하의 자연수)이 주어진다. 둘째 줄에 각 헬멧의 방어력 h[i]
(h[i]는 10억 이하의 자연수)가 N개 만큼 주어지며, 셋째 줄에 각 조끼의 방어력 a[i]
(a[i]는 10억 이하의 자연수)가 M개 만큼 주어진다.

출력
경수가 얻을 수 있는 방어력의 최댓값을 출력한다.

예제 입력 1
5 7
10 60 15 20 7
1 2 3 7 5 1 3
예제 출력 1
67
예제 입력 2
2 3
1 1000000000
20 18 1000000000
예제 출력 2
2000000000
*/
int main(void) {
  int n, m, h, a, h_max, a_max;
  a_max = h_max = 0;
  cin >> n >> m;
  for (int i = 0; i < n; i++){
    cin >> h;
    h_max = max(h_max, h);
  }
  for (int i = 0; i < m; i++){
    cin >> a;
    a_max = max(a_max, a);
  }
  cout << h_max+a_max << endl;
  return 0;
}
