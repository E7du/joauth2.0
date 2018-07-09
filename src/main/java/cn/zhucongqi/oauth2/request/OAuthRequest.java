/**
 * 
 */
package cn.zhucongqi.oauth2.request;

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

	private OAuthHttpServletRequest request = null;
	private OAuthValidator validator = null;
	
	/**
	 * init oauth request using AccessTokenRequestValidator
	 * @param request
	 */
	private OAuthRequest(OAuthHttpServletRequest request) {
		this.request = request;
	}
	
	/**
	 * authorization request
	 * @param request
	 * @param clientCredential
	 * @return
	 */
	public static OAuthRequest authorizatonRequest(OAuthHttpServletRequest request, OAuthClientCredentials clientCredential) {
		OAuthRequest oauthRequest = new OAuthRequest(request);
		OAuthValidator validator = new AuthorizationRequestValidator(request);
		validator.setClientCredentials(clientCredential);
		oauthRequest.validator = validator;
		return oauthRequest;
	}
	
	/**
	 * accessToken request
	 * @param request
	 * @param clientCredential
	 * @return
	 */
	public static OAuthRequest accessTokenRequest(OAuthHttpServletRequest request, OAuthClientCredentials clientCredential) {
		OAuthRequest oauthRequest = new OAuthRequest(request);
		OAuthValidator validator = new AccessTokenRequestValidator(request);
		validator.setClientCredentials(clientCredential);
		oauthRequest.validator = validator;
		return oauthRequest;
	}
	
	/**
	 * client credential request
	 * @param request
	 * @param clientCredential
	 * @return
	 */
	public static OAuthRequest clientCredentialRequest(OAuthHttpServletRequest request, OAuthClientCredentials clientCredential) {
		OAuthRequest oauthRequest = new OAuthRequest(request);
		OAuthValidator validator = new ClientCredentialValidator(request);
		validator.setClientCredentials(clientCredential);
		oauthRequest.validator = validator;
		return oauthRequest;
	}
	
	/**
	 * implicit request
	 * @param request
	 * @param clientCredential
	 * @return
	 */
	public static OAuthRequest implicitRequest(OAuthHttpServletRequest request, OAuthClientCredentials clientCredential) {
		OAuthRequest oauthRequest = new OAuthRequest(request);
		OAuthValidator validator = new ImplicitValidator(request);
		validator.setClientCredentials(clientCredential);
		oauthRequest.validator = validator;
		return oauthRequest;
	}
	
	/**
	 * password credential / secure accessToken request
	 * @param request
	 * @param clientCredential
	 * @return
	 */
	public static OAuthRequest passwordCredentialRequest(OAuthHttpServletRequest request, OAuthClientCredentials clientCredential) {
		OAuthRequest oauthRequest = new OAuthRequest(request);
		OAuthValidator validator = new PasswordCredentialValidator(request);
		validator.setClientCredentials(clientCredential);
		oauthRequest.validator = validator;
		return oauthRequest;
	}
	
	/**
	 * refresh token request
	 * @param request
	 * @param clientCredential
	 * @return
	 */
	public static OAuthRequest refreshTokenRequest(OAuthHttpServletRequest request, OAuthClientCredentials clientCredential) {
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
	public OAuthHttpServletRequest getRequest() {
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
