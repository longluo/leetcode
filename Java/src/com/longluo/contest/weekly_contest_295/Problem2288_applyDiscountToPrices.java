package com.longluo.contest.weekly_contest_295;

/**
 * 6079. 价格减免
 * <p>
 * 句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个价格。
 * 例如 "$100"、"$23" 和 "$6.75" 表示价格，而 "100"、"$" 和 "2$3" 不是。
 * <p>
 * 注意：本题输入中的价格均为整数。
 * <p>
 * 给你一个字符串 sentence  和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。
 * 返回表示修改后句子的字符串。
 * <p>
 * 示例 1：
 * 输入：sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
 * 输出："there are $0.50 $1.00 and 5$ candies in the shop"
 * 解释：
 * 表示价格的单词是 "$1" 和 "$2" 。
 * - "$1" 减免 50% 为 "$0.50" ，所以 "$1" 替换为 "$0.50" 。
 * - "$2" 减免 50% 为 "$1" ，所以 "$1" 替换为 "$1.00" 。
 * <p>
 * 示例 2：
 * 输入：sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
 * 输出："1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
 * 解释：
 * 任何价格减免 100% 都会得到 0 。
 * 表示价格的单词分别是 "$3"、"$5"、"$6" 和 "$9"。
 * 每个单词都替换为 "$0.00"。
 * <p>
 * 提示：
 * 1 <= sentence.length <= 10^5
 * sentence 由小写英文字母、数字、' ' 和 '$' 组成
 * sentence 不含前导和尾随空格
 * sentence 的所有单词都用单个空格分隔
 * 所有价格都是 正 整数且不含前导零
 * 所有价格 最多 为  10 位数字
 * 0 <= discount <= 100
 * <p>
 * https://leetcode.cn/problems/apply-discount-to-prices/
 */
public class Problem2288_applyDiscountToPrices {

    // Regex + Simulate time: O(S) space: O(n)
    public static String discountPrices(String sentence, int discount) {
        String[] words = sentence.split("\\s+");
        int len = words.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            String word = words[i];
            if (!isLegal(word)) {
                sb.append(word);
            } else {
                sb.append(getPrice(word, discount));
            }

            sb.append(" ");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static boolean isLegal(String s) {
        int len = s.length();
        if (s.charAt(0) != '$') {
            return false;
        }

        for (int i = 1; i < len; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return len > 1;
    }

    public static String getPrice(String s, int discount) {
        long price = Long.parseLong(s.substring(1));
        double dis = (double) (100 - discount) / 100 * price;
        String ans = String.format("%.2f", dis);
        return "$" + ans;
    }

    // Simulate Opt time: O(S) space: O(n)
    public static String discountPrices_opt(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+");
        int len = words.length;
        for (int i = 0; i < len; i++) {
            String word = words[i];
            if (word.length() <= 1 || word.charAt(0) != '$') {
                sb.append(word).append(" ");
            } else if (word.charAt(0) == '$') {
                boolean isPrice = true;
                for (int j = 1; j < word.length(); j++) {
                    if (!Character.isDigit(word.charAt(j))) {
                        isPrice = false;
                        sb.append(word).append(" ");
                        break;
                    }
                }

                if (isPrice) {
                    long price = Long.parseLong(word.substring(1));
                    double dis = (double) (100 - discount) / 100 * price;
                    sb.append("$").append(String.format("%.2f", dis)).append(" ");
                }
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("$2658129.12 5q $2113353.36 ?= " + discountPrices("706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6", 28));
        System.out.println("$2658129.12 5q $2113353.36 ?= " + discountPrices("$7383692 5q $5870426", 64));
        System.out.println("there are $0.50 $1.00 and 5$ candies in the shop ?= " + discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
        System.out.println("1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$ ?= " + discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
        System.out.println("1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$ ?= " + discountPrices_opt("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
    }
}
