package com.longluo.contest.weekly_contest_303;

import java.util.*;

/**
 * 2353. 设计食物评分系统
 * <p>
 * 设计一个支持下述操作的食物评分系统：
 * <p>
 * 修改 系统中列出的某种食物的评分。
 * 返回系统中某一类烹饪方式下评分最高的食物。
 * 实现 FoodRatings 类：
 * <p>
 * FoodRatings(String[] foods, String[] cuisines, int[] ratings) 初始化系统。食物由 foods、cuisines 和 ratings 描述，长度均为 n 。
 * foods[i] 是第 i 种食物的名字。
 * cuisines[i] 是第 i 种食物的烹饪方式。
 * ratings[i] 是第 i 种食物的最初评分。
 * void changeRating(String food, int newRating) 修改名字为 food 的食物的评分。
 * String highestRated(String cuisine) 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。
 * 注意，字符串 x 的字典序比字符串 y 更小的前提是：x 在字典中出现的位置在 y 之前，也就是说，要么 x 是 y 的前缀，或者在满足 x[i] != y[i] 的第一个位置 i 处，x[i] 在字母表中出现的位置在 y[i] 之前。
 * <p>
 * 示例：
 * 输入
 * ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
 * [[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
 * 输出
 * [null, "kimchi", "ramen", null, "sushi", null, "ramen"]
 * <p>
 * 解释
 * FoodRatings foodRatings = new FoodRatings(["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]);
 * foodRatings.highestRated("korean"); // 返回 "kimchi"
 * // "kimchi" 是分数最高的韩式料理，评分为 9 。
 * foodRatings.highestRated("japanese"); // 返回 "ramen"
 * // "ramen" 是分数最高的日式料理，评分为 14 。
 * foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
 * foodRatings.highestRated("japanese"); // 返回 "sushi"
 * // "sushi" 是分数最高的日式料理，评分为 16 。
 * foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
 * foodRatings.highestRated("japanese"); // 返回 "ramen"
 * // "sushi" 和 "ramen" 的评分都是 16 。
 * // 但是，"ramen" 的字典序比 "sushi" 更小。
 * <p>
 * 提示：
 * 1 <= n <= 2 * 10^4
 * n == foods.length == cuisines.length == ratings.length
 * 1 <= foods[i].length, cuisines[i].length <= 10
 * foods[i]、cuisines[i] 由小写英文字母组成
 * 1 <= ratings[i] <= 10^8
 * foods 中的所有字符串 互不相同
 * 在对 changeRating 的所有调用中，food 是系统中食物的名字。
 * 在对 highestRated 的所有调用中，cuisine 是系统中 至少一种 食物的烹饪方式。
 * 最多调用 changeRating 和 highestRated 总计 2 * 10^4 次
 * <p>
 * https://leetcode.cn/problems/design-a-food-rating-system/
 */
public class Problem2353_designAFoodRatingSystem {

    // TLE
    // TODO: 2022/8/24  
    static class FoodRatings {
        Map<String, Integer> foodMap = new HashMap<>();
        Map<String, PriorityQueue<String>> cuisinesMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int len = foods.length;

            PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (foodMap.get(o1) == foodMap.get(o2)) {
                        return o1.compareTo(o2);
                    }

                    return foodMap.get(o2).compareTo(foodMap.get(o1));
                }
            });

            for (int i = 0; i < len; i++) {
                foodMap.put(foods[i], ratings[i]);
                if (cuisinesMap.containsKey(cuisines[i])) {
                    pq.clear();
                    pq = cuisinesMap.get(cuisines[i]);
                    pq.add(foods[i]);
                    cuisinesMap.put(cuisines[i], pq);
                } else {
                    pq.clear();
                    pq.add(foods[i]);
                    cuisinesMap.put(cuisines[i], pq);
                }
            }
        }

        public void changeRating(String food, int newRating) {
            foodMap.put(food, newRating);
        }

        public String highestRated(String cuisine) {
            PriorityQueue<String> pq = cuisinesMap.get(cuisine);
            return pq.peek();
        }
    }

    public static void main(String[] args) {
        String[] foods = new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = new int[]{9, 12, 8, 15, 14, 7};
        FoodRatings fr = new FoodRatings(foods, cuisines, ratings);
        System.out.println(fr.highestRated("korea"));
        System.out.println(fr.highestRated("japanese"));
    }
}
