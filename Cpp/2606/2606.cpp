#include <iostream>

using namespace std;

#define MAX 101

int net[MAX][MAX] = { 0 };
bool tf[MAX] = { false };
int run(int a);

int main() {
	int com, num, result = -1;

	cin >> com;
	cin >> num;

	for (int i = 0; i < num; i++) {
		int com1, com2;
		cin >> com1 >> com2;

		net[com1][com2] = 1;
		net[com2][com1] = 1;
	}
	result += run(1);

	cout << result << endl;
}	

int	run(int a) {
	if (tf[a])
		return 0;

	tf[a] = true;
	int result = 1;

	for (int i = 0; i < MAX; i++) {
		if (net[a][i]) {
			result += run(i);
		}
	}
	return result;
}