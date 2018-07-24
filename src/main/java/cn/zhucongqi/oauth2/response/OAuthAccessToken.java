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
@SuppressWarnings({ "unchecked"})
public class OAuthAccessToken extends OAuthResponse {

	private static final long serialVersionUID = 4185034057888277981L;
	
	@Override
	protected void init() {
		this.put(OAuthConsts.OAuth.OAUTH_ACCESS_TOKEN, this.accessToken());
		this.put(OAuthConsts.OAuth.OAUTH_REFRESH_TOKEN, this.refreshToken());
		this.setExpriresIn(Consts.TOKEN_EXPIRES_IN);
	}
	
	public OAuthAccessToken() {
		
	}

	public OAuthAccessToken(OAuthValidator validator) {
		super(validator);
	}
	
	public OAuthAccessToken(OAuthValidator validator, OAuthIssuerKit issuer) {
		super(validator, issuer);
	}
	
	/**
	 * Get AccessToken
	 * @return
	 */
	public String getAccessToken() {
		return (String) this.get(OAuthConsts.OAuth.OAUTH_ACCESS_TOKEN);
	}
	
	/**
	 * Get RefreshToken
	 * @return
	 */
	public String getRefreshToken() {
		return (String) this.get(OAuthConsts.OAuth.OAUTH_REFRESH_TOKEN);
	}
	
	/**
	 * Set Token ExpriresIn
	 */
	public void setExpriresIn(String ExpriresIn) {
		this.put(OAuthConsts.OAuth.OAUTH_EXPIRES_IN, ExpriresIn);
	}
	
	/**
	 * Get Token ExpriresIn
	 * @return
	 */
	public String getExpriresIn() {
		return (String) this.get(OAuthConsts.OAuth.OAUTH_EXPIRES_IN);
	}
}
