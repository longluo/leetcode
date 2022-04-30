//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
// Related Topics 数学 字符串 模拟 👍 915 👎 0


// 2022-04-30 08:39:40
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    // FFT
    string multiply(string num1, string num2) {
        if ((num1.length() == 1 && atoi(num1.c_str()) == 0) || (num2.length() == 1 && atoi(num2.c_str()) == 0)) {
            return "0";
        }

        int len1 = num1.size();
        int len2 = num2.size();

        int d = max(len1, len2) / 5 + 1;

        int m = 1;
        while (m < d) {
            m <<= 1;
        }
        m <<= 1;

        complex *a = new complex[m + 1];
        complex *b = new complex[m + 1];

        memset(a, 0, (m + 1) * sizeof(complex));
        memset(b, 0, (m + 1) * sizeof(complex));

        int lenA = 0;
        for (int i = len1 - 1; i >= 0; i -= 5) {
            int tmp = 0;
            for (int j = i - 4; j <= i; ++j) {
                if (j < 0) {
                    continue;
                }
                tmp = tmp * 10 + num1[j] - '0';
            }

            a[lenA++] = complex(tmp, 0);
        }

        int lenB = 0;
        for (int i = len2 - 1; i >= 0; i -= 5) {
            int tmp = 0;
            for (int j = i - 4; j <= i; ++j) {
                if (j < 0) {
                    continue;
                }
                tmp = tmp * 10 + num2[j] - '0';
            }
            b[lenB++] = complex(tmp, 0);
        }

        int l = max(lenA, lenB);
        int n = 1;
        while (n < l) {
            n <<= 1;
        }
        n <<= 1;

        long long *ans = new long long[n + 10];

        fft(a, n, 0);
        fft(b, n, 0);
        for (int i = 0; i < n; i++) {
            a[i] = a[i] * b[i];
        }
        fft(a, n, 1);

        ans[0] = 0;
        for (int i = 0; i < n; ++i) {
            ans[i + 1] = 0;
            ans[i] += (long long) (a[i].x + 0.5);
            ans[i + 1] += ans[i] / 100000;
            ans[i] %= 100000;
        }

        while (ans[n]) {
            ans[n + 1] = ans[n] / 100000;
            ans[n] %= 100000;
            ++n;
        }

        while (n > 1 && ans[n - 1] == 0) {
            --n;
        }

        stringstream s;
        for (int i = n - 1; i >= 0; --i) {
            s << (int) ans[i];
            s << setw(5) << setfill('0');
        }

        delete[] a;
        delete[] b;
        delete[] ans;

        return s.str();
    }

    const double pi = acos(-1.0);

    struct complex {
        double x, y;

        complex() : x(0), y(0) {}

        complex(double _x, double _y) : x(_x), y(_y) {}

        friend complex operator+(const complex &a, const complex &b) {
            return complex(a.x + b.x, a.y + b.y);
        }

        friend complex operator-(const complex &a, const complex &b) {
            return complex(a.x - b.x, a.y - b.y);
        }

        friend complex operator*(const complex &a, const complex &b) {
            return complex(a.x * b.x - a.y * b.y, a.x * b.y + a.y * b.x);
        }

        friend complex operator/(const complex &a, const double &b) {
            return complex(a.x / b, a.y / b);
        }
    };

    inline complex conj(const complex &a) {
        return complex(a.x, -a.y);
    }

    void fft(complex *a, int n, bool inv) {
        complex *w = new complex[n + 1];
        int *rv = new int[n + 1];
        int bits = -1;
        int _bit = 0;
        for (int i = 0; i < 30; ++i) {
            if (n & 1 << i) {
                _bit = i;
            }
        }

        if (_bit != bits) {
            bits = _bit;
            rv[0] = 0;
            rv[1] = 1;
            for (int st = 1; st < bits; ++st) {
                int k = 1 << st;
                for (int i = 0; i < k; ++i) {
                    rv[i + (1 << st)] = rv[i] << 1 | 1;
                    rv[i] <<= 1;
                }
            }

            for (int i = 0; i < 1 << bits; ++i) {
                w[i] = complex(cos(2.0 * pi * i / n), sin(2.0 * pi * i / n));
            }
        }

        for (int i = 0; i < n; i++) {
            if (rv[i] <= i) {
                swap(a[i], a[rv[i]]);
            }
        }

        for (int d = n >> 1, st = 2; d > 0; d >>= 1, st <<= 1) {
            int o = st >> 1;
            for (int j = 0; j < o; ++j) {
                complex wi = (inv ? conj(w[j * d]) : w[j * d]);
                for (int i = j; i < n; i += st) {
                    int k = i + o;
                    complex u = a[i], v = a[k] * wi;
                    a[i] = u + v;
                    a[k] = u - v;
                }
            }
        }

        if (inv)  {
            for (int i = 0; i < n; ++i) {
                a[i] = a[i] / n;
            }
        }

        delete[] w;
        delete[] rv;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

int main() {
    Solution s;
    cout << "6 ?= " << s.multiply("2", "3") << endl;
    cout << "56088 ?= " << s.multiply("123", "456") << endl;
    cout << "97406784 ?= " << s.multiply("123456", "789") << endl;
}