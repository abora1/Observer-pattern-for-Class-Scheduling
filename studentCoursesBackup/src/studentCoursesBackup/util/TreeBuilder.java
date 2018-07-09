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
		BST cloneTree1In = new BST();
		BST cloneTree2In = new BST();
		String st = "";
		while((st = fp.readline()) != null){
			Node node = tree.insert(Integer.parseInt(st.split(":")[0]), st.split(":")[1]);
			Node clone1 = cloneTree1In.insert(Integer.parseInt(st.split(":")[0]), st.split(":")[1]);
			Node clone2 = cloneTree2In.insert(Integer.parseInt(st.split(":")[0]), st.split(":")[1]);
			node.Subscribe((ObserverI)clone1);
			node.Subscribe((ObserverI)clone2);	
		}
		this.cloneTree1 = cloneTree1In;
		this.cloneTree2 = cloneTree2In;
		return tree;
	}
}
