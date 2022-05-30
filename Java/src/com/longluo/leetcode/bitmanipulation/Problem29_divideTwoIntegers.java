package com.longluo.leetcode.bitmanipulation;

/**
 * 29. 两数相除
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * <p>
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * <p>
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是[−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回2^31 − 1。
 * <p>
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class Problem29_divideTwoIntegers {

    // BF + use Long time: O(x / y) space: O(1)
    // TLE
    public static int divide_bf_64(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        long dividendLong = dividend;
        long divisorLong = divisor;

        boolean sign = false;
        if (dividendLong < 0 && divisorLong < 0) {
            dividendLong = -dividendLong;
            divisorLong = -divisorLong;
        } else if (dividendLong < 0 && divisorLong > 0) {
            sign = true;
            dividendLong = -dividendLong;
        } else if (dividendLong > 0 && divisorLong < 0) {
            sign = true;
            divisorLong = -divisorLong;
        }

        long ans = 0;
        while (dividendLong >= divisorLong) {
            dividendLong -= divisorLong;
            ans++;
        }

        ans = sign ? -ans : ans;

        return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ans;
    }

    // BF Opt Long time: O(x / y) space: O(1)
    // AC
    public static int divide_bf_64_opt(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return dividend;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        } else if (dividend == Integer.MAX_VALUE) {
            if (divisor == 1) {
                return dividend;
            } else if (divisor == -1) {
                return -dividend;
            }
        }

        long dividendLong = dividend;
        long divisorLong = divisor;

        boolean sign = false;
        if (dividendLong < 0 && divisorLong < 0) {
            dividendLong = -dividendLong;
            divisorLong = -divisorLong;
        } else if (dividendLong < 0 && divisorLong > 0) {
            sign = true;
            dividendLong = -dividendLong;
        } else if (dividendLong > 0 && divisorLong < 0) {
            sign = true;
            divisorLong = -divisorLong;
        }

        long ans = 0;
        while (dividendLong >= divisorLong) {
            dividendLong -= divisorLong;
            ans++;
        }

        ans = sign ? -ans : ans;

        return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ans;
    }

    // BF 32 time: O(x / y) space: O(1)
    // AC
    public static int divide_32(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return dividend;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        } else if (dividend == Integer.MAX_VALUE) {
            if (divisor == 1) {
                return dividend;
            } else if (divisor == -1) {
                return -dividend;
            }
        }

        int ans = 0;
        boolean sign = true;
        if (dividend > 0 && divisor > 0) {
            dividend = -dividend;
            sign = false;
        } else if (dividend > 0 && divisor < 0) {
            dividend = -dividend;
            divisor = -divisor;
        } else if (dividend < 0 && divisor < 0) {
            sign = false;
            divisor = -divisor;
        }

        // Minus
        while (dividend + divisor <= 0) {
            dividend += divisor;
            ans++;
        }

        return sign ? -ans : ans;
    }

    // BinarySearch + long time: O(logx * logy) space: O(1)
    public static int divide_bs(int dividend, int divisor) {
        long x = dividend;
        long y = divisor;

        boolean sign = false;

        if ((x > 0 && y < 0) || (x < 0 && y > 0)) {
            sign = true;
        }

        if (x < 0) {
            x = -x;
        }

        if (y < 0) {
            y = -y;
        }

        long left = 0;
        long right = x;

        while (left < right) {
            long mid = (left + right + 1) >> 1;
            long result = quickAdd(y, mid);
            if (result <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        long ans = sign ? -left : left;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) ans;
    }

    public static long quickAdd(long x, long y) {
        long ans = 0;
        while (y > 0) {
            if ((y & 0x01) == 1) {
                ans += x;
            }

            x += x;
            y = y >> 1;
        }

        return ans;
    }

    // BinarySearch time: O(logx * logy) space: O(1)
    public static int divide_bs_32(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }

        boolean sign = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = true;
        }

        if (dividend > 0) {
            dividend = -dividend;
        }

        if (divisor > 0) {
            divisor = -divisor;
        }

        int MAX = Integer.MIN_VALUE >> 1;
        int ans = 0;

        // dividend became negative
        while (dividend <= divisor) {
            int temp = divisor;
            int step = -1;

            while (temp >= MAX && step >= MAX && temp >= dividend - temp) {
                temp += temp;
                step += step;
            }

            dividend -= temp;
            ans += step;
        }

        return sign ? ans : -ans;
    }

    // Recursion time: O(logx * logy) space: O(1)
    public static int divide_rec(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }

        long x = dividend;
        long y = divisor;

        boolean sign = false;
        if ((x > 0 && y < 0) || (x < 0 && y > 0)) {
            sign = true;
        }

        x = x > 0 ? x : -x;
        y = y > 0 ? y : -y;

        long ans = div(x, y);
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) (sign ? -ans : ans);
    }

    public static long div(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }

        long ans = 1;
        long temp = divisor;

        while ((temp + temp) <= dividend) {
            ans = ans << 1;
            temp = temp << 1;
        }

        return ans + div(dividend - temp, divisor);
    }

    public static void main(String[] args) {
        int val = -2147483648;
        System.out.println("val = " + val);
        val = -val;
        System.out.println("val = " + val);
        System.out.println("2147483648 ?= " + Math.abs(-2147483648));

        System.out.println("-2 ?= " + divide_bf_64(7, -3));
        System.out.println("-2 ?= " + divide_bf_64_opt(7, -3));

        System.out.println("1 ?= " + divide_32(-2147483648, -2147483648));
        System.out.println("3 ?= " + divide_32(10, 3));
        System.out.println("1 ?= " + divide_32(1, 1));
        System.out.println("-1 ?= " + divide_32(-1, 1));

        System.out.println("1 ?= " + divide_bs(1, 1));
        System.out.println("0 ?= " + divide_bs(1, 2));
        System.out.println("3 ?= " + divide_bs(10, 3));
        System.out.println("2147483647 ?= " + divide_bs(-2147483648, -1));
        System.out.println("-2147483648 ?= " + divide_bs(-2147483648, 1));
        System.out.println("-1073741824 ?= " + divide_bs(-2147483648, 2));

        System.out.println("-1073741824 ?= " + divide_bs_32(-2147483648, 2));

        System.out.println("-1073741824 ?= " + divide_rec(-2147483648, 2));
    }
}
