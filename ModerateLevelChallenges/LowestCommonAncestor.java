package ModerateLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LowestCommonAncestor {
	private static Node root;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File(args[0]));
		initializeBST();
		while (file.hasNextLine())
		{
			String line = file.nextLine();
			String[] stringInputs = line.split(" ");
			int[] inputs = new int[2];
			for (int i = 0; i < stringInputs.length; i++)
				inputs[i] = Integer.parseInt(stringInputs[i]);
			Node lowestCommonAncestor = root.findLowestCommonAncestor(root, inputs[0], inputs[1]);
			System.out.println(lowestCommonAncestor.data);

		}
		file.close();
	}

	/**
	 * Initialize BST with hard coded values as per the instructions
	 */
	private static void initializeBST() {
		root = new Node(20, new Node(10), new Node(29));
		root = new Node(8, new Node(3), root);
		root = new Node(30, root, new Node(52));
	}

	/**
	 * Node class to represent a BST
	 */
	private static class Node {
		private int data;
		private Node leftChild;
		private Node rightChild;

		public Node(int data) {
			this.data = data;
		}

		public Node(int data, Node leftChild, Node rightChild) {
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		/**
		 * Finds the lowest common ancestor of two integers in BST
		 * From the current node, check to see if both integers are contained in the left subtree,
		 * right subtree, or both. If the integers are on one side of the current node, we can
		 * traverse down another level until we reach the point where both integers are on either side
		 * of our current node. When we reach that point, our current node is the lowest common ancestor.
		 * @param node current node
		 * @param data1 first integer
		 * @param data2 second integer
		 * @return reference to node of lowest common ancestor
		 */
		public Node findLowestCommonAncestor(Node node, int data1, int data2) {
			if (node == null)
				return null;
			if (node.data == data1 || node.data == data2)
				return node;

			Node leftSubtree = findLowestCommonAncestor(node.leftChild, data1, data2);
			Node rightSubtree = findLowestCommonAncestor(node.rightChild, data1, data2);

			if (leftSubtree == null)
				return findLowestCommonAncestor(node.rightChild, data1, data2);
			if (rightSubtree == null)
				return findLowestCommonAncestor(node.leftChild, data1, data2);
			if (leftSubtree != null && rightSubtree != null)
				return node;
			return node;
		}
	}
}
