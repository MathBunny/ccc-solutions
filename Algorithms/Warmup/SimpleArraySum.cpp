#include <iostream>
#define endl "\n";

using namespace std;
int main(int argc, char *argv[]) {
	cin.sync_with_stdio();
	cin.tie(0);
	int N;
	cin >> N;
	int sum = 0;
	for(int q = 0; q < N; q++){
		int temp;
		cin >> temp;
		sum += temp;
	}
	cout << sum << endl;
}