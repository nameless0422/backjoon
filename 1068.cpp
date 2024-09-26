#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;
// 1068 트리
/*
트리에서 리프 노드란, 자식의 개수가 0인 노드를 말한다.

트리가 주어졌을 때, 노드 하나를 지울 것이다. 
그 때, 남은 트리에서 리프 노드의 개수를 구하는 프로그램을 작성하시오. 
노드를 지우면 그 노드와 노드의 모든 자손이 트리에서 제거된다.

예를 들어, 다음과 같은 트리가 있다고 하자.

현재 리프 노드의 개수는 3개이다. (초록색 색칠된 노드) 
이때, 1번을 지우면, 다음과 같이 변한다. 검정색으로 색칠된 노드가 트리에서 제거된 노드이다.

이제 리프 노드의 개수는 1개이다.

입력
첫째 줄에 트리의 노드의 개수 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 
둘째 줄에는 0번 노드부터 N-1번 노드까지, 각 노드의 부모가 주어진다.
만약 부모가 없다면 (루트) -1이 주어진다. 
셋째 줄에는 지울 노드의 번호가 주어진다.

출력
첫째 줄에 입력으로 주어진 트리에서 입력으로 주어진 노드를 지웠을 때, 리프 노드의 개수를 출력한다.
*/
/*
트리 자료구조야 만들줄 아니까 걍 ㄱ 
문제이해를 잘못했네
*/

int cut;
vector<int> vec[55];

int DFS(int curr) {
	int ret = 1;
	int child = 0;
	for (auto ch : vec[curr]) {
		if (ch == cut) continue;
		child += DFS(ch);
	}
	if (child) return child; // 리프노드가 아닌경우
	else return ret; // 리프노드인 경우
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;
	int root;
	for (int i = 0; i < n; ++i) {
		int parent;
		cin >> parent;
		if (parent == -1) root = i;
		else vec[parent].push_back(i);
	}
	cin >> cut;

	if (root != cut) cout << DFS(root) << '\n';
	else cout << 0 << '\n';

	return 0;
}
