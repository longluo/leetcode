package com.longluo.concurrency;

import java.util.concurrent.Semaphore;

/**
 * 1115. 交替打印FooBar
 * <p>
 * 我们提供一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 * for (int i = 0; i < n; i++) {
 * print("foo");
 * }
 * }
 * <p>
 * public void bar() {
 * for (int i = 0; i < n; i++) {
 * print("bar");
 * }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 * 示例 1:
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * <p>
 * 示例 2:
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 * <p>
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 */
public class Problem1115_printFoobarAlternately {

    class FooBar {
        private int n;

        private Semaphore fooSignal = new Semaphore(1);
        private Semaphore barSignal = new Semaphore(1);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                barSignal.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooSignal.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                barSignal.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooSignal.release();
            }
        }
    }
}
