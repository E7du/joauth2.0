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
package cn.zhucongqi.oauth2.issuer;

/**
 * 
 * @author Jobsz [zcq@zhucongqi.cn]
 * @version
 */
public final class OAuthIssuerKit implements OAuthIssuer {

    private ValueGenerator vg = null;

    public OAuthIssuerKit(ValueGenerator vg) {
        this.vg = vg;
    }

    public static OAuthIssuerKit issuer() {
    	return (new OAuthIssuerKit(new ValueGenerator()));
    }
    
    public String accessToken() {
        return this.vg.generateValue();
    }

    public String refreshToken() {
        return this.vg.generateValue();
    }

    public String authorizationCode() {
        return this.vg.generateValue();
    }
}
