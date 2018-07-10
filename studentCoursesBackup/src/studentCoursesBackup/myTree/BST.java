package studentCoursesBackup.myTree;

import java.util.ArrayList;
import studentCoursesBackup.util.Results;

/**
 * @author AKshay bora Citation : BST :
 *         http://www.sanfoundry.com/java-program-implement-binary-search-tree/
 *         BST Implementation.
 */
public class BST {
	private Node root;
	private Node newNode = null;
	Results rs = new Results();

	public void printNodes(Results rs1) {
		this.rs = rs1;
		traverseBST(this.root);
	}

	private void traverseBST(Node node) {
		if (node != null) {
			traverseBST(node.left);
			rs.storeNewResult(node.Bno + ":" + node.course + "\n");
			traverseBST(node.right);
		}
	}

	private Node insert(Node node, Integer data, String courseData) {
		if (node == null)
			this.newNode = node = new Node(courseData, data);
		else {
			if (data <= node.getBno())
				node.left = insert(node.left, data, courseData);
			else
				node.right = insert(node.right, data, courseData);
		}

		return node;
	}

	public Node insert(int data, String courseData) {
		Node nodeOfInterest = search(root, data, courseData);
		if (nodeOfInterest != null) {
			return newNode;
		} else {
			root = insert(root, data, courseData);
			return newNode;
		}
	}

	public BST() {
		root = null;
	}

	/* TO Check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	public void deleteCourses(ArrayList<String> courses) {
		for (String course : courses) {
			int val = Integer.parseInt(course.split(":")[0]);
			String c1 = course.split(":")[1];
			Node nodeOfInterest = search(root, val, c1);
			if (nodeOfInterest == null)
				System.out.println("Invalid Bnumber/course .!");
			else
				nodeOfInterest.deleteAndUpdate(c1);
		}
	}

	/* Method to search for a particular BNO,Course */
	private Node search(Node r, int val, String cour) {
		while (r != null) {
			int rval = r.getBno();
			if (val < rval)
				r = r.getLeft();
			else if (val > rval)
				r = r.getRight();
			else if (rval == val && r.getCourse().equals(cour))
				return r;
			else if (rval == val && (r.getCourse().compareTo(cour) != 0)) {
				r = r.getLeft();
			} else {
				return null;

			}
		}
		return null;
	}

}
