package com.infotel.plagiamax.controller.firebase;

import com.infotel.plagiamax.model.firebase.FirebaseResponse;
import com.infotel.plagiamax.utils.JacksonUtility;
import com.google.firebase.FirebaseException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 * The Class Firebase. Defines a Firebase object to be used by the controller.
 */
public class Firebase {

	/** The Constant FIREBASE_API_JSON_EXTENSION. */
	public static final String FIREBASE_API_JSON_EXTENSION = ".json";

///////////////////////////////////////////////////////////////////////////////
//
// PROPERTIES & CONSTRUCTORS
//
///////////////////////////////////////////////////////////////////////////////

	/** The base url. */
	private final String baseUrl;

	/** The secure token. */
	private String secureToken = null;

	/** The query. */
	private List<NameValuePair> query;

	/**
	 * Instantiates a new firebase.
	 *
	 * @param baseUrl the base url
	 * @throws FirebaseException the firebase exception
	 */
	public Firebase(String baseUrl) throws FirebaseException {

		if (baseUrl == null || baseUrl.trim().isEmpty()) {
			String msg = "baseUrl cannot be null or empty; was: '" + baseUrl + "'";
			System.err.println(msg);
			throw new FirebaseException(msg);
		}
		this.baseUrl = baseUrl.trim();
		query = new ArrayList<NameValuePair>();
		System.out.println("intialized with base-url: " + this.baseUrl);
	}

	/**
	 * Instantiates a new firebase.
	 *
	 * @param baseUrl     the base url
	 * @param secureToken the secure token
	 * @throws FirebaseException the firebase exception
	 */
	public Firebase(String baseUrl, String secureToken) throws FirebaseException {
		if (baseUrl == null || baseUrl.trim().isEmpty()) {
			String msg = "baseUrl cannot be null or empty; was: '" + baseUrl + "'";
			System.err.println(msg);
			throw new FirebaseException(msg);
		}
		this.secureToken = secureToken;
		this.baseUrl = baseUrl.trim();
		query = new ArrayList<NameValuePair>();
		System.out.println("intialized with base-url: " + this.baseUrl);
	}

///////////////////////////////////////////////////////////////////////////////
//
// PUBLIC API
//
///////////////////////////////////////////////////////////////////////////////

	/**
	 * GETs data from the base-url.
	 *
	 * @return {@link FirebaseResponse}
	 * @throws FirebaseException            the firebase exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public FirebaseResponse get() throws FirebaseException, UnsupportedEncodingException {
		return this.get(null);
	}

	/**
	 * GETs data from the provided-path relative to the base-url.
	 *
	 * @param path -- if null/empty, refers to the base-url
	 * @return {@link FirebaseResponse}
	 * @throws FirebaseException            the firebase exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public FirebaseResponse get(String path) throws FirebaseException, UnsupportedEncodingException {

		// make the request
		String url = this.buildFullUrlFromRelativePath(path);
		HttpGet request = new HttpGet(url);
		HttpResponse httpResponse = this.makeRequest(request);

		// process the response
		FirebaseResponse response = this.processResponse(FirebaseRestMethod.GET, httpResponse);

		return response;
	}

	/**
	 * PATCHs data to the base-url.
	 *
	 * @param data -- can be null/empty
	 * @return the firebase response
	 * @throws FirebaseException            the firebase exception
	 * @throws Exception                    the exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */

	public FirebaseResponse patch(Map<String, Object> data)
			throws FirebaseException, Exception, UnsupportedEncodingException {
		return this.patch(null, data);
	}

	/**
	 * PATCHs data on the provided-path relative to the base-url.
	 *
	 * @param path -- if null/empty, refers to the base-url
	 * @param data -- can be null/empty
	 * @return {@link FirebaseResponse}
	 * @throws FirebaseException            the firebase exception
	 * @throws Exception                    the exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */

	public FirebaseResponse patch(String path, Map<String, Object> data)
			throws FirebaseException, Exception, UnsupportedEncodingException {
		// make the request
		String url = this.buildFullUrlFromRelativePath(path);
		// HttpPut request = new HttpPut( url );
		HttpPatch request = new HttpPatch(url);
		request.setEntity(this.buildEntityFromDataMap(data));
		HttpResponse httpResponse = this.makeRequest(request);

		// process the response
		FirebaseResponse response = this.processResponse(FirebaseRestMethod.PATCH, httpResponse);

		return response;
	}

	/**
	 * Patch.
	 *
	 * @param jsonData the json data
	 * @return the firebase response
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 * @throws FirebaseException            the firebase exception
	 */

	public FirebaseResponse patch(String jsonData) throws UnsupportedEncodingException, FirebaseException {
		return this.patch(null, jsonData);
	}

	/**
	 * Patch.
	 *
	 * @param path     the path
	 * @param jsonData the json data
	 * @return the firebase response
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 * @throws FirebaseException            the firebase exception
	 */

	public FirebaseResponse patch(String path, String jsonData) throws UnsupportedEncodingException, FirebaseException {
		// make the request
		String url = this.buildFullUrlFromRelativePath(path);
		HttpPatch request = new HttpPatch(url);
		request.setEntity(this.buildEntityFromJsonData(jsonData));
		HttpResponse httpResponse = this.makeRequest(request);

		// process the response
		FirebaseResponse response = this.processResponse(FirebaseRestMethod.PATCH, httpResponse);

		return response;
	}

	/**
	 * PUTs data to the base-url (ie: creates or overwrites). If there is already
	 * data at the base-url, this data overwrites it. If data is null/empty, any
	 * data existing at the base-url is deleted.
	 *
	 * @param data -- can be null/empty
	 * @return {@link FirebaseResponse}
	 * @throws Exception                    the exception
	 * @throws FirebaseException            the firebase exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public FirebaseResponse put(Map<String, Object> data)
			throws Exception, FirebaseException, UnsupportedEncodingException {
		return this.put(null, data);
	}

	/**
	 * PUTs data to the provided-path relative to the base-url (ie: creates or
	 * overwrites). If there is already data at the path, this data overwrites it.
	 * If data is null/empty, any data existing at the path is deleted.
	 *
	 * @param path -- if null/empty, refers to base-url
	 * @param data -- can be null/empty
	 * @return {@link FirebaseResponse}
	 * @throws Exception                    the exception
	 * @throws FirebaseException            the firebase exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public FirebaseResponse put(String path, Map<String, Object> data)
			throws Exception, FirebaseException, UnsupportedEncodingException {

		// make the request
		String url = this.buildFullUrlFromRelativePath(path);
		HttpPut request = new HttpPut(url);
		request.setEntity(this.buildEntityFromDataMap(data));
		HttpResponse httpResponse = this.makeRequest(request);

		// process the response
		FirebaseResponse response = this.processResponse(FirebaseRestMethod.PUT, httpResponse);

		return response;
	}

	/**
	 * PUTs data to the provided-path relative to the base-url (ie: creates or
	 * overwrites). If there is already data at the path, this data overwrites it.
	 * If data is null/empty, any data existing at the path is deleted.
	 *
	 * @param jsonData -- can be null/empty
	 * @return {@link FirebaseResponse}
	 * @throws FirebaseException            the firebase exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public FirebaseResponse put(String jsonData) throws FirebaseException, UnsupportedEncodingException {
		return this.put(null, jsonData);
	}

	/**
	 * PUTs data to the provided-path relative to the base-url (ie: creates or
	 * overwrites). If there is already data at the path, this data overwrites it.
	 * If data is null/empty, any data existing at the path is deleted.
	 *
	 * @param path     -- if null/empty, refers to base-url
	 * @param jsonData -- can be null/empty
	 * @return {@link FirebaseResponse}
	 * @throws FirebaseException            the firebase exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public FirebaseResponse put(String path, String jsonData) throws FirebaseException, UnsupportedEncodingException {

		// make the request
		String url = this.buildFullUrlFromRelativePath(path);
		HttpPut request = new HttpPut(url);
		request.setEntity(this.buildEntityFromJsonData(jsonData));
		HttpResponse httpResponse = this.makeRequest(request);

		// process the response
		FirebaseResponse response = this.processResponse(FirebaseRestMethod.PUT, httpResponse);

		return response;
	}

	/**
	 * POSTs data to the base-url (ie: creates).
	 * 
	 * NOTE: the Firebase API does not treat this method in the conventional way,
	 * but instead defines it as 'PUSH'; the API will insert this data under the
	 * base-url but associated with a Firebase- generated key; thus, every use of
	 * this method will result in a new insert even if the data already exists.
	 *
	 * @param data -- can be null/empty but will result in no data being POSTed
	 * @return {@link FirebaseResponse}
	 * @throws Exception                    the exception
	 * @throws FirebaseException            the firebase exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public FirebaseResponse post(Map<String, Object> data)
			throws Exception, FirebaseException, UnsupportedEncodingException {
		return this.post(null, data);
	}

	/**
	 * POSTs data to the provided-path relative to the base-url (ie: creates).
	 * 
	 * NOTE: the Firebase API does not treat this method in the conventional way,
	 * but instead defines it as 'PUSH'; the API will insert this data under the
	 * provided path but associated with a Firebase- generated key; thus, every use
	 * of this method will result in a new insert even if the provided path and data
	 * already exist.
	 *
	 * @param path -- if null/empty, refers to base-url
	 * @param data -- can be null/empty but will result in no data being POSTed
	 * @return {@link FirebaseResponse}
	 * @throws Exception                    the exception
	 * @throws FirebaseException            the firebase exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public FirebaseResponse post(String path, Map<String, Object> data)
			throws Exception, FirebaseException, UnsupportedEncodingException {

		// make the request
		String url = this.buildFullUrlFromRelativePath(path);
		HttpPost request = new HttpPost(url);
		request.setEntity(this.buildEntityFromDataMap(data));
		HttpResponse httpResponse = this.makeRequest(request);

		// process the response
		FirebaseResponse response = this.processResponse(FirebaseRestMethod.POST, httpResponse);

		return response;
	}

	/**
	 * POSTs data to the base-url (ie: creates).
	 * 
	 * NOTE: the Firebase API does not treat this method in the conventional way,
	 * but instead defines it as 'PUSH'; the API will insert this data under the
	 * base-url but associated with a Firebase- generated key; thus, every use of
	 * this method will result in a new insert even if the provided data already
	 * exists.
	 *
	 * @param jsonData -- can be null/empty but will result in no data being POSTed
	 * @return {@link FirebaseResponse}
	 * @throws FirebaseException            the firebase exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public FirebaseResponse post(String jsonData) throws FirebaseException, UnsupportedEncodingException {
		return this.post(null, jsonData);
	}

	/**
	 * POSTs data to the provided-path relative to the base-url (ie: creates).
	 * 
	 * NOTE: the Firebase API does not treat this method in the conventional way,
	 * but instead defines it as 'PUSH'; the API will insert this data under the
	 * provided path but associated with a Firebase- generated key; thus, every use
	 * of this method will result in a new insert even if the provided path and data
	 * already exist.
	 *
	 * @param path     -- if null/empty, refers to base-url
	 * @param jsonData -- can be null/empty but will result in no data being POSTed
	 * @return {@link FirebaseResponse}
	 * @throws FirebaseException            the firebase exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public FirebaseResponse post(String path, String jsonData) throws FirebaseException, UnsupportedEncodingException {

		// make the request
		String url = this.buildFullUrlFromRelativePath(path);
		HttpPost request = new HttpPost(url);
		request.setEntity(this.buildEntityFromJsonData(jsonData));
		HttpResponse httpResponse = this.makeRequest(request);

		// process the response
		FirebaseResponse response = this.processResponse(FirebaseRestMethod.POST, httpResponse);

		return response;
	}

	/**
	 * Append a query to the request.
	 * 
	 * @param query     -- Query string based on Firebase REST API
	 * @param parameter -- Query parameter
	 * @return Firebase -- return this Firebase object
	 */

	public Firebase addQuery(String query, String parameter) {
		this.query.add(new BasicNameValuePair(query, parameter));
		return this;
	}

	/**
	 * DELETEs data from the base-url.
	 *
	 * @return {@link FirebaseResponse}
	 * @throws FirebaseException            the firebase exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public FirebaseResponse delete() throws FirebaseException, UnsupportedEncodingException {
		return this.delete(null);
	}

	/**
	 * DELETEs data from the provided-path relative to the base-url.
	 *
	 * @param path -- if null/empty, refers to the base-url
	 * @return {@link FirebaseResponse}
	 * @throws FirebaseException            the firebase exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public FirebaseResponse delete(String path) throws FirebaseException, UnsupportedEncodingException {

		// make the request
		String url = this.buildFullUrlFromRelativePath(path);
		HttpDelete request = new HttpDelete(url);
		HttpResponse httpResponse = this.makeRequest(request);

		// process the response
		FirebaseResponse response = this.processResponse(FirebaseRestMethod.DELETE, httpResponse);

		return response;
	}

///////////////////////////////////////////////////////////////////////////////
//
// PRIVATE API
//
///////////////////////////////////////////////////////////////////////////////

	/**
	 * Builds the entity from data map.
	 *
	 * @param dataMap the data map
	 * @return the string entity
	 * @throws FirebaseException the firebase exception
	 * @throws Exception         the exception
	 */
	private StringEntity buildEntityFromDataMap(Map<String, Object> dataMap) throws FirebaseException, Exception {

		String jsonData = JacksonUtility.GET_JSON_STRING_FROM_MAP(dataMap);

		return this.buildEntityFromJsonData(jsonData);
	}

	/**
	 * Builds the entity from json data.
	 *
	 * @param jsonData the json data
	 * @return the string entity
	 * @throws FirebaseException the firebase exception
	 */
	private StringEntity buildEntityFromJsonData(String jsonData) throws FirebaseException {

		StringEntity result = null;
		try {

			result = new StringEntity(jsonData);

		} catch (Throwable t) {

			String msg = "unable to create entity from data; data was: " + jsonData;
			System.err.println(msg);
			throw new FirebaseException(msg, t);

		}

		return result;
	}

	/**
	 * Builds the full url from relative path.
	 *
	 * @param path the path
	 * @return the string
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	private String buildFullUrlFromRelativePath(String path) throws UnsupportedEncodingException {

		// massage the path (whether it's null, empty, or not) into a full URL
		if (path == null) {
			path = "";
		}
		path = path.trim();
		if (!path.isEmpty() && !path.startsWith("/")) {
			path = "/" + path;
		}
		String url = this.baseUrl + path + Firebase.FIREBASE_API_JSON_EXTENSION;

		if (query != null) {
			url += "?";
			Iterator<NameValuePair> it = query.iterator();
			NameValuePair e;
			while (it.hasNext()) {
				e = it.next();
				url += e.getName() + "=" + URLEncoder.encode(e.getValue(), "UTF-8") + "&";
			}
		}

		if (secureToken != null) {
			if (query != null) {
				url += "auth=" + secureToken;
			} else {
				url += "?auth=" + secureToken;
			}
		}

		if (url.lastIndexOf("&") == url.length()) {
			StringBuilder str = new StringBuilder(url);
			str.deleteCharAt(str.length());
			url = str.toString();
		}

		System.out.println("built full url to '" + url + "' using relative-path of '" + path + "'");

		return url;
	}

	/**
	 * Make request.
	 *
	 * @param request the request
	 * @return the http response
	 * @throws FirebaseException the firebase exception
	 */
	private HttpResponse makeRequest(HttpRequestBase request) throws FirebaseException {

		HttpResponse response = null;

		// sanity-check
		if (request == null) {

			String msg = "request cannot be null";
			System.err.println(msg);
			throw new FirebaseException(msg);
		}

		try {

			HttpClient client = new DefaultHttpClient();
			response = client.execute(request);

		} catch (Throwable t) {

			String msg = "unable to receive response from request(" + request.getMethod() + ") @ " + request.getURI();
			System.err.println(msg);
			throw new FirebaseException(msg, t);

		}

		return response;
	}

	/**
	 * Process response.
	 *
	 * @param method       the method
	 * @param httpResponse the http response
	 * @return the firebase response
	 * @throws FirebaseException the firebase exception
	 */
	private FirebaseResponse processResponse(FirebaseRestMethod method, HttpResponse httpResponse)
			throws FirebaseException {

		FirebaseResponse response = null;

		// sanity-checks
		if (method == null) {

			String msg = "method cannot be null";
			System.err.println(msg);
			throw new FirebaseException(msg);
		}
		if (httpResponse == null) {

			String msg = "httpResponse cannot be null";
			System.err.println(msg);
			throw new FirebaseException(msg);
		}

		// get the response-entity
		HttpEntity entity = httpResponse.getEntity();

		// get the response-code
		int code = httpResponse.getStatusLine().getStatusCode();

		// set the response-success
		boolean success = false;
		switch (method) {
		case DELETE:
			if (httpResponse.getStatusLine().getStatusCode() == 204
					&& "No Content".equalsIgnoreCase(httpResponse.getStatusLine().getReasonPhrase())) {
				success = true;
			}
			break;
		case PATCH:
		case PUT:
		case POST:
		case GET:
			if (httpResponse.getStatusLine().getStatusCode() == 200
					&& "OK".equalsIgnoreCase(httpResponse.getStatusLine().getReasonPhrase())) {
				success = true;
			}
			break;
		default:
			break;

		}

		// get the response-body
		Writer writer = new StringWriter();
		if (entity != null) {

			try {

				InputStream is = entity.getContent();
				char[] buffer = new char[1024];
				Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}

			} catch (Throwable t) {

				String msg = "unable to read response-content; read up to this point: '" + writer.toString() + "'";
				writer = new StringWriter(); // don't want to later give jackson partial JSON it might choke on
				System.err.println(msg);
				throw new FirebaseException(msg, t);

			}
		}

		// convert response-body to map
		Map<String, Object> body = null;
		try {

			body = JacksonUtility.GET_JSON_STRING_AS_MAP(writer.toString());

		} catch (Exception jue) {

			String msg = "unable to convert response-body into map; response-body was: '" + writer.toString() + "'";
			System.err.println(msg);
			throw new FirebaseException(msg, jue);
		}

		// build the response
		response = new FirebaseResponse(success, code, body, writer.toString());

		// clear the query
		query = null;

		return response;
	}

///////////////////////////////////////////////////////////////////////////////
//
// INTERNAL CLASSES
//
///////////////////////////////////////////////////////////////////////////////

	/**
	 * The Enum FirebaseRestMethod.
	 */
	public enum FirebaseRestMethod {

		/** The get. */
		GET,
		/** The patch. */
		PATCH,
		/** The put. */
		PUT,
		/** The post. */
		POST,
		/** The delete. */
		DELETE;
	}
}