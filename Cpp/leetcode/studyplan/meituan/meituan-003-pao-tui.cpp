//
// Created by longluo on 2022/4/14.
//

#include<bits/stdc++.h>

using namespace std;

// Sort Two
int main() {
    int m, n, v, w, i = 0;
    cin >> n >> m;
    vector<pair<int, int>> arr(n);
    while (n--) {
        cin >> v >> w;
        arr[i] = {v + 2 * w, i + 1}; // 获利，编号
        i++;
    }

    sort(arr.begin(), arr.end(), [&](auto a, auto b) {
        if (a.first == b.first)
            return a.second < b.second;
        return a.first > b.first;//价格大的优先，标号小的优先
    });

    sort(arr.begin(), arr.begin() + m, [&](auto a, auto b) {
        return a.second < b.second;//前m个，按编号排序
    });

    i = 0;
    while (m--) {
        cout << arr[i].second << " ";
        i++; //输出编号
    }

    return 0;
}