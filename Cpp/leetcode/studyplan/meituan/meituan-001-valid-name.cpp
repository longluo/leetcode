//
// Created by longluo on 2022/4/14.
//

#include <bits/stdc++.h>

using namespace std;

int main() {
    int T;  // 需要检验的用户名数量
    cin >> T;
    while (T--) {
        string name;    // 用户名
        cin >> name;
        bool isValid = true; // 字符合法性判断条件，初始化为 true
        int cntAlpha = 0;
        int cntDigit = 0;
        for (int i = 0; i < name.size(); ++i) {
            if (!isalpha(name[0])) {
                isValid = false;
            }

            // 含有数字和字母以外的字符
            if (!isalnum(name[i])) {
                isValid = false;
                break;
            }

            if (isalpha(name[i])) {
                ++cntAlpha;
            }

            if (isdigit(name[i])) {
                ++cntDigit;
            }
        }

        if (isValid && cntAlpha > 0 && cntDigit > 0) {
            puts("Accept");
        } else {
            cout << "Wrong" << endl;
        }
    }

    return 0;
}

