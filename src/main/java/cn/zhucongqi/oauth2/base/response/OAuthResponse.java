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

import java.util.HashMap;

import cn.zhucongqi.oauth2.base.validator.OAuthValidator;
import cn.zhucongqi.oauth2.consts.OAuthConsts;
import cn.zhucongqi.oauth2.issuer.OAuthIssuerKit;
import cn.zhucongqi.oauth2.kit.StrKit;

/**
 * @author Jobsz [zcq@zhucongqi.cn]
 * @version
 */
public abstract class OAuthResponse {
	
	protected HashMap<String, String> parameters = null;
	protected OAuthIssuerKit issuer = null;
	
	public OAuthResponse(OAuthValidator validator) {
		this.parameters = new HashMap<String, String>();
		this.issuer = OAuthIssuerKit.issuer();
		this.init();
		String state = validator.getState();
		if (StrKit.notBlank(state)) {
			this.setState(state);
		}
		
		String scope = validator.getScope();
		if (StrKit.notBlank(scope)) {
			this.setScope(scope);
		}
	}
	
	protected abstract void init();
	
	protected void putParameter(String parameter, String value) {
		this.parameters.put(parameter, value);
	}
	
	protected String getParamter(String parameter) {
		return this.parameters.get(parameter);
	}
	
	private void setState(String state) {
		this.putParameter(OAuthConsts.OAuth.OAUTH_STATE, state);
	}
	
	public String getState() {
		return this.getParamter(OAuthConsts.OAuth.OAUTH_STATE);
	}
	
	private void setScope(String scope) {
		this.putParameter(OAuthConsts.OAuth.OAUTH_SCOPE, scope);
	}
	
	public String getScope() {
		return this.getParamter(OAuthConsts.OAuth.OAUTH_SCOPE);
	}
	
	/**
	 * Put other extension parameter into the parameters
	 * @param parameter
	 * @param value
	 */
	public void putExtenstionParameter(String parameter, String value) {
		this.putParameter(parameter, value);
	}
	
	public HashMap<String, String> parameters() {
		return this.parameters;
	}

	@Override
	public String toString() {
		return "OAuthResponse [parameters=" + parameters + "]";
	}
}
