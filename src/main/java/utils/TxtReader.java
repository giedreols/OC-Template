package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtReader {

	private static List<String> records;
	private static String record;

	public static List<String> getRecods(String fileName) throws IOException {
		records = new ArrayList<String>();

		try (BufferedReader buffer = new BufferedReader(new FileReader(fileName));) {

			while ((record = buffer.readLine()) != null) {
				records.add(record);
			}
		}
		return records;
	}

}