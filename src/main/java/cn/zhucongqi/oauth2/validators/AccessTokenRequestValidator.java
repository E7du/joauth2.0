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
package cn.zhucongqi.oauth2.validators;

import cn.zhucongqi.oauth2.base.response.types.GrantType;
import cn.zhucongqi.oauth2.base.validator.OAuthValidator;
import cn.zhucongqi.oauth2.consts.OAuthConsts;
import cn.zhucongqi.oauth2.request.OAuthHttpServletRequest;

/**
 * @author Jobsz [zcq@zhucongqi.cn]
 */
public class AccessTokenRequestValidator extends OAuthValidator {

	private static final long serialVersionUID = 5953595155817038008L;

	public AccessTokenRequestValidator(OAuthHttpServletRequest request) {
    	super(request);
    }

	@Override
	public void initParamDefaultValues() {
		this.paramDefaultValues.put(OAuthConsts.OAuth.OAUTH_GRANT_TYPE, GrantType.AUTHORIZATION_CODE.toString());
		//code,clientid,redurect_uri in OAuthClientCredentials logic validate.
	}

	@Override
	public void initRequiredParams() {
		this.requiredParams.add(OAuthConsts.OAuth.OAUTH_GRANT_TYPE);//Value MUST be set to "authorization_code".
		this.requiredParams.add(OAuthConsts.OAuth.OAUTH_AUTHORIZATION_CODE);//REQUIRED. The authorization code received from the authorization server.
		this.requiredParams.add(OAuthConsts.OAuth.OAUTH_REDIRECT_URI);//REQUIRED, if the "redirect_uri" parameter was included in the authorization request as described in Section 4.1.1, and their values MUST be identical.
		this.requiredParams.add(OAuthConsts.OAuth.OAUTH_CLIENT_ID);//REQUIRED, if the client is not authenticating with the authorization server as described in Section 3.2.1.
	}

}
