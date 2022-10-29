package com.longluo.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 1773. 统计匹配检索规则的物品数量
 * <p>
 * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
 * <p>
 * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
 * <p>
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 * ruleKey == "type" 且 ruleValue == typei 。
 * ruleKey == "color" 且 ruleValue == colori 。
 * ruleKey == "name" 且 ruleValue == namei 。
 * 统计并返回 匹配检索规则的物品数量 。
 * <p>
 * 示例 1：
 * 输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * 输出：1
 * 解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
 * <p>
 * 示例 2：
 * 输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 * 输出：2
 * 解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注意，["computer","silver","phone"] 未匹配检索规则。
 * <p>
 * 提示：
 * 1 <= items.length <= 10^4
 * 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
 * ruleKey 等于 "type"、"color" 或 "name"
 * 所有字符串仅由小写字母组成
 * <p>
 * https://leetcode.cn/problems/count-items-matching-a-rule/
 */
public class Problem1773_countItemsMatchingARule {

    // Simulate time: O(nk) space: O(1)
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;

        for (List<String> item : items) {
            if ((ruleKey.equals("type") && ruleValue.equals(item.get(0)))
                    || (ruleKey.equals("color") && ruleValue.equals(item.get(1)))
                    || (ruleKey.equals("name") && ruleValue.equals(item.get(2)))) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<String> tst1 = new ArrayList<>();
        tst1.add("phone");
        tst1.add("blue");
        tst1.add("pixel");

        List<List<String>> tst = new ArrayList<>();
        tst.add(tst1);

        System.out.println("1 ?= " + countMatches(tst, "color", "silver"));
    }
}
