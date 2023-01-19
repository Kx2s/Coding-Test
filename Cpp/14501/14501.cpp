#include <iostream>

using namespace std;
#define MAX 16

int N;
int T[MAX];
int P[MAX];
int dp[MAX];

int main() {
    cin >> N;

    for (int i = 1; i <= N; i++)
        cin >> T[i] >> P[i];

    for (int i = N; i >= 1; i--) {
        if (i + T[i] - 1 > N) {
            dp[i] = dp[i + 1];
            continue;
        }
        dp[i] = max(dp[i + T[i]] + P[i], dp[i + 1]);
    }
    cout << dp[1] << endl;
}