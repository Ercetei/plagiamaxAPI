package com.infotel.plagiamax.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.infotel.plagiamax.utils.AES;

/**
 * Implements the interface AttributeConverter<String, String> (Entity
 * Attribute, Database Column)
 * 
 * Converts the entity attribute into a database column representation and back
 * again.
 */
@Converter
public class CryptoConverter implements AttributeConverter<String, String> {

	/** The Constant KEY. */
	private static final String KEY = "Bar12345Bar12345"; // 128 bit key

	/** The Constant INIT_VECTOR. */
	private static final String INIT_VECTOR = "RandomInitVector"; // 16 bytes IV

	/**
	 * Implements the convertToDatabaseColum operation of AttributeConverter
	 *
	 * @param ccNumber : the entity attribute value to be converted
	 * @return the converted data to be stored in the database column
	 */
	public String convertToDatabaseColumn(String ccNumber) {
		try {
			return AES.encrypt(KEY, INIT_VECTOR, ccNumber).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Implements the convertToEntityAttribute operation of AttributeConverter
	 *
	 * @param dbData : the data from the database column to be converted
	 * @return the converted value to be stored in the entity attribute
	 */
	public String convertToEntityAttribute(String dbData) {
		try {
			return AES.decrypt(KEY, INIT_VECTOR, dbData);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}