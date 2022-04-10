//
// Created by longluo on 2022/4/9.
//

#ifndef CPP_TREENODE_H
#define CPP_TREENODE_H

// TreeNode
struct TreeNode {
    int val;

    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

#endif //CPP_TREENODE_H
