/**
 * 
 */
package cn.zhucongqi.oauth2.base.services;

import cn.zhucongqi.oauth2.request.OAuthHttpServletRequest;

/**
 * @author Jobsz
 *
 */
public interface OAuthApi {
	
	/**
	 * Authorization  Code Request <br/>
	 * response_type : code <br/>
	 * client_id : The client identifier; <br/>
	 * scope : The scope of the access request; <br/>
	 * state : An opaque value used by the client to maintain
         state between the request and callback.The authorization
         server includes this value when redirecting the user-agent back
         to the client. <br/>
     * Success => <br/>
     * code : The authorization code generated by the
         authorization server.  The authorization code MUST expire
         shortly after it is issued to mitigate the risk of leaks.  A
         maximum authorization code lifetime of 10 minutes is
         RECOMMENDED.
     * state : The exact value received from the
         client.
     * Failure => <br/>
     * error : ErrorConsts.TokenResponse <br/>
     * error_description : the erros repsonse description <br/>
     * state : The exact value received from the client.
	 */
	public Object authrize(OAuthHttpServletRequest request);
	
	public Object authrizeCode(OAuthHttpServletRequest request);
	
	/**
	 * Access Token Request <br/>
	 * 
	 * response_type : token <br/>
	 * grant_type : accessToken <br/>
	 * code : The authorization code received from the
         authorization server. <br/>
     * client_id : The client identifier; <br/>
     * username : The resource owner username. <br/>
     * password : The resource owner password. <br/>
	 * scope : The scope of the access request; <br/>
     * state : An opaque value used by the client to maintain
         state between the request and callback.The authorization
         server includes this value when redirecting the user-agent back
         to the client. <br/>
     * Success => <br/> 
     * access_token : The access token issued by the authorization server. <br/>
     * expires_in : The lifetime in seconds of the access token. <br/>
     * refresh_token : he refresh token, which can be used to obtain new
         access tokens using the same authorization grant. <br/>
     * scope : The scope of the access request; <br/>
     * state : The exact value received from the
         client. <br/>
    For example:

     HTTP/1.1 200 OK
     Content-Type: application/json;charset=UTF-8
     Cache-Control: no-store
     Pragma: no-cache

     {
       "access_token":"2YotnFZFEjr1zCsicMWpAA",
       "expires_in":3600,
       "refresh_token":"tGzv3JOkF0XG5Qx2TlKWIA",
       "scope":"user",
       "state":"xyz"
     }
     * Failure => <br/>
     * error : ErrorConsts.TokenResponse <br/>
     * error_description : the erros repsonse description <br/>
     * state : The exact value received from the
         client.
	 */
	public Object accessToken(OAuthHttpServletRequest request);
	
	public Object secureAccessToken(OAuthHttpServletRequest request);
	
	/**
	 * Refreshing an Access Token <br/>
	 * 	 
	 * response_type : token <br/>
	 * grant_type : refresh_token <br/>
	 * refresh_token : The refresh token issued to the client. <br/>
	 * scope : The scope of the access request; <br/>    
	 * state : An opaque value used by the client to maintain
         state between the request and callback.The authorization
         server includes this value when redirecting the user-agent back
         to the client. <br/>
	 * Success => <br/>
	 * access_token : The access token issued by the authorization server. <br/>
     * expires_in : The lifetime in seconds of the access token. <br/>
     * refresh_token : he refresh token, which can be used to obtain new
         access tokens using the same authorization grant. <br/>
     * scope : The scope of the access request; <br/>
     * state : The exact value received from the
         client. <br/>
	 * Failure => <br/>
     * error : ErrorConsts.CodeResponse <br/>
     * error_description : the erros repsonse description <br/>
	 * scope : The scope of the access request; <br/>  
     * state : The exact value received from the
         client.
	 */
	public Object refreshToken(OAuthHttpServletRequest request);
		
}
