package org.appenders.log4j2.elasticsearch.bulkprocessor;

/*-
 * #%L
 * log4j2-elasticsearch
 * %%
 * Copyright (C) 2018 Rafal Foltynski
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.appenders.log4j2.elasticsearch.Auth;
import org.appenders.log4j2.elasticsearch.ClientProvider;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;

public class SecureClientProvider implements ClientProvider<TransportClient> {

    private final Auth<Settings.Builder> auth;

    public SecureClientProvider(Auth<Settings.Builder> auth) {
        this.auth = auth;
    }

    @Override
    public TransportClient createClient() {
        Settings.Builder clientSettingsBuilder = Settings.builder();

        auth.configure(clientSettingsBuilder);

        return new PreBuiltXPackTransportClient(clientSettingsBuilder.build());
    }

}
