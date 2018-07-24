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
@SuppressWarnings({ "unchecked"})
public class OAuthErrResponse extends OAuthResponse {

	private static final long serialVersionUID = -8067815617069678224L;

	@Override
	protected void init() {
		
	}
	
	public OAuthErrResponse() {
		
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
		this.put(OAuthError.OAUTH_ERROR, error);
		return this;
	}
	
	/**
	 * Get Error
	 */
	public String getError() {
		return (String) this.get(OAuthError.OAUTH_ERROR);
	}
	
	/**
	 * Set Error Description
	 * @param errorDecription
	 */
	public OAuthErrResponse setErrorDescription(String errorDecription) {
		this.put(OAuthError.OAUTH_ERROR_DESCRIPTION, errorDecription);
		return this;
	}
	
	/**
	 * Get Error Description
	 * @return
	 */
	public String getErrorDescription() {
		return (String) this.get(OAuthError.OAUTH_ERROR_DESCRIPTION);
	}
}
