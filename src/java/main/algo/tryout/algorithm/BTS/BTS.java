package algo.tryout.algorithm.BTS;

public class BTS {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.add(4);
		root.add(3);
		root.add(2);
		root.add(1);
		root.add(0);
		root.add(10);
		root.add(9);
		root.add(8);
		root.add(7);
		root.add(6);
		root.inOrderTraversal();
		root.preOrderTraversal();
		root.postOrderTraversal();

	}

	private static class Node {
		private Integer value;
		private Node left, right;

		public Node(Integer val) {
			this.value = val;
		}

		public void add(Integer val) {
			if (null == this.value) {
				this.value = val;
			} else if (val > value) {
				if (null == right) {
					right = new Node(val);
				} else {
					right.add(val);
				}
			} else if (val < value) {
				if (null == left) {
					left = new Node(val);
				} else {
					left.add(val);
				}
			}
		}

		public boolean search(Integer val) {
			if (val == value) {
				return true;
			} else if (val > value) {
				if (null != right) {
					return right.search(val);
				}
			} else {
				if (null != left) {
					return left.search(val);
				}
			}
			return false;

		}

		public void inOrderTraversal() {
			StringBuilder builder = new StringBuilder();
			traversalLeft(builder, this.left);
			builder.append(value).append(",");
			traversalRight(builder, this.right);
			System.out.println(builder.toString());

		}

		public void preOrderTraversal() {
			StringBuilder builder = new StringBuilder();
			builder.append(value).append(",");
			traversalLeft(builder, this.left);
			traversalRight(builder, this.right);
			System.out.println(builder.toString());

		}

		public void postOrderTraversal() {
			StringBuilder builder = new StringBuilder();
			traversalLeft(builder, this.left);
			traversalRight(builder, this.right);
			builder.append(value).append(",");
			System.out.println(builder.toString());
		}

		public void delete(int value) {

		}

		private void traversalLeft(StringBuilder builder, Node node) {
			if (node.left != null) {
				traversalLeft(builder, node.left);
			}
			builder.append(node.value).append(",");

		}

		private void traversalRight(StringBuilder builder, Node node) {
			if (node.right != null) {
				traversalRight(builder, node.right);
			}
			builder.append(node.value).append(",");

		}
	}

}
