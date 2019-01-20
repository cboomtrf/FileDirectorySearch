package search;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 * @author CBoom (cboom.trf@gmail.com)
 *
 */
public class DirSearcher {
	
	public DirSearcher() {
		super();
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Which directory do you want to search? ");
		String searchPath = input.nextLine();
		input.close();
		
		DirSearcher searcher = new DirSearcher();
		ArrayList<String> javaFiles = searcher.search(new File(searchPath));
		searcher.printAllFilenames(javaFiles);	
	}
	
	private ArrayList<String> search(File f) {
		ArrayList<String> res = new ArrayList<String>();
		if ( f.isDirectory() ) {
			File[] contents = f.listFiles();
			for (int i = 0; i < contents.length; i++) {
				res.addAll(search(contents[i]));
			}
		} else {
			if (f.getName().endsWith(".java")) {
				res.add(f.getAbsolutePath());
			}
		}
		return res;
	}
	
	private void printAllFilenames(ArrayList<String> fileNames) {
		for (Iterator<String> iterator = fileNames.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string);
		}
	}
}
