package com.infotel.plagiamax.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GenericMerger {

    public static <T> T merge(T toMerge, T dbItem, List<String> fieldsToCheck, Class<?> klazz) {

        ArrayList<Field> fields = DumpFields.getFields(klazz);

        for (Field field : fields) {
            if (fieldsToCheck.contains(field.getName())) {

                Method getter = DumpFields.getGetter(field);
                try {
                    if (!getter.invoke(toMerge).equals(getter.invoke(dbItem))) {
                        Method setter = DumpFields.getSetter(field);
                        setter.invoke(toMerge, getter.invoke(dbItem));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return toMerge;
    }
}
