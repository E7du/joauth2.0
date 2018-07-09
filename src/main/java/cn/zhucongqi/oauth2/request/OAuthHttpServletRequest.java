/**
 * 
 */
package cn.zhucongqi.oauth2.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.zhucongqi.oauth2.consts.OAuthConsts;

/**
 * OAuthHttpServletRequest.java
 * @author Jobsz
 *
 */
public class OAuthHttpServletRequest implements Serializable {

	private static final long serialVersionUID = -4432512843521321200L;
	
	private String contentType = null;
	private String method = null;
	private List<String> parameters = new ArrayList<String>();
	private HashMap<String, String> parametersValues = new HashMap<String, String>();
	
	public OAuthHttpServletRequest() {
		this.parameters.add(OAuthConsts.OAuth.OAUTH_GRANT_TYPE);
		this.parameters.add(OAuthConsts.OAuth.OAUTH_AUTHORIZATION_CODE);
		this.parameters.add(OAuthConsts.OAuth.OAUTH_REDIRECT_URI);
		this.parameters.add(OAuthConsts.OAuth.OAUTH_RESPONSE_TYPE);
		this.parameters.add(OAuthConsts.OAuth.OAUTH_CLIENT_ID);
		this.parameters.add(OAuthConsts.OAuth.OAUTH_USERNAME);
		this.parameters.add(OAuthConsts.OAuth.OAUTH_PASSWORD);
	    this.parameters.add(OAuthConsts.OAuth.OAUTH_REFRESH_TOKEN);
	    this.parameters.add(OAuthConsts.OAuth.OAUTH_SCOPE);
	    this.parameters.add(OAuthConsts.OAuth.OAUTH_STATE);
	}
	
	public List<String> getParameters() {
		return this.parameters;
	}
	
	public void setParameter(String key, String value) {
		this.parametersValues.put(key, value);
	}

	public String getParameter(String key) {
		return this.parametersValues.get(key);
	}
	
	public String getContentType() {
		return contentType;
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}

}
