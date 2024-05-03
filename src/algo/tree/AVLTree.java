package algo.tree;

/**
 * @Author Administrator
 * @Date 2024/5/3 10:14
 * @Version 1.0
 */
public class AVLTree {

    TreeNode root;

    public int height(TreeNode node){
        return node == null ? -1 : node.height;
    }

    public void updateHeight(TreeNode node){
        node.height = Math.max(height(node.left),height(node.right)) + 1;
    }

    public int balanceFactor(TreeNode node){
        if (node == null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private TreeNode rightRotate(TreeNode node){
        TreeNode child = node.left;
        TreeNode grandChild = child.right;
        child.right = node;
        node.left = grandChild;
        updateHeight(node);
        updateHeight(child);
        return child;
    }

    private TreeNode leftRotate(TreeNode node){
        TreeNode child = node.right;
        TreeNode grandChild = child.left;
        child.left = node;
        node.right = grandChild;
        updateHeight(node);
        updateHeight(child);
        return child;
    }

    private TreeNode rotate(TreeNode node){
        int balanceFactor = balanceFactor(node);
        if (balanceFactor > 1){
            if (balanceFactor(node.left) >= 0){
                return rightRotate(node);
            }else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (balanceFactor < -1){
            if (balanceFactor(node.right) <= 0){
                return leftRotate(node);
            }else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    public void insert(int val){
        root = insertHelper(root,val);
    }
    private TreeNode insertHelper(TreeNode node,int val){
        if (node == null){
            return new TreeNode(val);
        }
        if (val < node.val){
            node.left = insertHelper(node.left,val);
        }else if (val > node.val){
            node.right = insertHelper(node.right,val);
        }else {
            return node;
        }
        updateHeight(node);
        node = rotate(node);
        return node;
    }

    private TreeNode removeHelper(TreeNode node,int val){
        if (node == null){
            return null;
        }
        if (val < node.val){
            node.left = removeHelper(node.left,val);
        }else if (val > node.val){
            node.right = removeHelper(node.right,val);
        }else {
            if (node.left == null || node.right == null){
                TreeNode child = node.left!=null?node.left:node.right;
                if (child == null){
                    return null;
                }else {
                    node = child;
                }
            }else {
                TreeNode temp = node.right;
                while (temp.left != null){
                    temp = temp.left;
                }
                node.right = removeHelper(node.right,temp.val);
                node.val = temp.val;
            }
        }
        updateHeight(node);
        node = rotate(node);
        return node;
    }

    public TreeNode search(int val){
        TreeNode cur = root;
        while (cur!=null){
            if (val < cur.val){
                cur = cur.left;
            }else if (val > cur.val){
                cur = cur.right;
            }else {
                break;
            }
        }
        return cur;
    }

}
