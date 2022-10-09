package com.longluo.algo200;

/**
 * 158. 用 Read4 读取 N 个字符 II
 * <p>
 * 给你一个文件 file ，并且该文件只能通过给定的 read4 方法来读取，请实现一个方法使其能够使 read 读取 n 个字符。注意：你的 read 方法可能会被调用多次。
 * <p>
 * read4 的定义：
 * <p>
 * read4 API 从文件中读取 4 个连续的字符，然后将这些字符写入缓冲区数组 buf4 。
 * <p>
 * 返回值是读取的实际字符数。
 * <p>
 * 请注意，read4() 有其自己的文件指针，类似于 C 中的 FILE * fp 。
 * <p>
 * 参数类型: char[] buf4
 * 返回类型: int
 * <p>
 * 注意: buf4[] 是目标缓存区不是源缓存区，read4 的返回结果将会复制到 buf4[] 当中。
 * 下列是一些使用 read4 的例子：
 * <p>
 * File file("abcde"); // 文件名为 "abcde"， 初始文件指针 (fp) 指向 'a'
 * char[] buf4 = new char[4]; // 创建一个缓存区使其能容纳足够的字符
 * read4(buf4); // read4 返回 4。现在 buf4 = "abcd"，fp 指向 'e'
 * read4(buf4); // read4 返回 1。现在 buf4 = "e"，fp 指向文件末尾
 * read4(buf4); // read4 返回 0。现在 buf4 = ""，fp 指向文件末尾
 * <p>
 * <p>
 * read 方法：
 * <p>
 * 通过使用 read4 方法，实现 read 方法。该方法可以从文件中读取 n 个字符并将其存储到缓存数组 buf 中。您 不能 直接操作 file 。
 * <p>
 * 返回值为实际读取的字符。
 * <p>
 * read 的定义：
 * <p>
 * 参数类型:  char[] buf, int n
 * 返回类型:  int
 * <p>
 * 注意: buf[] 是目标缓存区不是源缓存区，你需要将结果写入 buf[] 中。
 * 注意：
 * 你 不能 直接操作该文件，文件只能通过 read4 获取而 不能 通过 read。
 * read  函数可以被调用 多次。
 * 请记得 重置 在 Solution 中声明的类变量（静态变量），因为类变量会 在多个测试用例中保持不变，影响判题准确。请 查阅 这里。
 * 你可以假定目标缓存数组 buf 保证有足够的空间存下 n 个字符。
 * 保证在一个给定测试用例中，read 函数使用的是同一个 buf。
 * <p>
 * 示例 1：
 * 输入： file = "abc"， queries = [1,2,1]
 * 输出：[1,2,0]
 * 解释：测试用例表示以下场景:
 * File file("abc");
 * Solution sol;
 * sol.read (buf, 1); // 调用 read 方法后，buf 应该包含 “a”。我们从文件中总共读取了 1 个字符，所以返回 1。
 * sol.read (buf, 2); // 现在 buf 应该包含 "bc"。我们从文件中总共读取了 2 个字符，所以返回 2。
 * sol.read (buf, 1); // 我们已经到达文件的末尾，不能读取更多的字符。所以返回 0。
 * 假设已经分配了 buf ，并保证有足够的空间存储文件中的所有字符。
 * <p>
 * 示例 2：
 * 输入：file = "abc"， queries = [4,1]
 * 输出：[3,0]
 * 解释：测试用例表示以下场景:
 * File file("abc");
 * Solution sol;
 * sol.read (buf, 4); // 调用 read 方法后，buf 应该包含 “abc”。我们从文件中总共读取了 3 个字符，所以返回 3。
 * sol.read (buf, 1); // 我们已经到达文件的末尾，不能读取更多的字符。所以返回 0。
 * <p>
 * 提示：
 * 1 <= file.length <= 500
 * file 由英语字母和数字组成
 * 1 <= queries.length <= 10
 * 1 <= queries[i] <= 500
 * <p>
 https://leetcode.cn/problems/read-n-characters-given-read4-ii-call-multiple-times/
 */
public class Problem158_readNCharactersGivenRead4_ii {

    class Reader4 {

        public int read4(char[] buf4) {
            return 0;
        }
    }

    // Read time: O(n) space: O(n)

    /**
     * The read4 API is defined in the parent class Reader4.
     * int read4(char[] buf4);
     */
    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int ans = 0;
            while (ans < n) {
                char[] buf4 = new char[4];
                int ret = read4(buf4);
                if (ret == 0) {
                    break;
                } else {
                    int len = Math.min(ret, n - ans);
                    System.arraycopy(buf4, 0, buf, ans, len);
                    ans += len;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {

    }
}
