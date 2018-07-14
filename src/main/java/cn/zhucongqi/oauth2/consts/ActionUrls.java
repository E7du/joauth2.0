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
package cn.zhucongqi.oauth2.consts;

/**
 * 
 * @author Jobsz [zcq@zhucongqi.cn]
 * @version
 */
public final class ActionUrls {
	
	public static final String BASE_URL = "oauth2/";
	// authrize url
	public static final String AUTHORIZE_URL = BASE_URL + "authorize";
	// authrize code url
	public static final String AUTHORIZE_CODE_URL = BASE_URL + "authorize_code";
	// access token url
	public static final String ACCESS_TOKEN_URL = BASE_URL + "access_token";
	// refresh token url
	public static final String REFRESH_TOKEN_URL = BASE_URL + "refresh_token";
	// secure access token url
	public static final String SECURE_ACCESS_TOKEN_URL = BASE_URL + "secure_access_token";
}
