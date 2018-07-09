package studentCoursesBackup.util;

import studentCoursesBackup.myTree.BST;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.ObserverI;
public class TreeBuilder {

	FileProcessor fp = null;
	public BST cloneTree1 = null, cloneTree2 = null;
	
	public TreeBuilder(FileProcessor fileProcessor) {
		this.fp = fileProcessor;
	}
	
	// Creating main tree and clone trees
	public BST buildTree()
	{
		BST tree = new BST();
		BST cloneTree1 = new BST();
		BST cloneTree2 = new BST();
		String st = "";
		while((st = fp.readline()) != null){
			String[] stringData = st.split(":");
			Node node = tree.insert(Integer.parseInt(stringData[0]), stringData[1]);
			Node clone1 = cloneTree1.insert(Integer.parseInt(stringData[0]), stringData[1]);
			Node clone2 = cloneTree2.insert(Integer.parseInt(stringData[0]), stringData[1]);
			node.Subscribe((ObserverI)clone1);
			node.Subscribe((ObserverI)clone2);	
		}
		this.cloneTree1 = cloneTree1;
		this.cloneTree2 = cloneTree2;
		return tree;
	}
}
