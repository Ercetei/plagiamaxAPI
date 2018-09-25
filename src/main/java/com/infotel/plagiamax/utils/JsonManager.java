package com.infotel.plagiamax.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * The Class JsonManager.
 */
public class JsonManager {
	
	/** The local repo. */
	private final String LOCAL_REPO = "./saves/";
	
	/** The file name. */
	private final String FILE_NAME = "default.test.json";

	/** The mapper. */
	private ObjectMapper mapper = new ObjectMapper();
	
	/** The objects. */
	private ArrayList<Object> objects = new ArrayList<Object>();

	/**
	 * Adds the item.
	 *
	 * @param item the item
	 * @return the json manager
	 */
	public JsonManager addItem(Object item) {
		this.objects.add(item);
		return this;
	}

	/**
	 * Adds the items.
	 *
	 * @param items the items
	 * @return the json manager
	 */
	public JsonManager addItems(ArrayList<?> items) {
		this.objects.addAll(items);
		return this;
	}

	/**
	 * Clear.
	 *
	 * @return the json manager
	 */
	public JsonManager clear() {
		this.objects.clear();
		return this;
	}

	/**
	 * Instantiates a new json manager.
	 */
	private JsonManager() {
		mapper.configure(
				org.codehaus.jackson.JsonGenerator.Feature.QUOTE_FIELD_NAMES,
				true);
	}

	/** The instance. */
	private static JsonManager INSTANCE = new JsonManager();

	/**
	 * Gets the single instance of JsonManager.
	 *
	 * @return single instance of JsonManager
	 */
	public static JsonManager getInstance() {
		return INSTANCE;
	}

	/**
	 * To JSON.
	 *
	 * @return the string
	 */
	public String toJSON() {
		try {
			return mapper.writeValueAsString(this.objects);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Send to file.
	 */
	public void sendToFile() {
		this.sendToFile(this.FILE_NAME, this.LOCAL_REPO);
	}

	/**
	 * Send to file.
	 *
	 * @param filename the filename
	 */
	public void sendToFile(String filename) {
		this.sendToFile(filename, this.LOCAL_REPO);
	}

	/**
	 * Send to file.
	 *
	 * @param filename the filename
	 * @param path the path
	 */
	public void sendToFile(String filename, String path) {
		File file = new File(path);

		if (!file.exists()) {
			System.out.println("creating directory: " + path);
			boolean result = false;

			try {
				result = file.mkdirs();
			} catch (SecurityException se) {
				se.printStackTrace();
			}

			if (result) {
				System.out.println("DIR created");
			}
		}

		file = new File(path + filename);

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(file, false))); // append mode file writer
			mapper.writeValue(out, objects);
			out.close();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("File " + filename + " create in " + path);
	}

	/**
	 * Read from file.
	 *
	 * @param <T> the generic type
	 * @param elem the elem
	 * @return the array list
	 */
	public <T> ArrayList<T> readFromFile(Class<?> elem) {
		return this.<T> readFromFile(this.FILE_NAME, this.LOCAL_REPO, elem);
	}

	/**
	 * Read from file.
	 *
	 * @param <T> the generic type
	 * @param filename the filename
	 * @param elem the elem
	 * @return the array list
	 */
	public <T> ArrayList<T> readFromFile(String filename, Class<?> elem) {
		return this.<T> readFromFile(filename, this.LOCAL_REPO, elem);
	}

	/**
	 * Read from file.
	 *
	 * @param <T> the generic type
	 * @param filename the filename
	 * @param path the path
	 * @param elem the elem
	 * @return the array list
	 */
	public <T> ArrayList<T> readFromFile(String filename, String path,
			Class<?> elem) {

		try {
			return mapper.readValue(
					new File(path + filename),
					mapper.getTypeFactory().constructCollectionType(
							ArrayList.class, elem));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}