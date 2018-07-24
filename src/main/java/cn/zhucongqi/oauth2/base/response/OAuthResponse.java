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
package cn.zhucongqi.oauth2.base.response;

import java.io.Serializable;
import java.util.HashMap;

import cn.zhucongqi.oauth2.base.validator.OAuthValidator;
import cn.zhucongqi.oauth2.consts.OAuthConsts;
import cn.zhucongqi.oauth2.consts.OAuthError;
import cn.zhucongqi.oauth2.issuer.OAuthIssuer;
import cn.zhucongqi.oauth2.issuer.OAuthIssuerKit;
import cn.zhucongqi.oauth2.kit.StrKit;

/**
 * @author Jobsz [zcq@zhucongqi.cn]
 * @version
 */
public abstract class OAuthResponse implements OAuthIssuer, Serializable {
	
	private static final long serialVersionUID = 3592197949369821211L;
	
	protected OAuthIssuerKit issuer = null;
	private HashMap<String, String> map = null;
	
	protected abstract void init();
	
	public OAuthResponse() {
		
	}
	
	public OAuthResponse(OAuthValidator validator) {
		this.issuer = OAuthIssuerKit.issuer();
		this.init(validator);
	}
	
	public OAuthResponse(OAuthValidator validator, OAuthIssuerKit issuer) {
		this.issuer = issuer;
		this.init(validator);
	}
	
	private void init(OAuthValidator validator) {
		this.map = new HashMap<String, String>();
		String state = validator.getState();
		if (StrKit.notBlank(state)) {
			this.setState(state);
		}
		
		String scope = validator.getScope();
		if (StrKit.notBlank(scope)) {
			this.setScope(scope);
		}
		this.init();
	}
	
	protected void put(String key, String value) {
		this.map.put(key, value);
	}
	
	protected String get(String key) {
		return this.map.get(key);
	}
	
	private void setState(String state) {
		this.put(OAuthConsts.OAuth.OAUTH_STATE, state);
	}
	
	public String getState() {
		return this.get(OAuthConsts.OAuth.OAUTH_STATE);
	}
	
	private void setScope(String scope) {
		this.put(OAuthConsts.OAuth.OAUTH_SCOPE, scope);
	}
	
	public String getScope() {
		return this.get(OAuthConsts.OAuth.OAUTH_SCOPE);
	}
	
	/**
	 * request is success or not
	 * @return
	 */
	public boolean successed() {
		return this.map.containsKey(OAuthError.OAUTH_ERROR);
	}
	
	/**
	 * Put other extension parameter into the parameters
	 * @param parameter
	 * @param value
	 */
	public void putExtenstionParameter(String parameter, String value) {
		this.put(parameter, value);
	}
	
	@Override
	public String accessToken() {
		return this.issuer.accessToken();
	}

	@Override
	public String authorizationCode() {
		return this.issuer.authorizationCode();
	}

	@Override
	public String refreshToken() {
		return this.issuer.refreshToken();
	}
}
