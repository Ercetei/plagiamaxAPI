package com.infotel.plagiamax.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericMerger.
 */
public class GenericMerger {

    /**
     * Merge.
     *
     * @param <T> the generic type
     * @param dbItem the db item
     * @param partialItem the partial item
     * @param klazz the klazz
     * @return the t
     */
    public static <T> T merge(T dbItem, T partialItem, Class<?> klazz) {

        ArrayList<Field> fields = DumpFields.getFields(klazz);

        for (Field field : fields) {
                Method getter = DumpFields.getGetter(field);
                try {
                	if (getter != null && getter.invoke(partialItem) !=  null) {
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
