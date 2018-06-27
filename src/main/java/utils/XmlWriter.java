package utils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

import com.thoughtworks.xstream.XStream;

public class XmlWriter {

	private static XStream xstream;

	public static void write(String fileName, Object item) throws IOException {

		xstream = new XStream();

		FileUtils.writeStringToFile(new File(fileName), xstream.toXML(item));

	}

	public static <E> void writeList(String fileName, Collection<E> items) throws IOException {

		xstream = new XStream();

		FileUtils.writeStringToFile(new File(fileName), xstream.toXML(items));
	}

}