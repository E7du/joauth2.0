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

import java.util.UUID;

import cn.zhucongqi.oauth2.kit.HashKit;


/**
 * 
 * @author Jobsz [zcq@zhucongqi.cn]
 * @version
 */
public final class ValueGenerator {
	
    public String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    public String generateValue(String param) {
        return HashKit.sha256(UUID.fromString(UUID.nameUUIDFromBytes(param.getBytes()).toString()).toString());
    }
}
