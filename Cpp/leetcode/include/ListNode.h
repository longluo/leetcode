//
// Created by longluo on 2022/4/9.
//

#ifndef LEETCODE_LISTNODE_H
#define LEETCODE_LISTNODE_H

// Definition for singly-linked list.
struct ListNode {
    int val;

    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

#endif //LEETCODE_LISTNODE_H
