package ch.wurmlo.daai.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadIntegerArrayFile {

	private static String FILE_NAME = "IntegerArray.txt";
	
	public static int[] readIntegersFromFile() {
		InputStream stream = ReadIntegerArrayFile.class.getResourceAsStream(FILE_NAME);
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		List<String> linesInFile = new ArrayList<String>();
		try {
			while(reader.ready()) {
				String line = reader.readLine();
				linesInFile.add(line);
			}
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException("Could not read the integer array file.", e);
		} 
		if(linesInFile.size() != 100000) {
			throw new RuntimeException("Input file has different length than 100'000 lines.");
		}
		int[] integers = new int[linesInFile.size()];
		for(int i = 0; i < linesInFile.size(); i++) {
			integers[i] = Integer.valueOf(linesInFile.get(i));
		}
		return integers;
	}
}
