package com.abc.algo.tree;

/**
 * @Author Administrator
 * @Date 2025/9/20 21:50
 * @Version 1.0
 */
public class RedBlackNode {
    int key;
    Color color;
    RedBlackNode left, right,parent;

    public RedBlackNode(int key)
    {
        this.key = key;
        this.color = Color.RED;
        this.left = this.right = this.parent = null;
    }
}
