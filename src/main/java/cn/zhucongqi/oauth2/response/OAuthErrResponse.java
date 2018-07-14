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
import cn.zhucongqi.oauth2.consts.OAuthError;
import cn.zhucongqi.oauth2.exception.OAuthProblemException;

/**
 * @author Jobsz [zcq@zhucongqi.cn]
 * @version
 */
public class OAuthErrResponse extends OAuthResponse {

	@Override
	protected void init() {
		
	}
	
	public OAuthErrResponse(OAuthValidator validator) {
		super(validator);
	}

	public OAuthErrResponse(OAuthValidator validator, OAuthProblemException e) {
		super(validator);
		this.setError(e.getError()).setErrorDescription(e.getDescription());
	}

	/**
	 * Set Error
	 * @param error
	 */
	public OAuthErrResponse setError(String error) {
		this.putParameter(OAuthError.OAUTH_ERROR, error);
		return this;
	}
	
	/**
	 * Set Error Description
	 * @param errorDecription
	 */
	public OAuthErrResponse setErrorDescription(String errorDecription) {
		this.putParameter(OAuthError.OAUTH_ERROR_DESCRIPTION, errorDecription);
		return this;
	}

}
