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
import java.util.function.Supplier;

import com.themodernway.common.api.java.util.StringOps;
import com.themodernway.nativetools.client.collection.NFastArrayList;

public class DefaultXSRFTokenQueue implements IXSRFTokenQueue
{
    private final String                    m_xurl;

    private final NFastArrayList<XSRFToken> m_list = new NFastArrayList<XSRFToken>();

    public DefaultXSRFTokenQueue(final String url)
    {
        m_xurl = StringOps.requireTrimOrNull(url);
    }

    @Override
    public String getURL()
    {
        return m_xurl;
    }

    @Override
    public Supplier<XSRFToken> take()
    {
        if (size() > 0)
        {
            return new DefaultXSRFTokenSupplier(m_list.shift());
        }
        return onEmpty();
    }

    @Override
    public void push(final XSRFToken token)
    {
        m_list.push(Objects.requireNonNull(token));
    }

    @Override
    public int size()
    {
        return m_list.size();
    }

    @Override
    public Supplier<XSRFToken> onEmpty()
    {
        return null;
    }
}
