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
 * Validator that checks for the required fields in an OAuthConsts Token request with the Refresh token grant type.
 * This validator enforces client authentication either through basic authentication or body parameters.
 *
 * http://www.rfcreader.com/#rfc6749
 * 6.  Refreshing an Access Token
 * @author Jobsz [zcq@zhucongqi.cn]
 * @version
 */
public class RefreshTokenValidator extends OAuthValidator {

    public RefreshTokenValidator(OAuthHttpServletRequest request) {
    	super(request);
    }

    @Override
	public void initParamDefaultValues() {
    	this.paramDefaultValues.put(OAuthConsts.OAuth.OAUTH_GRANT_TYPE, GrantType.REFRESH_TOKEN.toString());
    	//refreshcode in OAuthClientCredentials logic validate.
	}

	@Override
	public void initRequiredParams() {
        this.requiredParams.add(OAuthConsts.OAuth.OAUTH_GRANT_TYPE); //Value MUST be set to "refresh_token".
        this.requiredParams.add(OAuthConsts.OAuth.OAUTH_REFRESH_TOKEN);//REQUIRED.  The refresh token issued to the client.
	}

}
