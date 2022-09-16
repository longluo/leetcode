//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
//
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 753 👎 0


// 2022-09-16 08:55:51
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
public:
    priority_queue<int, vector<int>, less<int>> queueMin;
    priority_queue<int, vector<int>, greater<int>> queueMax;

    MedianFinder() {

    }

    void addNum(int num) {
        if (queueMin.empty() || num <= queueMin.top()) {
            queueMin.push(num);
            if (queueMax.size() + 1 < queueMin.size()) {
                int top = queueMin.top();
                queueMin.pop();
                queueMax.push(top);
            }
        } else {
            queueMax.push(num);
            if (queueMax.size() > queueMin.size()) {
                int top = queueMax.top();
                queueMax.pop();
                queueMin.push(top);
            }
        }
    }

    double findMedian() {
        if (queueMin.size() == queueMax.size()) {
            return (queueMin.top() + queueMax.top()) / 2.0;
        }

        return queueMin.top();
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    cout << "Hello LeetCode" << endl;
}

