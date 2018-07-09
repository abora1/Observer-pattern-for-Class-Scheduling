package studentCoursesBackup.driver;

import java.util.ArrayList;

import studentCoursesBackup.myTree.BST;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;


public class Driver {
	public static void main(String[] args) {
		ArrayList<String> list=new <String>ArrayList();
		try {
			// It create Results and myArrayList objects and passes them to the
			// test me function
			if (args.length != 2) {
				System.out.println("Please Enter Both Input and Output Files");
				System.exit(0);
			}
			String abc = args[0];
			String abc1 = args[1];
			FileProcessor fp=new FileProcessor(abc);
			TreeBuilder t1=new TreeBuilder(fp);
			BST tree=t1.buildTree();
			Results rs=new Results();
			Results rs1=new Results();
			tree.printNodes(rs);
			t1.cloneTree1.printNodes(rs1);
			//rs.writeToStdout();
			//rs1.writeToStdout();
			rs.clear();
			rs1.clear();
			fp.fileclose();
			FileProcessor fp1=new FileProcessor(abc1);
			list=fp1.deleteFileRead();
			tree.deleteCourses(list);
			tree.printNodes(rs);
			t1.cloneTree1.printNodes(rs1);
			rs.writeToStdout();
			rs1.writeToStdout();
		}
		catch(Exception e){
			
		}
	}
}
