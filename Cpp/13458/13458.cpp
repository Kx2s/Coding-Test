#include <iostream>

using namespace std;

int main() {
    int N, *A, B, C;    //시험장, 응시자, 총감독, 부감독
    long int result = 0;
    cin >> N;
    A = new int[N];

    for (int i = 0; i < N; i++)
        cin >> A[i];
    cin >> B >> C;

    for (int i = 0; i < N; i++) {
        int temp = A[i] - B;
        result++;

        if (temp > 0)
            result += (temp % C == 0 ? temp / C : (temp / C) + 1);
    }
    cout << result;
    return 0;
}