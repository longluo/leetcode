package com.longluo.concurrency;

import java.util.concurrent.Semaphore;

/**
 * 1114. 按序打印
 * <p>
 * 我们提供了一个类：
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 * <p>
 * 一个将会调用 first() 方法
 * 一个将会调用 second() 方法
 * 还有一个将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: "firstsecondthird"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
 * 正确的输出是 "firstsecondthird"。
 * <p>
 * 示例 2:
 * 输入: [1,3,2]
 * 输出: "firstsecondthird"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
 * 正确的输出是 "firstsecondthird"。
 * <p>
 * 提示：
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 * <p>
 * https://leetcode-cn.com/problems/print-in-order/
 */
public class Problem1114_printInOrder {

    static class Foo {
        private Semaphore firstSemaphore = new Semaphore(1);
        private Semaphore secondSemaphore = new Semaphore(0);
        private Semaphore thirdSemaphore = new Semaphore(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            firstSemaphore.acquire();
            printFirst.run();
            secondSemaphore.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            secondSemaphore.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            thirdSemaphore.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            thirdSemaphore.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            firstSemaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable firstRunnable = () -> {
            System.out.print("first");
        };
        Runnable secondRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.print("second");
            }
        };
        Runnable thirdRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.print("third");
            }
        };
        new Thread(() -> {
            try {
                foo.first(firstRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(thirdRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(secondRunnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
