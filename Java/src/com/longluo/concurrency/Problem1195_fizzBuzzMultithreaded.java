package com.longluo.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 1195. 交替打印字符串
 * <p>
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * <p>
 * 假设有这么一个类：
 * class FizzBuzz {
 * public FizzBuzz(int n) { ... }               // constructor
 * public void fizz(printFizz) { ... }          // only output "fizz"
 * public void buzz(printBuzz) { ... }          // only output "buzz"
 * public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 * public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * <p>
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 * <p>
 * 提示：
 * 本题已经提供了打印字符串的相关方法，如printFizz()等，具体方法名请参考答题模板中的注释部分。
 * <p>
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
 */
public class Problem1195_fizzBuzzMultithreaded {

    static class FizzBuzz {
        private int n;

        private Semaphore fizzSemaphore = new Semaphore(0);
        private Semaphore buzzSemaphore = new Semaphore(0);
        private Semaphore fizzBuzzSemaphore = new Semaphore(0);
        private Semaphore numberSemaphore = new Semaphore(1);

        public FizzBuzz(int n) {
            this.n = n;
        }

        private static void accept(int z) {
            System.out.print(z);
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 != 0) {
                    fizzSemaphore.acquire();
                    printFizz.run();
                    next(i + 1);
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 5 == 0 && i % 3 != 0) {
                    buzzSemaphore.acquire();
                    printBuzz.run();
                    next(i + 1);
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    fizzBuzzSemaphore.acquire();
                    printFizzBuzz.run();
                    next(i + 1);
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 != 0 && i % 5 != 0) {
                    numberSemaphore.acquire();
                    printNumber.accept(i);
                    next(i + 1);
                }
            }
        }

        public void next(int number) {
            if (number > n) {
                return;
            }

            if (number % 3 == 0 && number % 5 != 0) {
                fizzSemaphore.release();
            } else if (number % 3 != 0 && number % 5 == 0) {
                buzzSemaphore.release();
            } else if (number % 3 == 0 && number % 5 == 0) {
                fizzBuzzSemaphore.release();
            } else {
                numberSemaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Runnable printFizz = () -> {
            System.out.print("fizz");
        };
        Runnable printBuzz = () -> {
            System.out.print("buzz");
        };
        Runnable printFizzBuzz = () -> {
            System.out.print("fizzbuzz");
        };
        new Thread(() -> {
            try {
                fizzBuzz.fizz(printFizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.number(FizzBuzz::accept);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}