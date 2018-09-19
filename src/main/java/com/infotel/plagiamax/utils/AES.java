package com.infotel.plagiamax.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

// TODO: Auto-generated Javadoc
/**
 * The Class AES.
 */
public class AES {

	/** The Constant ENCODING. */
	private static final String ENCODING = "UTF-8";
	
	/** The Constant ALGORITHM. */
	private static final String ALGORITHM = "AES/CBC/PKCS5PADDING";
	
	/** The Constant SECRET_ALGORITHM. */
	private static final String SECRET_ALGORITHM = "AES";
	
	/**
	 * Encrypt.
	 *
	 * @param key the key
	 * @param initVector the init vector
	 * @param value the value
	 * @return the string
	 */
	public static String encrypt(String key, String initVector, String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(ENCODING));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(ENCODING), SECRET_ALGORITHM);

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());

            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Decrypt.
     *
     * @param key the key
     * @param initVector the init vector
     * @param encrypted the encrypted
     * @return the string
     */
    public static String decrypt(String key, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(ENCODING));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(ENCODING), SECRET_ALGORITHM);

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
