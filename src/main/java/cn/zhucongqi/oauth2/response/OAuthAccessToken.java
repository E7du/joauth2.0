/*
 * Copyright 2018 Jobsz(zhucongqi.cn)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
*/
package cn.zhucongqi.oauth2.response;

import cn.zhucongqi.oauth2.base.response.OAuthResponse;
import cn.zhucongqi.oauth2.base.validator.OAuthValidator;
import cn.zhucongqi.oauth2.consts.Consts;
import cn.zhucongqi.oauth2.consts.OAuthConsts;
import cn.zhucongqi.oauth2.issuer.OAuthIssuerKit;


/**
 * access_token : The access token issued by the authorization server. <br/>
 * expires_in : The lifetime in seconds of the access token. <br/>
 * refresh_token : he refresh token, which can be used to obtain new
         access tokens using the same authorization grant. <br/>
 * scope : The scope of the access request; <br/>
 * state : The exact value received from the
         client. <br/>
         
 * @author Jobsz [zcq@zhucongqi.cn]
 * @version
 */
public class OAuthAccessToken extends OAuthResponse {
	
	@Override
	protected void init() {
		this.setAccessToken(this.issuer.accessToken());
		this.setRefreshToken(this.issuer.refreshToken());
		this.setExpiresIn(Consts.TOKEN_EXPIRES_IN);//default value
	}
	
	public OAuthAccessToken(OAuthValidator validator) {
		super(validator);
	}
	
	public OAuthAccessToken(OAuthValidator validator, OAuthIssuerKit issuer) {
		super(validator);
		this.issuer = issuer;
	}
	
	/**
	 * Set Access　Token
	 * @param accessToken
	 */
	private OAuthAccessToken setAccessToken(String accessToken) {
		this.putParameter(OAuthConsts.OAuth.OAUTH_ACCESS_TOKEN, accessToken);
		return this;
	}
	
	/**
	 * Get AccessToken
	 * @return
	 */
	public String getAccessToken() {
		return this.getParamter(OAuthConsts.OAuth.OAUTH_ACCESS_TOKEN);
	}
	
	/**
	 * Set Refresh Token
	 * @param refreshToken
	 */
	private OAuthAccessToken setRefreshToken(String refreshToken) {
		this.putParameter(OAuthConsts.OAuth.OAUTH_REFRESH_TOKEN, refreshToken);
		return this;
	}
	
	/**
	 * Get RefreshToken
	 * @return
	 */
	public String getRefreshToken() {
		return this.getParamter(OAuthConsts.OAuth.OAUTH_REFRESH_TOKEN);
	}
	
	/**
	 * Set Expires In
	 * @param expiresIn
	 */
	private OAuthAccessToken setExpiresIn(String expiresIn) {
		this.putParameter(OAuthConsts.OAuth.OAUTH_EXPIRES_IN, expiresIn);
		return this;
	}
	
	/**
	 * Get Token ExpriresIn
	 * @return
	 */
	public String getExpriresIn() {
		return this.getParamter(OAuthConsts.OAuth.OAUTH_EXPIRES_IN);
	}
	
}
