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

package com.themodernway.nativetools.client.rpc;

import java.util.Objects;

import com.themodernway.nativetools.client.collection.NFastStringMap;

public class DefaultXSRFTokenQueueDictionary implements IXSRFTokenQueueDictionary
{
    private static DefaultXSRFTokenQueueDictionary INSTANCE;

    private final NFastStringMap<IXSRFTokenQueue>  m_urlmap;

    public static IXSRFTokenQueueDictionary get()
    {
        if (null == INSTANCE)
        {
            INSTANCE = new DefaultXSRFTokenQueueDictionary();
        }
        return INSTANCE;
    }

    protected DefaultXSRFTokenQueueDictionary()
    {
        m_urlmap = new NFastStringMap<IXSRFTokenQueue>();
    }

    @Override
    public IXSRFTokenQueue getXSRFTokenQueue(final String url)
    {
        Objects.requireNonNull(url);

        IXSRFTokenQueue list = m_urlmap.get(url);

        if (null == list)
        {
            list = new DefaultXSRFTokenQueue(url);

            m_urlmap.put(url, list);
        }
        return list;
    }
}
