# Prompt
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes 
(the leftmost and rightmost non-null nodes), where the null nodes between 
the end-nodes that would be present in a complete binary tree extending down 
to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

# Notes
- 4 ways to traverse BT
    - Inorder (Left,root,right)
    - Preorder (Root, Left, Right)
    - Postorder (Left, Right, Root)
    - Breadth-First or Level Order Traversal
- BT properties
    - The maximum number of nodes at level ‘l’ of a binary tree is 2^l
    - The Maximum number of nodes in a binary tree of height ‘h’ is 2^h – 1..
    - In a Binary Tree with N nodes, minimum possible height or the minimum number of   levels is Log2(N+1).
    - A Binary Tree with L leaves has at least | Log2L |+ 1   levels
    -  In Binary tree where every node has 0 or 2 children, the number of leaf nodes is always one more than nodes with two children
    - In a non empty binary tree, if n is the total number of nodes and e is the total number of edges, then e = n-1