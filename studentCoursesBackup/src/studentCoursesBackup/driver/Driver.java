package studentCoursesBackup.driver;

import java.util.ArrayList;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;


public class Driver {
	public static void main(String[] args) {
		ArrayList<String> delEntries = new ArrayList<String>();
		ArrayList<String> delEntries1 = new ArrayList<String>();
		try {
			// It create Results and myArrayList objects and passes them to the
			// test me function
			if (args.length != 2) {
				System.out.println("Please Enter Both Input and Output Files");
				System.exit(0);
			}
			String abc = args[0];
			String abc1 = args[1];
			//int q = Integer.parseInt(args[2]);
			FileProcessor fp=new FileProcessor(abc);
			Results rs=new Results();
			Results rs1=new Results();
			delEntries=fp.deleteFileRead();
			for(String Entry:delEntries)
			{
				rs.storeNewResult(Entry+"\n");
				//System.out.println(Entry+"\n");
			}
			rs.writeToStdout();
			fp.fileclose();
			FileProcessor fp1=new FileProcessor(abc1);
			delEntries1=fp1.deleteFileRead();
			for(String E:delEntries1)
			{
				rs1.storeNewResult(E+"\n");
				//System.out.println(E+"\n");
			}
			rs1.writeToStdout();
		}
		catch(Exception e){
			
		}
	}
}
