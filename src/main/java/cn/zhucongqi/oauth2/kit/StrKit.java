package cn.zhucongqi.oauth2.kit;

public class StrKit {
	
	public static boolean isBlank(String str) {
		if (str == null) {
			return true;
		}
		int len = str.length();
		if (len == 0) {
			return true;
		}
		for (int i = 0; i < len; i++) {
			switch (str.charAt(i)) {
			case ' ':
			case '\t':
			case '\n':
			case '\r':
			// case '\b':
			// case '\f':
				break;
			default:
				return false;
			}
		}
		return true;
	}
	
	public static boolean notBlank(String str) {
		return !isBlank(str);
	}
	
	public static boolean notBlank(String... strings) {
		if (strings == null || strings.length == 0) {
			return false;
		}
		for (String str : strings) {
			if (isBlank(str)) {
				return false;
			}
		}
		return true;
	}
}




