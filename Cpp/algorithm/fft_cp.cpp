//
// Created by longluo on 2022/5/12.
//

#include <cmath>
#include <cstdio>
#include <cstring>
#include <iostream>
#include <complex>
#include "iostream"
#include <vector>

using namespace std;

using cd = std::complex<double>;

const double PI = acos(-1.0);

#include <cmath>
#include <complex>

typedef std::complex<double> Comp;  // STL complex

const Comp I(0, 1);  // i

//const int MAX_N = 1 << 20;
const int MAX_N = 16;

Comp tmp[MAX_N];

// rev=1, DFT;
// rev=-1,IDFT
void DFT(Comp *f, int n, int rev) {
    if (n == 1) {
        return;
    }

    for (int i = 0; i < n; ++i) {
        tmp[i] = f[i];
    }

    for (int i = 0; i < n; ++i) {  // 偶数放左边，奇数放右边
        if (i & 1) {
            f[n / 2 + i / 2] = tmp[i];
        } else {
            f[i / 2] = tmp[i];
        }
    }

    Comp *g = f, *h = f + n / 2;
    DFT(g, n / 2, rev), DFT(h, n / 2, rev);  // 递归 DFT
    Comp cur(1, 0), step(cos(2 * M_PI / n), sin(2 * M_PI * rev / n));

    // Comp step=exp(I*(2*M_PI/n*rev)); // 两个 step 定义是等价的
    for (int k = 0; k < n / 2; ++k) {
        tmp[k] = g[k] + cur * h[k];
        tmp[k + n / 2] = g[k] - cur * h[k];
        cur *= step;
    }

    for (int i = 0; i < n; ++i) {
        f[i] = tmp[i];
    }
}


void fft(vector<cd> &a, bool invert) {
    int n = a.size();

    if (n == 1) {
        return;
    }

    vector<cd> a0(n / 2), a1(n / 2);
    for (int i = 0; 2 * i < n; i++) {
        a0[i] = a[2 * i];
        a1[i] = a[2 * i + 1];
    }
    fft(a0, invert);
    fft(a1, invert);

    double ang = 2 * PI / n * (invert ? -1 : 1);
    cd w(1), wn(cos(ang), sin(ang));
    for (int i = 0; 2 * i < n; i++) {
        a[i] = a0[i] + w * a1[i];
        a[i + n / 2] = a0[i] - w * a1[i];
        if (invert) {
            a[i] /= 2;
            a[i + n / 2] /= 2;
        }
        w *= wn;
    }
}

vector<int> multiply(vector<int> const &a, vector<int> const &b) {
    vector<cd> fa(a.begin(), a.end()), fb(b.begin(), b.end());

    int n = 1;

    while (n < a.size() + b.size()) {
        n <<= 1;
    }

    fa.resize(n);
    fb.resize(n);

    fft(fa, false);
    fft(fb, false);

    for (int i = 0; i < n; i++) {
        fa[i] *= fb[i];
    }

    fft(fa, true);

    vector<int> result(n);
    for (int i = 0; i < n; i++) {
        result[i] = round(fa[i].real());
    }

    int carry = 0;
    for (int i = 0; i < n; i++) {
        result[i] += carry;
        carry = result[i] / 10;
        result[i] %= 10;
    }

    return result;
}

void print(vector<int> number) {
    for (auto x : number) {
        cout << x;
    }

    cout << endl;
}


void change(Comp y[], int len) {
    int i, j, k;

    for (int i = 1, j = len / 2; i < len - 1; i++) {
        if (i < j) {
            swap(y[i], y[j]);
        }

        // 交换互为小标反转的元素，i<j 保证交换一次
        // i 做正常的 + 1，j 做反转类型的 + 1，始终保持 i 和 j 是反转的
        k = len / 2;
        while (j >= k) {
            j = j - k;
            k = k / 2;
        }

        if (j < k) {
            j += k;
        }
    }
}

int main() {
    vector<int> num1{1, 2, 3};
    vector<int> num2{4, 5, 6};

    cout << "Input is:" << endl;
    print(num1);
    print(num2);

    print(multiply(num1, num2));


    int n = 8;
    Comp[]
    x = new Comp[n];

    // original data
    for (int i = 0; i < n; i++) {
        x[i] = new Complex(i, 0);
        x[i] = new Complex(StdRandom.uniform(-1.0, 1.0), 0);
    }
    show(x, "x");

    // FFT of original data
    y = fft(x);
    show(y, "y = fft(x)");

    // take inverse FFT
    Complex[]
    z = ifft(y);
    show(z, "z = ifft(y)");

    // circular convolution of x with itself
    Complex[]
    c = cconvolve(x, x);
    show(c, "c = cconvolve(x, x)");

    // linear convolution of x with itself
    Complex[]
    d = convolve(x, x);
    show(d, "d = convolve(x, x)");
}

return 0;
}

