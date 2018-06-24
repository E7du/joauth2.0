/**
 * 
 */
package cn.zhucongqi.oauth2.request;

import javax.servlet.http.HttpServletRequest;

import cn.zhucongqi.oauth2.base.clientcredentials.OAuthClientCredentials;
import cn.zhucongqi.oauth2.base.validator.OAuthValidator;
import cn.zhucongqi.oauth2.consts.OAuthRequestConsts;
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
	public OAuthRequest(HttpServletRequest request) {
		this.request = request;
		this.validator = new AccessTokenRequestValidator(request);
	}
	
	/**
	 * init oauth request
	 * @param request
	 * @param reqType: current request type {@link OAuthRequestConsts}
	 */
	public OAuthRequest(HttpServletRequest request, int reqType, OAuthClientCredentials clientCredential) {
		
		switch (reqType) {
		case OAuthRequestConsts.AUTHORIZATION_REQUEST: {
			this.validator = new AuthorizationRequestValidator(request);
		}
			break;

		case OAuthRequestConsts.ACCESS_TOKEN_REQUEST: {
			this.validator = new AccessTokenRequestValidator(request);
		}
			break;
		case OAuthRequestConsts.CLIENT_CREDENTIAL_REQUEST: {
			this.validator = new ClientCredentialValidator(request);
		}
			break;
		case OAuthRequestConsts.IMPLICIT_REQUEST: {
			this.validator = new ImplicitValidator(request);
		}
			break;
		case OAuthRequestConsts.PASSOWRD_CREDENTIAL_REQUEST: {
			this.validator = new PasswordCredentialValidator(request);
		}
			break;
		case OAuthRequestConsts.REFRESH_TOKEN_REQUEST: {
			this.validator = new RefreshTokenValidator(request);
		}
			break;
		}
		
		this.validator.setClientCredentials(clientCredential);
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
