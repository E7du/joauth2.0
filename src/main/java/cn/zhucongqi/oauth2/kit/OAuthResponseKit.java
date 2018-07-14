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
package cn.zhucongqi.oauth2.kit;

import cn.zhucongqi.oauth2.base.validator.OAuthValidator;
import cn.zhucongqi.oauth2.exception.OAuthProblemException;
import cn.zhucongqi.oauth2.response.OAuthAccessToken;
import cn.zhucongqi.oauth2.response.OAuthCodeResponse;
import cn.zhucongqi.oauth2.response.OAuthErrResponse;

/**
 * @author Jobsz [zcq@zhucongqi.cn]
 * @version
 */
public final class OAuthResponseKit {
	
	public static OAuthCodeResponse codeResp(OAuthValidator validator) {
		return (new OAuthCodeResponse(validator));
	}
	
	public static OAuthAccessToken tokenResp(OAuthValidator validator) {
		return (new OAuthAccessToken(validator));
	}

	public static OAuthErrResponse errorResp(OAuthValidator validator, OAuthProblemException e) {
		return (new OAuthErrResponse(validator, e));
	}
}
