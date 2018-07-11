/**
 * 
 */
package cn.zhucongqi.oauth2.kit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.zhucongqi.oauth2.request.OAuthHttpServletRequest;

/**
 * @author Jobsz
 *
 */
public final class OAuthRequestKit {

	public static OAuthHttpServletRequest cp(HttpServletRequest r) {
		OAuthHttpServletRequest or = new OAuthHttpServletRequest();
		or.setContentType(r.getContentType());
		or.setMethod(r.getMethod());
		
		List<String> parameters = or.getParameters();
		for (String key : parameters) {
			String value = r.getParameter(key);
			if (StrKit.notBlank(value)) {
				or.setParameter(key, value);
			}
		}
		return or;
	}
	
}
