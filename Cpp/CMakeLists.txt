cmake_minimum_required(VERSION 3.16)

project(Leetcode)

set(CMAKE_CXX_STANDARD 14)

include_directories("leetcode/include")

add_executable(main main.cpp)

add_executable(9_palindrome-number leetcode/editor/cn/9_palindrome-number.cpp)

add_executable(896_monotonic-array leetcode/editor/cn/896_monotonic-array.cpp main.cpp)

add_executable(209_minimum-size-subarray-sum leetcode/editor/cn/209_minimum-size-subarray-sum.cpp leetcode/include/TreeNode.h)

add_executable(101_symmetric-tree leetcode/editor/cn/101_symmetric-tree.cpp leetcode/include/ListNode.h)
add_executable(733_flood-fill leetcode/editor/cn/733_flood-fill.cpp)
add_executable(997_find-the-town-judge leetcode/editor/cn/997_find-the-town-judge.cpp)
add_executable(226_invert-binary-tree leetcode/editor/cn/226_invert-binary-tree.cpp)
add_executable(804_unique-morse-code-words leetcode/editor/cn/804_unique-morse-code-words.cpp)