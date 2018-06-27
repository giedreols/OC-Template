package utils;

import java.util.List;

public class FromListToObjectConverter {

	public static <T> Object[][] convert(List<T> list) {

		Object[][] object = new Object[list.size()][1];

		for (int i = 0; i < list.size(); i++) {
			object[i][0] = list.get(i);
		}
		return object;
	}
}
