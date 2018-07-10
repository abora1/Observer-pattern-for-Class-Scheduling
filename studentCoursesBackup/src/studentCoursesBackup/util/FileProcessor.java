package studentCoursesBackup.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.MyLogger.DebugLevel;

;
public class FileProcessor {
	public FileProcessor() {
	}

	private BufferedReader br = null;

	public FileProcessor(String input) {
		try {
			File f = new File(input);
			if (!f.exists()) {
				MyLogger.writeMessage("THE GIVEN INPUT FILE IS INVALID",
						DebugLevel.FILE_PROCESSOR);
				System.exit(0);
			}
			br = new BufferedReader(new FileReader(f));
			MyLogger.writeMessage("New File has Been Accepted",
					DebugLevel.FILE_PROCESSOR);

		} catch (IOException e) {
			MyLogger.writeMessage("NO INPUT FILE FOUND",
					DebugLevel.FILE_PROCESSOR);
			e.printStackTrace();
			System.exit(0);
		}

	}

	// this method returns a single line from the file to user.
	public String readline() {
		try {
			String s = null;
			while ((s = br.readLine()) != null) {
				return s;
			}
		} catch (IOException e) {
			MyLogger.writeMessage("INPUT FILE CANNOT BE FETCHED",
					DebugLevel.FILE_PROCESSOR);
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}

	public ArrayList<String> deleteFileRead() {
		ArrayList<String> delEntries = new ArrayList<String>();
		try {
			String str = null;
			while ((str = br.readLine()) != null)
				delEntries.add(str);
			this.fileclose();
			return delEntries;
		} catch (IOException e) {
			MyLogger.writeMessage("DELETE FILE CANNOT BE READ",
					DebugLevel.FILE_PROCESSOR);
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}

	// closes the file when completes execution.
	public void fileclose() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
