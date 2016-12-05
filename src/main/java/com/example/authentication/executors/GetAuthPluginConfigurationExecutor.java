/*
 * Copyright 2016 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.authentication.executors;

import com.google.gson.Gson;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.HashMap;
import java.util.Map;

import static com.thoughtworks.go.plugin.api.response.DefaultGoApiResponse.SUCCESS_RESPONSE_CODE;

public class GetAuthPluginConfigurationExecutor {
    private static final Gson GSON = new Gson();

    public GoPluginApiResponse execute() {
        Map<String, Object> configuration = getConfiguration();

        DefaultGoPluginApiResponse defaultGoPluginApiResponse = new DefaultGoPluginApiResponse(SUCCESS_RESPONSE_CODE);
        defaultGoPluginApiResponse.setResponseBody(GSON.toJson(configuration));
        return defaultGoPluginApiResponse;
    }

    //TODO: change this to your needs
    Map<String, Object> getConfiguration() {
        Map<String, Object> configuration = new HashMap<String, Object>();
        configuration.put("display-name", "GoCD auth skeleton plugins");
        configuration.put("display-image-url", "data:image/png;base64,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");
        configuration.put("supports-web-based-authentication", true);
        configuration.put("supports-password-based-authentication", true);
        return configuration;
    }
}
