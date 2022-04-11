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
add_executable(1020_number-of-enclaves leetcode/editor/cn/1020_number-of-enclaves.cpp)
add_executable(153_find-minimum-in-rotated-sorted-array leetcode/editor/cn/153_find-minimum-in-rotated-sorted-array.cpp)
add_executable(350_intersection-of-two-arrays-ii leetcode/editor/cn/350_intersection-of-two-arrays-ii.cpp)
add_executable(1855_maximum-distance-between-a-pair-of-values leetcode/editor/cn/1855_maximum-distance-between-a-pair-of-values.cpp)
add_executable(633_sum-of-square-numbers leetcode/editor/cn/633_sum-of-square-numbers.cpp)
add_executable(36_valid-sudoku leetcode/editor/cn/36_valid-sudoku.cpp)
add_executable(121_best-time-to-buy-and-sell-stock leetcode/editor/cn/121_best-time-to-buy-and-sell-stock.cpp)
add_executable(387_first-unique-character-in-a-string leetcode/editor/cn/387_first-unique-character-in-a-string.cpp)
add_executable(383_ransom-note leetcode/editor/cn/383_ransom-note.cpp)
add_executable(141_linked-list-cycle leetcode/editor/cn/141_linked-list-cycle.cpp)
add_executable(21_merge-two-sorted-lists leetcode/editor/cn/21_merge-two-sorted-lists.cpp)
add_executable(203_remove-linked-list-elements leetcode/editor/cn/203_remove-linked-list-elements.cpp)
add_executable(206_reverse-linked-list leetcode/editor/cn/206_reverse-linked-list.cpp)
add_executable(20_valid-parentheses leetcode/editor/cn/20_valid-parentheses.cpp)
add_executable(83_remove-duplicates-from-sorted-list leetcode/editor/cn/83_remove-duplicates-from-sorted-list.cpp)