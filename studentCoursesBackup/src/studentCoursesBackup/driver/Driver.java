package studentCoursesBackup.driver;

import java.util.ArrayList;

import studentCoursesBackup.myTree.BST;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.MyLogger;

public class Driver {
	public static void main(String[] args) {
		ArrayList<String> list = new<String> ArrayList();
		try {
			// IT creates the Instances of the three trees,Reads the Input and Delete File
			//Apply operations of these files and then also read the Output files to store the results.
			//Creates Instances of the results class to stores the OBservers and The Main Tree.
			if (args.length != 6) {
				System.out
						.println("Please Enter All Input,Delete and Output Files along with the debug value");
				System.exit(0);
			}
			String input = args[0];
			String delete = args[1];
			String output1 = args[2];
			String output2 = args[3];
			String output3 = args[4];
			int debug = Integer.parseInt(args[5]);
			if (input == null || delete == null) {
				System.out.println("THE INPUT OR DELETE FILE IS EMPTY");
				System.exit(0);
			}
			MyLogger.setDebugValue(debug);
			FileProcessor fp = new FileProcessor(input);
			TreeBuilder t1 = new TreeBuilder(fp);
			BST tree = t1.buildTree();
			Results rs = new Results();
			Results rs1 = new Results();
			Results rs2 = new Results();
			rs.storeNewResult("THE MAIN INPUT FILE IS\n");
			rs1.storeNewResult("THE FIRST OBSERVER INPUT FILE IS\n");
			rs2.storeNewResult("THE SECOND OBSERVER INPUT FILE IS\n");
			tree.printNodes(rs);
			t1.cloneTree1.printNodes(rs1);
			t1.cloneTree2.printNodes(rs2);
			rs.writeToStdout();
			rs1.writeToStdout();
			rs2.writeToStdout();
			rs.clear();
			rs1.clear();
			rs2.clear();
			fp.fileclose();
			FileProcessor fp1 = new FileProcessor(delete);
			list = fp1.deleteFileRead();
			tree.deleteCourses(list);
			fp1.fileclose();
			rs.storeNewResult("THE MAIN OUTPUT FILE AFTER DELETING IS\n");
			rs1.storeNewResult("THE FIRST OBSERVER FILE AFTER DELETING FILE IS\n");
			rs2.storeNewResult("THE SECOND OBSERVER FILE AFTER DELETING FILE IS\n");
			tree.printNodes(rs);
			t1.cloneTree1.printNodes(rs1);
			t1.cloneTree2.printNodes(rs2);
			rs.writeToStdout();
			rs1.writeToStdout();
			rs2.writeToStdout();
			rs.writeToFile(output1);
			rs1.writeToFile(output2);
			rs2.writeToFile(output3);
		} catch (Exception e) {

		}
	}
}
