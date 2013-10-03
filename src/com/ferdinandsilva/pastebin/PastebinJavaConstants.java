package com.ferdinandsilva.pastebin;

public class PastebinJavaConstants {

	public static final String PASTEBIN_URL = "http://pastebin.com/";
	public static final String PASTEBIN_RAW_URL = PASTEBIN_URL + "raw.php?i=";
	public static final String PASTEBIN_API_URL = PASTEBIN_URL + "api/";
	public static final String PASTEBIN_API_POST_URL = PASTEBIN_API_URL + "api_post.php";
	public static final String PASTEBIN_API_LOGIN_URL = PASTEBIN_API_URL + "api_login.php";
	
	public static final String PASTE_PUBLIC = "0";
	public static final String PASTE_UNLISTED = "1";
	public static final String PASTE_PRIVATE = "2";
	
	public static final String EXPIRE_NEVER = "N";
	public static final String EXPIRE_10_MIN = "10M";
	public static final String EXPIRE_1_HOUR = "1H";
	public static final String EXPIRE_1_DAY = "1D";
	public static final String EXPIRE_1_MONTH = "1M";
	
	public static final String DEFAULT_RESULTS_LIMIT = "50";
	
}
