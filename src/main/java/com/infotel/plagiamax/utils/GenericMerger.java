package com.infotel.plagiamax.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * The Class GenericMerger.
 */
public class GenericMerger {

	/**
	 * Merge.
	 *
	 * @param<T> the type of object to merge
	 * @param dbItem : the version of the item inside of the database
	 * @param partialItem : the item to merge with the first one
	 * @param klazz : the object's class
	 * @return the merged object
	 */
	public static <T> T merge(T dbItem, T partialItem, Class<?> klazz) {

		ArrayList<Field> fields = DumpFields.getFields(klazz);

		for (Field field : fields) {
			Method getter = DumpFields.getGetter(field);
			try {
				if (getter != null && getter.invoke(partialItem) != null) {
					if (!getter.invoke(dbItem).equals(getter.invoke(partialItem))) {
						Method setter = DumpFields.getSetter(field);
						setter.invoke(dbItem, getter.invoke(partialItem));
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		return dbItem;
	}
}
