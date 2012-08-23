package ch.wurmlo.daaii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadIntegerArrayFileForTest {
	
	public static int[] readIntegersFromFile(String fileName) {
		InputStream stream = ReadIntegerArrayFile.class.getResourceAsStream(fileName);
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
		int[] integers = new int[linesInFile.size()];
		for(int i = 0; i < linesInFile.size(); i++) {
			integers[i] = Integer.valueOf(linesInFile.get(i));
		}
		return integers;
	}
}
