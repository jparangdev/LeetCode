package medium;

public class BinarySearchTree {

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null) {
			root = new TreeNode(val);
		} else {
			insertNode(root, val);
		}

		return root;
	}

	public void insertNode(TreeNode node, int val) {
		if(node.val < val) {
			if(node.right == null) {
				node.right = new TreeNode(val);
			} else {
				insertNode(node.right,val);
			}
		} else {
			if(node.left == null) {
				node.left = new TreeNode(val);
			} else {
				insertNode(node.left, val);
			}
		}
	}

	public TreeNode searchBST(TreeNode root, int val) {
		return searchNode(root, val);
	}

	public TreeNode searchNode(TreeNode node, int val) {
		if(node.val == val) return node;

		if(node.val > val) {
			if(node.left != null) {
				return searchNode(node.left, val);
			} else {
				return null;
			}
		} else {
			if(node.right != null) {
				return searchNode(node.right, val);
			} else {
				return null;
			}
		}
	}


}
