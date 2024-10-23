package bt;

import leetcodeds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC257BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);

        LC257BinaryTreePaths binaryTreePaths = new LC257BinaryTreePaths();
        binaryTreePaths.binaryTreePaths(node);

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result, new ArrayList<>());
        return result;
    }

    void dfs(TreeNode treeNode, List<String> result, List<String> path) {
        if (isLeafNode(treeNode)) {
            path.add(String.valueOf(treeNode.val));
            result.add(String.join("->", path));
//            System.out.println(result);
            return;
        }

        if (treeNode.left != null) {
            List<String> tempPath = new ArrayList<>(path);

            tempPath.add(String.valueOf(treeNode.val));
            dfs(treeNode.left, result, tempPath);
        }
        if (treeNode.right != null) {
            List<String> tempPath = new ArrayList<>(path);
            tempPath.add(String.valueOf(treeNode.val));
            dfs(treeNode.right, result, tempPath);
        }
    }

    boolean isLeafNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> path = new ArrayList<>();
        pathSumDfs(root, path, new ArrayList<Integer>(), targetSum);

        return path;
    }

    void pathSumDfs(TreeNode root, List<List<Integer>> pathSum, List<Integer> path, int target) {
        if (isLeafNodeForPathSum(root)) {
            path.add(root.val);
            Integer sum = path.stream().mapToInt(Integer::intValue).sum();
            if (sum == target) {
                pathSum.add(path);
            }

            return;
        }

        if (root != null && root.left != null) {
            List<Integer> tempPath = new ArrayList<>(path);
            tempPath.add(root.val);
            pathSumDfs(root.left, pathSum, tempPath, target);
        }
        if (root != null && root.right != null) {
            List<Integer> tempPath = new ArrayList<>(path);
            tempPath.add(root.val);
            pathSumDfs(root.right, pathSum, tempPath, target);
        }
    }

    boolean isLeafNodeForPathSum(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
    /*
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root==null) {
            return res;
        }
        dfs(root, targetSum, new ArrayList<Integer>());
        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> list) {
        list.add(root.val);
        if (root.left==null && root.right == null && targetSum==root.val) {
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        if (root.left!=null) {
            dfs(root.left, targetSum-root.val, list);
        }
        if (root.right!=null) {
            dfs(root.right, targetSum-root.val, list);
        }
        list.remove(list.size()-1);
    }
     */
}
