package ModerateLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PassTriangle {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner file = new Scanner(new File(args[0]));
		Scanner file = new Scanner(new File("/Users/asdghowns/Desktop/Test.java"));
		int rootNum = Integer.parseInt(file.nextLine().trim());
		Node root = new Node(rootNum);
		Node[] previousRow = new Node[1];
		previousRow[0] = root;
		Node[] currentRow;
		while (file.hasNextLine())
		{
			System.out.println(2);
			String line = file.nextLine().trim();
			String[] currentRowString = line.split(" ");
			currentRow = new Node[currentRowString.length];
			for (int i = 0; i < currentRowString.length; i++)
			{
				int data = Integer.parseInt(currentRowString[i]);
				currentRow[i] = new Node(data);
			}

			previousRow[0].setLeft(currentRow[0]);
			previousRow[0].setRight(currentRow[1]);
			int i = 1;
			int j = 0;
			while (i < previousRow.length)
			{
				if (previousRow[i] == previousRow[i - 1])
				{
					previousRow[i].setLeft(previousRow[i - 1].getLeft());
					previousRow[i].setRight(previousRow[i - 1].getRight());
				}
				else
				{
					previousRow[i].setLeft(currentRow[j]);
					previousRow[i].setRight(currentRow[j + 1]);
					j++;
				}
				i++;
			}
			previousRow = currentRow;
		}
		System.out.println(root);
		file.close();
	}

	private static class Node {
		private int data;
		private Node left;
		private Node right;
		// Used in preOrder method to keep track of current path between different method calls
		private int maxPathLength;
		private int currentPathLength;

		public Node(int num) {
			data = num;
		}

		public int getMaxPath() {
			return preOrder(this);
		}

	   private int preOrder(Node current) {
		   if (current != null)
		   {
			   currentPathLength += current.getData();
			   if (current.isLeafNode())
			   {
				   if (currentPathLength > maxPathLength)
					   maxPathLength = currentPathLength;
			   }
			   else
			   {
				   preOrder(current.getLeft());
				   preOrder(current.getRight());
			   }
		   }
		   return maxPathLength;
	   }

	   private boolean isLeafNode() {
		   return ((this.getLeft() == null) && (this.getRight() == null));
	   }

	   public void setLeft(Node leftChild) { this.left = leftChild; }

	   public void setRight(Node rightChild) { this.right = rightChild; }

	   public int getData() { return data; }

	   public Node getLeft() { return left; }

	   public Node getRight() { return right; }

	   @Override
	public String toString() {
		   Queue<Node> queue = new LinkedList<Node>();
		   queue.add(this);
		   while (!queue.isEmpty())
		   {
			   Node current = queue.remove();
			   System.out.println(current.getData());
			   if (current.getLeft() != null)
				   queue.add(current.getLeft());
			   if (current.getRight() != null)
				   queue.add(current.getRight());
		   }
		   return "";
	   }

	}
}