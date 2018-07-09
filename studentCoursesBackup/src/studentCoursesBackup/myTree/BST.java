package studentCoursesBackup.myTree;

import java.util.ArrayList;
import studentCoursesBackup.util.Results;
public class BST {
	private Node root;
	private Node newNode = null;
	Results rs=new Results();
	
	
	public void printNodes(Results rs1){
		this.rs=rs1;
		traverseBST(this.root);
	}
	private void traverseBST(Node node) {
		if (node != null) {
			rs.storeNewResult(node.Bno + ":" + node.course + "\n");
			traverseBST(node.left);
			traverseBST(node.right);
		}
	}
	private Node insert(Node node, Integer data, String courseData) {
		if (node == null)
			this.newNode = node = new Node(courseData,data);
		else {
			if (data > node.getBno())
				node.right = insert(node.right, data, courseData);
			else
				node.left = insert(node.left, data, courseData);
		}

		return node;
	}
	public Node insert(int data, String courseData) {
		root = insert(root, data, courseData);
		return newNode;
	}
	public BST() {
		root = null;
	}

	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	public void deleteCourses(ArrayList<String> courses)
	{
		for(String course: courses)
		{
			int val=Integer.parseInt(course.split(":")[0]);
			String c1=course.split(":")[1];
			Node nodeOfInterest = search(root, val);
			if (nodeOfInterest == null)
				System.out.println("Invalid Bnumber/course .!");
			else
				nodeOfInterest.deleteAndUpdate(c1);
	}
	}
	
	

	/* Function to search for an element recursively */
	private Node search(Node r, int val) {
		while (r != null) {
			int rval = r.getBno();
			if (val < rval)
				r = r.getLeft();
			else if (val > rval)
				r = r.getRight();
			else
				return r;
		}
		return null;
	}
}
