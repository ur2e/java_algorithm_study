#include <iostream>
#include <algorithm>
using namespace std;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n, m;
    int arr_n[500005];
    int arr_m[500005];
    cin >> n;
    for (int i = 0; i < n; i++){
        cin >> arr_n[i];
    }

    cin >> m;
    int x;
    sort(arr_n, arr_n+n);
    for(int i = 0; i < m; i++){
        cin >> x;
        cout << upper_bound(arr_n, arr_n+n, x) - lower_bound(arr_n, arr_n+n, x) << " ";
    }
}