package 数据结构和算法;

import sun.reflect.generics.tree.Tree;

public class 二叉树 {
    public static void main(String[] args){
        myTree myTree = new myTree();

//        myTree.insert(50);
//        myTree.insert(20);
//        myTree.insert(80);
//        myTree.insert(10);
//        myTree.insert(30);
//        myTree.insert(60);
//        myTree.insert(90);
//        myTree.insert(25);
//        myTree.insert(85);
//        myTree.insert(100);

        myTree.insert(10);
        myTree.insert(8);
        myTree.insert(15);
        myTree.insert(4);
        myTree.insert(9);
        myTree.insert(11);
        myTree.insert(20);
        myTree.insert(5);
        myTree.zxfind(myTree.getRoot());
        System.out.println();
        myTree.qxfind(myTree.getRoot());
        System.out.println();
        myTree.hxfind(myTree.getRoot());
    }
}


class TreeNode{

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}


class myTree{

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void qxfind(TreeNode obj) {
        if (obj!=null){
            zxfind(obj.left);
            zxfind(obj.right);
        }
    }

    public void zxfind(TreeNode obj) {
        if (obj!=null){
            zxfind(obj.left);
            System.out.print(obj.val+"-");
            zxfind(obj.right);
        }
    }

    public void hxfind(TreeNode obj) {
        if (obj!=null){
            zxfind(obj.left);
            zxfind(obj.right);
        }
    }

    public boolean insert(int obj) {
        TreeNode treeNode = new TreeNode(obj);
        if (root == null){
            root = treeNode;
            return true;
        }else{
            TreeNode current = root;
            TreeNode parentNode = null;
            while(current!=null){
                parentNode = current;
                if (current.val > obj){
                    current = current.left;
                    if (current==null){
                        parentNode.left = treeNode;
                    }
                }else{
                    current = current.right;
                    if (current==null){
                        parentNode.right = treeNode;
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public boolean delete(int obj) {
        return false;
    }
}