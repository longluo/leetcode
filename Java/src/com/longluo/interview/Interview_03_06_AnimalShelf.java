package com.longluo.interview;

import java.util.*;

/**
 * 面试题 03.06. 动物收容所
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，
 * 收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。
 * 换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，
 * 比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 * <p>
 * 示例1:
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 * 输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * <p>
 * 示例2
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 * 输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * <p>
 * 说明:
 * 收纳所的最大容量为20000
 */
public class Interview_03_06_AnimalShelf {

    class AnimalShelf {

        private class Pet {
            private int time;
            private int id;

            public Pet(int time, int id) {
                this.time = time;
                this.id = id;
            }

            private void setTime(int time) {
                this.time = time;
            }

            public int getTime() {
                return time;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        List<Pet> catList;
        List<Pet> dogList;
        int timeIdx;

        public AnimalShelf() {
            catList = new LinkedList<>();
            dogList = new LinkedList<>();
            timeIdx = 0;
        }

        public void enqueue(int[] animal) {
            timeIdx++;
            if (animal[1] == 0) {
                catList.add(new Pet(timeIdx, animal[0]));
            } else {
                dogList.add(new Pet(timeIdx, animal[0]));
            }

            Collections.sort(dogList, new Comparator<Pet>() {
                @Override
                public int compare(Pet o1, Pet o2) {
                    return o1.time - o2.time;
                }
            });

            Collections.sort(catList, new Comparator<Pet>() {
                @Override
                public int compare(Pet o1, Pet o2) {
                    return o1.time - o2.time;
                }
            });
        }

        public int[] dequeueAny() {
            if (dogList.isEmpty() && !catList.isEmpty()) {
                int id = catList.get(0).id;
                catList.remove(0);
                return new int[]{id, 0};
            } else if (!dogList.isEmpty() && catList.isEmpty()) {
                int id = dogList.get(0).id;
                dogList.remove(0);
                return new int[]{id, 1};
            } else if (dogList.isEmpty() && catList.isEmpty()) {
                return new int[]{-1, -1};
            }

            if (catList.get(0).time < dogList.get(0).time) {
                int id = catList.get(0).id;
                catList.remove(0);
                return new int[]{id, 0};
            } else {
                int id = dogList.get(0).id;
                dogList.remove(0);
                return new int[]{id, 1};
            }
        }

        public int[] dequeueDog() {
            if (!dogList.isEmpty()) {
                int id = dogList.get(0).id;
                dogList.remove(0);
                return new int[]{id, 1};
            } else {
                return new int[]{-1, -1};
            }
        }

        public int[] dequeueCat() {
            if (!catList.isEmpty()) {
                int id = catList.get(0).id;
                catList.remove(0);
                return new int[]{id, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
    }

    /**
     * Your AnimalShelf object will be instantiated and called as such:
     * AnimalShelf obj = new AnimalShelf();
     * obj.enqueue(animal);
     * int[] param_2 = obj.dequeueAny();
     * int[] param_3 = obj.dequeueDog();
     * int[] param_4 = obj.dequeueCat();
     */
    public static void main(String[] args) {

    }
}
