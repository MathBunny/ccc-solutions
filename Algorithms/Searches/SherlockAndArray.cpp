#include <iostream>
#define endl "\n";
/* Horatiu Lazu - This solution uses prefix sum and binary search, it's marginally faster than sweeping through the line and trying to backtrack. */

using namespace std;
int main(int argc, char *argv[]) {
	cin.sync_with_stdio();
	cin.tie(0);
	int T, N;
	cin >> T;
	for(int q = 0; q < T; q++){
		cin >> N;
		//cout << "number: " << N << endl;
		if (N  == 1){
			int num;
			cin >> num; //just to not lose track of stream
			cout << "YES" << endl;
			continue;
		}	
		int arr [N];
		for(int x = 0; x < N; x++)
			cin >> arr[x];
		int pFix [N];
		for(int x = 0; x < N; x++)
			if (x == 0)
				pFix[0] = arr[0];
			else
				pFix[x] = arr[x] + pFix[x-1];
		
		/* Since all elements are +'ve we just do a binary search */
		int low = 1;
		int high = N-2;
		int mid;
		bool found = false;
		while(low <= high){
			mid = low + (high-low)/2;
			//cout << "LOL" << mid << " " << endl;
			if (pFix[mid-1] == pFix[N-1] - pFix[mid]){
				cout << "YES" << endl;
				found = true;
				break;
			}
			if (pFix[mid-1] < pFix[N-1] - pFix[mid]){
				low = mid + 1;	
			}
			else
				high = mid -1;
		}
		if (!found){
			cout << "NO" << endl;	
		}
	}
}