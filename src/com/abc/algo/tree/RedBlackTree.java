package com.abc.algo.tree;

/**
 * @Author Administrator
 * @Date 2025/9/20 21:51
 * @Version 1.0
 *
 * 所有插入的点默认为红色
 * 变色情况：当前节点的父亲节点是红色，且它的叔叔节点也是空色
 * 1、把父节点颜色改为黑色
 * 2、将叔叔节点改为黑色
 * 3、把祖父节点颜色改为红色
 * 4、把指针移动到祖父节点设为当前要操作的节点
 *
 * 左旋：当前父节点是红色，叔叔节点是黑色的时候，且当前的节点是右子树。左旋以父节点作为左旋点
 * 右旋：当前父节点是红色，叔叔节点是黑色的时候，且当前的节点是左子树。
 *   1、把父节点颜色改为黑色
 *   2、把祖父节点颜色改为红色
 *   3、以祖父节点为旋转点进行旋转
 */
public class RedBlackTree {
    private RedBlackNode root;
    private RedBlackNode NIL;

    /**
     * 构造函数：初始化红黑树，创建一个哨兵节点 NIL 并设置为黑色，
     * 同时将根节点初始化为 NIL。
     */
    public RedBlackTree() {
        NIL = new RedBlackNode(-1);
        NIL.color = Color.BLACK;
        root = NIL;
    }

    /**
     * 插入一个新的键值到红黑树中。
     * 创建新节点并按照二叉搜索树的规则找到插入位置，然后调用 insertFixUp 方法修复可能违反红黑树性质的情况。
     * RB-INSERT(T, z)
     * 01  y ← nil[T]                        // 新建节点“y”，将y设为空节点。
     * 02  x ← root[T]                       // 设“红黑树T”的根节点为“x”
     * 03  while x ≠ nil[T]                  // 找出要插入的节点“z”在二叉树T中的位置“y”
     * 04      do y ← x
     * 05         if key[z] < key[x]
     * 06            then x ← left[x]
     * 07            else x ← right[x]
     * 08  p[z] ← y                          // 设置 “z的父亲” 为 “y”
     * 09  if y = nil[T]
     * 10     then root[T] ← z               // 情况1：若y是空节点，则将z设为根
     * 11     else if key[z] < key[y]
     * 12             then left[y] ← z       // 情况2：若“z所包含的值” < “y所包含的值”，则将z设为“y的左孩子”
     * 13             else right[y] ← z      // 情况3：(“z所包含的值” >= “y所包含的值”)将z设为“y的右孩子”
     * 14  left[z] ← nil[T]                  // z的左孩子设为空
     * 15  right[z] ← nil[T]                 // z的右孩子设为空。至此，已经完成将“节点z插入到二叉树”中了。
     * 16  color[z] ← RED                    // 将z着色为“红色”
     * 17  RB-INSERT-FIXUP(T, z)             // 通过RB-INSERT-FIXUP对红黑树的节点进行颜色修改以及旋转，让树T仍然是一颗红黑树
     * @param key 要插入的整数键值
     */
    public void insert(int key) {

        RedBlackNode node = new RedBlackNode(key);
        node.left = NIL;
        node.right = NIL;

        RedBlackNode y = NIL;
        RedBlackNode x = root;
        // 寻找插入位置
        while (x != NIL) {
            y = x;
            if (node.key < x.key) {
                x = x.left;
            }else {
                x = x.right;
            }
        }
        node.parent = y;
        // 插入节点
        if (y == NIL) {
            root = node;
        } else if (node.key < y.key) {
            y.left = node;
        } else {
            y.right = node;
        }
        insertFixUp(node);
    }

    /**
     * 在插入节点后修复红黑树的性质。
     * 根据父节点和叔叔节点的颜色进行重新着色或旋转操作以恢复红黑树的平衡。
     *
     * RB-INSERT-FIXUP(T, z)
     * 01 while color[p[z]] = RED                                                  // 若“当前节点(z)的父节点是红色”，则进行以下处理。
     * 02     do if p[z] = left[p[p[z]]]                                           // 若“z的父节点”是“z的祖父节点的左孩子”，则进行以下处理。
     * 03           then y ← right[p[p[z]]]                                        // 将y设置为“z的叔叔节点(z的祖父节点的右孩子)”
     * 04                if color[y] = RED                                         // Case 1条件：叔叔是红色
     * 05                   then color[p[z]] ← BLACK                    ▹ Case 1   //  (01) 将“父节点”设为黑色。
     * 06                        color[y] ← BLACK                       ▹ Case 1   //  (02) 将“叔叔节点”设为黑色。
     * 07                        color[p[p[z]]] ← RED                   ▹ Case 1   //  (03) 将“祖父节点”设为“红色”。
     * 08                        z ← p[p[z]]                            ▹ Case 1   //  (04) 将“祖父节点”设为“当前节点”(红色节点)
     * 09                   else if z = right[p[z]]                                // Case 2条件：叔叔是黑色，且当前节点是右孩子
     * 10                           then z ← p[z]                       ▹ Case 2   //  (01) 将“父节点”作为“新的当前节点”。
     * 11                                LEFT-ROTATE(T, z)              ▹ Case 2   //  (02) 以“新的当前节点”为支点进行左旋。
     * 12                           color[p[z]] ← BLACK                 ▹ Case 3   // Case 3条件：叔叔是黑色，且当前节点是左孩子。(01) 将“父节点”设为“黑色”。
     * 13                           color[p[p[z]]] ← RED                ▹ Case 3   //  (02) 将“祖父节点”设为“红色”。
     * 14                           RIGHT-ROTATE(T, p[p[z]])            ▹ Case 3   //  (03) 以“祖父节点”为支点进行右旋。
     * 15        else (same as then clause with "right" and "left" exchanged)      // 若“z的父节点”是“z的祖父节点的右孩子”，将上面的操作中“right”和“left”交换位置，然后依次执行。
     * 16 color[root[T]] ← BLACK
     *
     * @param node 刚刚插入的节点
     */
    private void insertFixUp(RedBlackNode node) {

        // 当父节点是红色时需要修复
        while (node.parent.color == Color.RED) {
            if (node.parent == node.parent.parent.left) {
                RedBlackNode right = node.parent.parent.right;
                // 情况1：叔叔节点是红色
                if (right.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    right.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else {
                    // 情况2：当前节点是右孩子，先左旋
                    if (node == node.parent.right) {
                        node = node.parent;
                        rotateLeft(node);
                    }
                    // 情况3：当前节点是左孩子，右旋并重新着色
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    rotateRight(node.parent.parent);
                }
            }else {
                RedBlackNode left = node.parent.parent.left;
                // 情况1：叔叔节点是红色
                if (left.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    left.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else {
                    // 情况2：当前节点是左孩子，先右旋
                    if (node == node.parent.left) {
                        node = node.parent;
                        rotateRight(node);
                    }
                    // 情况3：当前节点是右孩子，左旋并重新着色
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    rotateLeft(node.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }

    /**
     * 对指定节点执行左旋操作。
     * 将该节点的右子节点提升为新的父节点，并调整相关指针关系。
     *
     * LEFT-ROTATE(T, x)
     * 01  y ← right[x]            // 前提：这里假设x的右孩子为y。下面开始正式操作
     * 02  right[x] ← left[y]      // 将 “y的左孩子” 设为 “x的右孩子”，即 将β设为x的右孩子
     * 03  p[left[y]] ← x          // 将 “x” 设为 “y的左孩子的父亲”，即 将β的父亲设为x
     * 04  p[y] ← p[x]             // 将 “x的父亲” 设为 “y的父亲”
     * 05  if p[x] = nil[T]
     * 06  then root[T] ← y                 // 情况1：如果 “x的父亲” 是空节点，则将y设为根节点
     * 07  else if x = left[p[x]]
     * 08            then left[p[x]] ← y    // 情况2：如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
     * 09            else right[p[x]] ← y   // 情况3：(x是它父节点的右孩子) 将y设为“x的父节点的右孩子”
     * 10  left[y] ← x             // 将 “x” 设为 “y的左孩子”
     * 11  p[x] ← y                // 将 “x的父节点” 设为 “y”
     * @param node 需要进行左旋的节点
     *
     */
    private void rotateLeft(RedBlackNode node) {
        System.out.println("左旋-->" + node.key);
        RedBlackNode right = node.right;
        node.right = right.left;
        if (right.left != NIL) {
            right.left.parent = node;
        }
        right.parent = node.parent;
        if (node.parent == NIL) {
            root = right;
        } else if (node == node.parent.left) {
            node.parent.left = right;
        } else {
            node.parent.right = right;
        }
        right.left = node;
        node.parent = right;

    }

    /**
     * 对指定节点执行右旋操作。
     * 将该节点的左子节点提升为新的父节点，并调整相关指针关系。
     *
     * RIGHT-ROTATE(T, y)
     * 01  x ← left[y]             // 前提：这里假设y的左孩子为x。下面开始正式操作
     * 02  left[y] ← right[x]      // 将 “x的右孩子” 设为 “y的左孩子”，即 将β设为y的左孩子
     * 03  p[right[x]] ← y         // 将 “y” 设为 “x的右孩子的父亲”，即 将β的父亲设为y
     * 04  p[x] ← p[y]             // 将 “y的父亲” 设为 “x的父亲”
     * 05  if p[y] = nil[T]
     * 06  then root[T] ← x                 // 情况1：如果 “y的父亲” 是空节点，则将x设为根节点
     * 07  else if y = right[p[y]]
     * 08            then right[p[y]] ← x   // 情况2：如果 y是它父节点的右孩子，则将x设为“y的父节点的左孩子”
     * 09            else left[p[y]] ← x    // 情况3：(y是它父节点的左孩子) 将x设为“y的父节点的左孩子”
     * 10  right[x] ← y            // 将 “y” 设为 “x的右孩子”
     * 11  p[y] ← x                // 将 “y的父节点” 设为 “x”
     *
     *
     * @param node 需要进行右旋的节点
     */
    private void rotateRight(RedBlackNode node) {
        RedBlackNode left = node.left;
        node.left = left.right;
        if (left.right != NIL) {
            left.right.parent = node;
        }
        left.parent = node.parent;
        if (node.parent == NIL) {
            root = left;
        } else if (node == node.parent.left) {
            node.parent.left = left;
        } else {
            node.parent.right = left;
        }
        left.right = node;
        node.parent = left;
    }

    /**
     * 中序遍历红黑树并打印节点信息。
     * 按照中序遍历顺序访问每个节点，并输出其键值和颜色。
     *
     * @param node 当前遍历的节点
     */
    public void inorderTraverse(RedBlackNode node) {
        if (node != NIL) {
            inorderTraverse(node.left);
            System.out.println(node.key + "(" + (node.color == Color.RED ? "RED" : "BLACK") + ") ");
            inorderTraverse(node.right);
        }
    }

    /**
     * 获取红黑树的根节点。
     *
     * @return 红黑树的根节点
     */
    public RedBlackNode getRoot() {
        return root;
    }


    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        int[] keys = {1,2,3,4,5,6,7,8};

        for (int key : keys) {
            tree.insert(key);
        }
        tree.inorderTraverse(tree.getRoot());
    }


}
