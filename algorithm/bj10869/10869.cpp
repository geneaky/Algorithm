#include <iostream>
using namespace std;

int N, M;

int main() {
    freopen("input.txt", "r", stdin);

    cin >> N >> M;

    cout << N + M << endl;
    cout << N - M << endl;
    cout << N * M << endl;
    cout << N / M << endl;
    cout << N % M << endl;
}