/**
 * 
 */
package cn.zhucongqi.oauth2.request;

import javax.servlet.http.HttpServletRequest;

import cn.zhucongqi.oauth2.base.clientcredentials.OAuthClientCredentials;
import cn.zhucongqi.oauth2.base.validator.OAuthValidator;
import cn.zhucongqi.oauth2.exception.OAuthProblemException;
import cn.zhucongqi.oauth2.validators.AccessTokenRequestValidator;
import cn.zhucongqi.oauth2.validators.AuthorizationRequestValidator;
import cn.zhucongqi.oauth2.validators.ClientCredentialValidator;
import cn.zhucongqi.oauth2.validators.ImplicitValidator;
import cn.zhucongqi.oauth2.validators.PasswordCredentialValidator;
import cn.zhucongqi.oauth2.validators.RefreshTokenValidator;

/**
 * @author Jobsz
 */
public class OAuthRequest {

	private HttpServletRequest request = null;
	private OAuthValidator validator = null;
	
	/**
	 * init oauth request using AccessTokenRequestValidator
	 * @param request
	 */
	private OAuthRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public static OAuthRequest authorizatonRequest(HttpServletRequest request, OAuthClientCredentials clientCredential) {
		OAuthRequest oauthRequest = new OAuthRequest(request);
		OAuthValidator validator = new AuthorizationRequestValidator(request);
		validator.setClientCredentials(clientCredential);
		oauthRequest.validator = validator;
		return oauthRequest;
	}
	
	
	public static OAuthRequest accessTokenRequest(HttpServletRequest request, OAuthClientCredentials clientCredential) {
		OAuthRequest oauthRequest = new OAuthRequest(request);
		OAuthValidator validator = new AccessTokenRequestValidator(request);
		validator.setClientCredentials(clientCredential);
		oauthRequest.validator = validator;
		return oauthRequest;
	}
	
	public static OAuthRequest clientCredentialRequest(HttpServletRequest request, OAuthClientCredentials clientCredential) {
		OAuthRequest oauthRequest = new OAuthRequest(request);
		OAuthValidator validator = new ClientCredentialValidator(request);
		validator.setClientCredentials(clientCredential);
		oauthRequest.validator = validator;
		return oauthRequest;
	}
	
	public static OAuthRequest implicitRequest(HttpServletRequest request, OAuthClientCredentials clientCredential) {
		OAuthRequest oauthRequest = new OAuthRequest(request);
		OAuthValidator validator = new ImplicitValidator(request);
		validator.setClientCredentials(clientCredential);
		oauthRequest.validator = validator;
		return oauthRequest;
	}
	
	public static OAuthRequest passwordCredentialRequest(HttpServletRequest request, OAuthClientCredentials clientCredential) {
		OAuthRequest oauthRequest = new OAuthRequest(request);
		OAuthValidator validator = new PasswordCredentialValidator(request);
		validator.setClientCredentials(clientCredential);
		oauthRequest.validator = validator;
		return oauthRequest;
	}
	
	public static OAuthRequest refreshTokenRequest(HttpServletRequest request, OAuthClientCredentials clientCredential) {
		OAuthRequest oauthRequest = new OAuthRequest(request);
		OAuthValidator validator = new RefreshTokenValidator(request);
		validator.setClientCredentials(clientCredential);
		oauthRequest.validator = validator;
		return oauthRequest;
	}
	
	/**
	 * Get current request's validator
	 * @return
	 */
	public OAuthValidator getValidator() {
		return this.validator;
	}

	/**
	 * Get current request
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return this.request;
	}
	
	 /**
     * validate request
     * 
     * @throws OAuthProblemException
     */
    public Object validate() throws OAuthProblemException {
    	return this.validator.validate();
    }
}
