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

import cn.zhucongqi.oauth2.base.response.types.ResponseType;
import cn.zhucongqi.oauth2.base.validator.OAuthValidator;
import cn.zhucongqi.oauth2.consts.OAuthConsts;
import cn.zhucongqi.oauth2.request.OAuthHttpServletRequest;

/**
 * 
    GET /authorize?response_type=code&client_id=s6BhdRkqt3&state=xyz
        &redirect_uri=https%3A%2F%2Fclient%2Eexample%2Ecom%2Fcb HTTP/1.1
    Host: server.example.com
 * @author Jobsz [zcq@zhucongqi.cn]
 */
public class AuthorizationRequestValidator extends OAuthValidator {

	private static final long serialVersionUID = 6252782875378381870L;

	public AuthorizationRequestValidator(OAuthHttpServletRequest request) {
    	super(request);
    }

	@Override
	public void initParamDefaultValues() {
		this.paramDefaultValues.put(OAuthConsts.OAuth.OAUTH_RESPONSE_TYPE, ResponseType.CODE.toString());
		//clientid in OAuthClientCredentials logic validate.
	}

	@Override
	public void initRequiredParams() {
		this.requiredParams.add(OAuthConsts.OAuth.OAUTH_RESPONSE_TYPE);//REQUIRED.  Value MUST be set to "code".
		this.requiredParams.add(OAuthConsts.OAuth.OAUTH_CLIENT_ID);//REQUIRED.  The client identifier as described in Section 2.2.
	}

}

