package com.ferdinandsilva.pastebin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.ferdinandsilva.pastebin.PastebinJavaConstants;
import com.ferdinandsilva.pastebin.PastebinJavaFormats;
import com.ferdinandsilva.pastebin.PastebinJavaOptions;

public class PastebinJava {
	
	public String api_dev_key = "";
	private String api_user_key = "";
	private List<String> api_user_paste_list = new ArrayList<String>();
	
	public PastebinJava() {
		
	}
	
	public PastebinJava(String api_dev_key) {
		this.api_dev_key = api_dev_key;
	}
	
	public String get_api_user_key() {
		return this.api_user_key;
	}

	public List<String> get_api_user_paste_list() {
		return this.api_user_paste_list;
	}
	
	public String createPaste(String api_paste_code) {
		
		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("api_option", PastebinJavaOptions.OPTION_PASTE);
		postData.put("api_paste_code", api_paste_code);
		return this.processPost(PastebinJavaConstants.PASTEBIN_API_POST_URL, postData);
	}
	
	public String createPaste(String api_paste_code, String api_paste_name) {
		
		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("api_option", PastebinJavaOptions.OPTION_PASTE);
		postData.put("api_paste_code", api_paste_code);
		postData.put("api_paste_name", api_paste_name);
		return this.processPost(PastebinJavaConstants.PASTEBIN_API_POST_URL, postData);
	}
	
	public String createPaste(String api_paste_code, String api_paste_name, String api_paste_format) {
		
		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("api_option", PastebinJavaOptions.OPTION_PASTE);
		postData.put("api_paste_code", api_paste_code);
		postData.put("api_paste_name", api_paste_name);
		postData.put("api_paste_format", api_paste_format);
		return this.processPost(PastebinJavaConstants.PASTEBIN_API_POST_URL, postData);
	}
	
	public String createPaste(String api_paste_code, String api_paste_name, String api_paste_format, String api_paste_private) {
		
		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("api_option", PastebinJavaOptions.OPTION_PASTE);
		postData.put("api_paste_code", api_paste_code);
		postData.put("api_paste_name", api_paste_name);
		postData.put("api_paste_format", api_paste_format);
		postData.put("api_paste_private", api_paste_private);
		return this.processPost(PastebinJavaConstants.PASTEBIN_API_POST_URL, postData);
	}
	
	public String createPaste(String api_paste_code, String api_paste_name, String api_paste_format, String api_paste_private, String api_paste_expire_date) {
		
		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("api_option", PastebinJavaOptions.OPTION_PASTE);
		postData.put("api_paste_code", api_paste_code);
		postData.put("api_paste_name", api_paste_name);
		postData.put("api_paste_format", api_paste_format);
		postData.put("api_paste_private", api_paste_private);
		postData.put("api_paste_expire_date", api_paste_expire_date);
		return this.processPost(PastebinJavaConstants.PASTEBIN_API_POST_URL, postData);
	}
	
	
	private String processPost(String postURL, HashMap<String, String> postData) {
		
		String ret = "";
	
		postData.put("api_dev_key", this.api_dev_key);
		
		Iterator<String> iterator = postData.keySet().iterator();
		
		try {
			URL url = new URL(postURL);
			URLConnection urlConnection  = url.openConnection();
			urlConnection.setDoOutput(true);
			
			//urlConnection.connect();
			
			OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
	
			while(iterator.hasNext()) {
				String key = iterator.next();
				writer.write("&" + key + "=" + URLEncoder.encode(postData.get(key), "UTF-8"));
			}
			
			
			writer.close();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String ln = reader.readLine();
			
			while(ln != null) {
				builder.append(ln + "\n");
				ln = reader.readLine();
			}
			
			reader.close();
			ret = builder.toString();
			
			
			
		} catch (MalformedURLException e) {
			
		} catch(IOException e) {
			
		}
		
		return ret;
	}
	
	public String createAPIUserKey(String api_user_name, String api_user_password) {
	
		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("api_user_name", api_user_name);
		postData.put("api_user_password", api_user_password);

		this.api_user_key = this.processPost(PastebinJavaConstants.PASTEBIN_API_LOGIN_URL, postData);
		this.api_user_paste_list = new ArrayList<String>();
		return this.api_user_key;
	}
	
	
	public static void main(String[] args) {
		//testing

		PastebinJava pbin = new PastebinJava("f4dfe115d610ebddc278115d9f80752d");
		String tstString = pbin.createPaste("print \"testing\";", "testing", PastebinJavaFormats.FORMAT_PYTHON, PastebinJavaConstants.PASTE_PUBLIC, PastebinJavaConstants.EXPIRE_10_MIN);
		System.out.println(tstString);

	}
}
