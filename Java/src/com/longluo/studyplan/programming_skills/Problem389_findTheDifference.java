package com.longluo.studyplan.programming_skills;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 389. 找不同
 * <p>
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * 提示：
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s和t只包含小写字母
 * <p>
 * https://leetcode-cn.com/problems/find-the-difference/
 */
public class Problem389_findTheDifference {

    // Count time: O(2 * n + 26) space: O(26)
    public static char findTheDifference_bf(String s, String t) {
        int[] cnt = new int[26];
        for (char ch : t.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                return (char) ('a' + i);
            }
        }

        return ' ';
    }

    // Count Opt time: O(2 * n + 26) space: O(26)
    public static char findTheDifference_cnt_opt(String s, String t) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }

        return ' ';
    }

    // Sum time: O(2 * n) space: O(1)
    public static char findTheDifference_sum(String s, String t) {
        int sumSrc = 0;
        int sumTarget = 0;

        for (char ch : s.toCharArray()) {
            sumSrc += ch;
        }

        for (char ch : t.toCharArray()) {
            sumTarget += ch;
        }

        return (char) (sumTarget - sumSrc);
    }

    // Sort time: O(nlogn + n) space: O(2 * n)
    public static char findTheDifference_sort(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for (int i = 0; i < s.length(); i++) {
            if (sArr[i] != tArr[i] && sArr[i] == tArr[i + 1]) {
                return tArr[i];
            }
        }

        return tArr[t.length() - 1];
    }

    // XOR time: O(2 * n) space: O(1)
    public static char findTheDifference_xor(String s, String t) {
        int res = t.charAt(0) - 'a';
        for (int i = 1; i < t.length(); i++) {
            res = res ^ (t.charAt(i) - 'a');
        }

        for (int i = 0; i < s.length(); i++) {
            res = res ^ (s.charAt(i) - 'a');
        }

        return (char) ('a' + res);
    }

    // XOR Opt time: O(2 * n) space: O(1)
    public static char findTheDifference_xor_opt(String s, String t) {
        int ans = 0;

        for (char ch : s.toCharArray()) {
            ans = ans ^ ch;
        }

        for (char ch : t.toCharArray()) {
            ans = ans ^ ch;
        }

        return (char) ans;
    }

    // Hash time: O(2 * n) space: O(n)
    public static char findTheDifference_hash(String s, String t) {
        if (s.length() != t.length() - 1) {
            return ' ';
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (map.getOrDefault(ch, 0) > 0) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return ch;
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println("e ?= " + findTheDifference_hash("abcd", "abcde"));
        System.out.println("y ?= " + findTheDifference_hash("", "y"));
        System.out.println("a ?= " + findTheDifference_hash("a", "aa"));
        System.out.println("a ?= " + findTheDifference_hash("ae", "aea"));
        System.out.println("t ?= " + findTheDifference_sort("ymbgaraibkfmvocpizdydugvalagaivdbfsfbepeyccqfepzvtpyxtbadkhmwmoswrcxnargtlswqemafandgkmydtimuzvjwxvlfwlhvkrgcsithaqlcvrihrwqkpjdhgfgreqoxzfvhjzojhghfwbvpfzectwwhexthbsndovxejsntmjihchaotbgcysfdaojkjldprwyrnischrgmtvjcorypvopfmegizfkvudubnejzfqffvgdoxohuinkyygbdzmshvyqyhsozwvlhevfepdvafgkqpkmcsikfyxczcovrmwqxxbnhfzcjjcpgzjjfateajnnvlbwhyppdleahgaypxidkpwmfqwqyofwdqgxhjaxvyrzupfwesmxbjszolgwqvfiozofncbohduqgiswuiyddmwlwubetyaummenkdfptjczxemryuotrrymrfdxtrebpbjtpnuhsbnovhectpjhfhahbqrfbyxggobsweefcwxpqsspyssrmdhuelkkvyjxswjwofngpwfxvknkjviiavorwyfzlnktmfwxkvwkrwdcxjfzikdyswsuxegmhtnxjraqrdchaauazfhtklxsksbhwgjphgbasfnlwqwukprgvihntsyymdrfovaszjywuqygpvjtvlsvvqbvzsmgweiayhlubnbsitvfxawhfmfiatxvqrcwjshvovxknnxnyyfexqycrlyksderlqarqhkxyaqwlwoqcribumrqjtelhwdvaiysgjlvksrfvjlcaiwrirtkkxbwgicyhvakxgdjwnwmubkiazdjkfmotglclqndqjxethoutvjchjbkoasnnfbgrnycucfpeovruguzumgmgddqwjgdvaujhyqsqtoexmnfuluaqbxoofvotvfoiexbnprrxptchmlctzgqtkivsilwgwgvpidpvasurraqfkcmxhdapjrlrnkbklwkrvoaziznlpor",
                "qhxepbshlrhoecdaodgpousbzfcqjxulatciapuftffahhlmxbufgjuxstfjvljybfxnenlacmjqoymvamphpxnolwijwcecgwbcjhgdybfffwoygikvoecdggplfohemfypxfsvdrseyhmvkoovxhdvoavsqqbrsqrkqhbtmgwaurgisloqjixfwfvwtszcxwktkwesaxsmhsvlitegrlzkvfqoiiwxbzskzoewbkxtphapavbyvhzvgrrfriddnsrftfowhdanvhjvurhljmpxvpddxmzfgwwpkjrfgqptrmumoemhfpojnxzwlrxkcafvbhlwrapubhveattfifsmiounhqusvhywnxhwrgamgnesxmzliyzisqrwvkiyderyotxhwspqrrkeczjysfujvovsfcfouykcqyjoobfdgnlswfzjmyucaxuaslzwfnetekymrwbvponiaojdqnbmboldvvitamntwnyaeppjaohwkrisrlrgwcjqqgxeqerjrbapfzurcwxhcwzugcgnirkkrxdthtbmdqgvqxilllrsbwjhwqszrjtzyetwubdrlyakzxcveufvhqugyawvkivwonvmrgnchkzdysngqdibhkyboyftxcvvjoggecjsajbuqkjjxfvynrjsnvtfvgpgveycxidhhfauvjovmnbqgoxsafknluyimkczykwdgvqwlvvgdmufxdypwnajkncoynqticfetcdafvtqszuwfmrdggifokwmkgzuxnhncmnsstffqpqbplypapctctfhqpihavligbrutxmmygiyaklqtakdidvnvrjfteazeqmbgklrgrorudayokxptswwkcircwuhcavhdparjfkjypkyxhbgwxbkvpvrtzjaetahmxevmkhdfyidhrdeejapfbafwmdqjqszwnwzgclitdhlnkaiyldwkwwzvhyorgbysyjbxsspnjdewjxbhpsvj"));
    }
}
