/*
   Copyright (c) 2017, The Modern Way. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.themodernway.nativetools.client.resting;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.google.gwt.http.client.Header;
import com.themodernway.common.api.java.util.IHTTPConstants;
import com.themodernway.common.api.java.util.StringOps;
import com.themodernway.nativetools.client.collection.NFastStringDictionary;
import com.themodernway.nativetools.client.collection.NFastStringMap;
import com.themodernway.nativetools.client.storage.ClientStorage;
import com.themodernway.nativetools.client.storage.LocalStorage;
import com.themodernway.nativetools.client.storage.SessionStorage;
import com.themodernway.nativetools.client.util.Client;

public class NRestingHeaders extends LinkedHashMap<String, String> implements IRestingCommon, IHTTPConstants
{
    private static final long serialVersionUID = -4981722542774013096L;

    private int               m_time           = -1;

    private String            m_user           = null;

    private String            m_pass           = null;

    private boolean           m_cred           = false;

    public NRestingHeaders()
    {
    }

    public NRestingHeaders(final Map<String, String> hmap)
    {
        Objects.requireNonNull(hmap);

        for (String s : hmap.keySet())
        {
            final String k = StringOps.toTrimOrNull(Operations.clean(s));

            if (null != k)
            {
                final String v = StringOps.toTrimOrNull(Operations.clean(hmap.get(k)));

                if (null != v)
                {
                    put(k, v);
                }
            }
        }
    }

    public NRestingHeaders(final NFastStringDictionary hmap)
    {
        Objects.requireNonNull(hmap);

        for (String s : hmap.keys())
        {
            final String k = StringOps.toTrimOrNull(Operations.clean(s));

            if (null != k)
            {
                final String v = StringOps.toTrimOrNull(Operations.clean(hmap.get(k)));

                if (null != v)
                {
                    put(k, v);
                }
            }
        }
    }

    public NRestingHeaders(final NFastStringMap<String> hmap)
    {
        Objects.requireNonNull(hmap);

        for (String s : hmap.keys())
        {
            final String k = StringOps.toTrimOrNull(Operations.clean(s));

            if (null != k)
            {
                final String v = StringOps.toTrimOrNull(Operations.clean(hmap.get(k)));

                if (null != v)
                {
                    put(k, v);
                }
            }
        }
    }

    public NRestingHeaders(final Header[] hmap)
    {
        Objects.requireNonNull(hmap);

        for (Header head : hmap)
        {
            final String k = StringOps.toTrimOrNull(Operations.clean(head.getName()));

            if (null != k)
            {
                final String v = StringOps.toTrimOrNull(Operations.clean(head.getValue()));

                if (null != v)
                {
                    put(k, v);
                }
            }
        }
    }

    public Collection<String> keys()
    {
        return keySet();
    }

    public NRestingHeaders setOptions(final NRestingHeaders head)
    {
        return setTimeout(head.getTimeout()).setUsername(head.getUsername()).setPassword(head.getPassword()).setIncludeCredentials(head.getIncludeCredentials());
    }

    public int getTimeout()
    {
        return m_time;
    }

    public NRestingHeaders setTimeout(final int time)
    {
        m_time = time;

        return this;
    }

    public boolean getIncludeCredentials()
    {
        return m_cred;
    }

    public NRestingHeaders setIncludeCredentials(final boolean cred)
    {
        m_cred = cred;

        return this;
    }

    public String getUsername()
    {
        return m_user;
    }

    public NRestingHeaders setUsername(final String user)
    {
        m_user = user;

        return this;
    }

    public String getPassword()
    {
        return m_pass;
    }

    public NRestingHeaders setPassword(final String pass)
    {
        m_pass = pass;

        return this;
    }

    protected List<String> getStorageHeaderNames()
    {
        return Arrays.asList(X_USER_ID_HEADER, X_USER_NAME_HEADER, X_SESSION_ID_HEADER, X_SESSION_UUID_HEADER, X_CLIENT_NAME_HEADER, X_CLIENT_API_TOKEN_HEADER);
    }

    protected String getHeaderFromStorage(String name)
    {
        name = StringOps.toTrimOrNull(name);

        if (null == name)
        {
            return null;
        }
        String header = null;

        if (LocalStorage.get().isSupported())
        {
            header = LocalStorage.get().getString(name);
        }
        if (null == header)
        {
            if (SessionStorage.get().isSupported())
            {
                header = SessionStorage.get().getString(name);
            }
        }
        if (null == header)
        {
            if (ClientStorage.get().isSupported())
            {
                header = ClientStorage.get().getString(name);
            }
        }
        return header;
    }

    public NRestingHeaders doRESTHeaders()
    {
        return doRESTHeaders(this);
    }

    public static final NRestingHeaders doRESTHeaders(final NRestingHeaders hmap)
    {
        final NRestingHeaders make = new NRestingHeaders(hmap);

        make.put(ACCEPT_HEADER, CONTENT_TYPE_APPLICATION_JSON);

        make.put(CONTENT_TYPE_HEADER, CONTENT_TYPE_APPLICATION_JSON);

        make.put(X_STRICT_JSON_FORMAT_HEADER, "true");

        make.put(X_CLIENT_UUID_HEADER, Client.get().getClientUUID());

        for (String name : hmap.getStorageHeaderNames())
        {
            final String head = StringOps.toTrimOrNull(Operations.clean(name));

            if (null != head)
            {
                final String valu = StringOps.toTrimOrNull(Operations.clean(hmap.getHeaderFromStorage(head)));

                if (null != valu)
                {
                    make.put(head, valu);
                }
            }
        }
        return make;
    }
}
