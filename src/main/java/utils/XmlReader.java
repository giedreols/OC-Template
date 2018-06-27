package utils;

import java.io.File;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

public class XmlReader {

	private static XStream xstream;

	public static <T> ArrayList<T> readDataFromXML(String fileName) {
		
		xstream = new XStream();
		
		return (ArrayList<T>) xstream.fromXML(new File(fileName));
	}
}
