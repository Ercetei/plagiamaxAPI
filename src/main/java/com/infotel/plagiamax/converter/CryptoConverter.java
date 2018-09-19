package com.infotel.plagiamax.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.infotel.plagiamax.utils.AES;

// TODO: Auto-generated Javadoc
/**
 * The Class CryptoConverter.
 */
@Converter
public class CryptoConverter implements AttributeConverter<String, String> {
	
	/** The Constant KEY. */
	private static final String KEY = "Bar12345Bar12345"; // 128 bit key
	
	/** The Constant INIT_VECTOR. */
	private static final String INIT_VECTOR = "RandomInitVector"; // 16 bytes IV

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
	 */
	public String convertToDatabaseColumn(String ccNumber) {
		try {
			return AES.encrypt(KEY, INIT_VECTOR, ccNumber).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
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