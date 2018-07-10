package studentCoursesBackup.util;

import studentCoursesBackup.util.MyLogger.DebugLevel;
import studentCoursesBackup.util.MyLogger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author akshay This class Stores the results of all the operations performed
 *         in the package.
 */
public class Results {
	public ArrayList<String> resList = new ArrayList<String>();
	// add strings to the ArrayList
	private static Results resultI;

	public static Results Instance() {
		if (resultI == null) {
			resultI = new Results();
		}
		return resultI;
	}

	// This method stores all the results in an array list and then writes them
	// to file or STDDISPLAY
	public void storeNewResult(String s) {
		resList.add(s);
	}

	// Used to write to the Output file Specified
	public void writeToFile(String s) {
		File f1 = null;
		FileWriter fp1 = null;
		try {
			f1 = new File(s);
			fp1 = new FileWriter(f1);
			fp1.write("" + resList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fp1.close();
			} catch (IOException e) {
				MyLogger.writeMessage("Cannot Create Output File",
						DebugLevel.FILE_PROCESSOR);
				e.printStackTrace();
			}
		}
	}

	// Write to console.
	public void writeToStdout() {
		MyLogger.writeMessage("" + resList, DebugLevel.OBSERVERS);
		// System.out.println(resList + " \n");
	}

	public void clear() {
		resList.removeAll(resList);
	}
}
