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

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.zhucongqi.oauth2.request.OAuthHttpServletRequest;

/**
 * @author Jobsz
 *
 */
public final class OAuthRequestKit {

	public static OAuthHttpServletRequest cp(HttpServletRequest r) {
		OAuthHttpServletRequest or = new OAuthHttpServletRequest();
		or.setContentType(r.getContentType());
		or.setMethod(r.getMethod());
		
		List<String> parameters = or.getParameters();
		for (String key : parameters) {
			String value = r.getParameter(key);
			if (StrKit.notBlank(value)) {
				or.setParameter(key, value);
			}
		}
		return or;
	}
	
	public static OAuthHttpServletRequest cp(HttpServletRequest r, String[] otherParameters) {
		OAuthHttpServletRequest or =  OAuthRequestKit.cp(r);
		or.setExtParametes(otherParameters);
		return or;
	}
}
