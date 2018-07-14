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

import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletResponse;

import cn.zhucongqi.oauth2.consts.OAuthRequestErrCodes;
import cn.zhucongqi.oauth2.exception.OAuthProblemException;

/**
 * @author Jobsz [zcq@zhucongqi.cn]
 * @version
 */
public final class OAuthExceptionHandleKit {

	private OAuthExceptionHandleKit() {

	}

	private static OAuthProblemException handleInvalidReqOAuthProblemException(
			String message) {
		return OAuthProblemException.error(OAuthRequestErrCodes.REQUEST_ERR_CODE, message);
	}

	/**
	 * checkout request context type
	 * @param requestContentType
	 * @param requiredContentType
	 * @return
	 */
	public static boolean hasContentType(String requestContentType,
			String requiredContentType) {
		if (StrKit.isBlank(requiredContentType)
				|| StrKit.isBlank(requestContentType)) {
			return false;
		}
		StringTokenizer tokenizer = new StringTokenizer(requestContentType, ";");
		while (tokenizer.hasMoreTokens()) {
			if (requiredContentType.equals(tokenizer.nextToken())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * handle bad content type
	 * @param expectedContentType
	 * @return
	 */
	public static OAuthProblemException handleBadContentTypeException(
			String expectedContentType) {
		StringBuilder errorMsg = new StringBuilder(
				"Bad request content type. Expecting: ")
				.append(expectedContentType);
		return OAuthExceptionHandleKit
				.handleInvalidReqOAuthProblemException(errorMsg.toString());
	}
	
	
	/**
	 * handle miss parameter
	 * @param missingParams
	 * @return
	 */
	public static OAuthProblemException handleMissingParameters(
			Set<String> missingParams) {
		StringBuilder sb = new StringBuilder("Missing parameters: ");
		if (missingParams != null && !missingParams.isEmpty()) {
			boolean first = true;
			for (String missingParam : missingParams) {
				if (first) {
					first = false;
				}
	            else {
	                sb.append(", ");
	            }
				sb.append(missingParam);
			}
		}
		return OAuthExceptionHandleKit.handleInvalidReqOAuthProblemException(sb.toString()
				.trim());
	}
	
	/**
	 * handle invalid param default values
	 * @param key paramKey
	 * @param validValue
	 * @return
	 */
	public static OAuthProblemException handleInvalidValueException(String paramKey,
			String validValue, String currentValue) {
		String format = "Invalid value for '%s'.the valid value is '%s',current value is '%s'.";
		String desc = String.format(format, paramKey, validValue, currentValue);
		return OAuthProblemException
				.error(OAuthRequestErrCodes.REQUEST_ERR_CODE)
				.description(desc.trim())
				.responseStatus(HttpServletResponse.SC_FORBIDDEN);
	}
	
	/**
	 * handle invalid client
	 * @return
	 */
	public static OAuthProblemException handleInvalidClientException() {
		return OAuthProblemException
				.error(OAuthRequestErrCodes.REQUEST_ERR_CODE)
				.description("Invalid Client")
				.responseStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}
}
