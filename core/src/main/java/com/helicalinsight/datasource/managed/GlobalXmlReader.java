/**
 *    Copyright (C) 2013-2017 Helical IT Solutions (http://www.helicalinsight.com) - All rights reserved.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.helicalinsight.datasource.managed;

import com.helicalinsight.efw.exceptions.ConfigurationException;
import com.helicalinsight.efw.framework.utils.ApplicationContextAccessor;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by author on 28-02-2015.
 *
 * @author Rajasekhar
 */
@Component
class GlobalXmlReader implements IGlobalXmlReader {

    public String getDataSourceJson(Integer connectionId, File file) {
        IConnectionSettings connectionSettings = ApplicationContextAccessor.getBean(IConnectionSettings.class);
        String json = connectionSettings.getJson(file, connectionId);
        if (json == null) {
            throw new ConfigurationException("The application configuration is incorrect. Check the connections " +
                    "xml.");
        }
        return json;
    }
}
