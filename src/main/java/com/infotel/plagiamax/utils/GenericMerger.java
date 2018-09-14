package com.infotel.plagiamax.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class GenericMerger {

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
