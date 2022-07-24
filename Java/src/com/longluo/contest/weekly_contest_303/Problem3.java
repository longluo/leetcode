package com.longluo.contest.weekly_contest_303;

import java.util.*;

public class Problem3 {

    // TLE
    static class FoodRatings {
        Map<String, List<String>> cuisinesMap = new HashMap<>();
        Map<String, Integer> foodMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int len = foods.length;
            for (int i = 0; i < len; i++) {
                foodMap.put(foods[i], ratings[i]);
                if (cuisinesMap.containsKey(cuisines[i])) {
                    List<String> foodList = cuisinesMap.get(cuisines[i]);
                    foodList.add(foods[i]);
                    cuisinesMap.put(cuisines[i], foodList);
                } else {
                    List<String> foodList = new ArrayList<>();
                    foodList.add(foods[i]);
                    cuisinesMap.put(cuisines[i], foodList);
                }
            }
        }

        public void changeRating(String food, int newRating) {
            foodMap.put(food, newRating);
        }

        public String highestRated(String cuisine) {
            List<String> foods = cuisinesMap.get(cuisine);
            Collections.sort(foods, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (foodMap.get(o1).equals(foodMap.get(o2))) {
                        return o1.compareTo(o2);
                    }

                    return foodMap.get(o2) - foodMap.get(o1);
                }
            });

            return foods.get(0);
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
