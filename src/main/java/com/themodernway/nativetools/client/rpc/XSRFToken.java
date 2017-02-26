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

import com.themodernway.common.api.java.util.StringOps;
import com.themodernway.common.api.types.IStringValued;

public final class XSRFToken implements IStringValued
{
    private final String m_token;

    public XSRFToken(final String token)
    {
        m_token = StringOps.requireTrimOrNull(token);
    }

    @Override
    public final String getValue()
    {
        return m_token;
    }

    @Override
    public String toString()
    {
        return getValue();
    }

    @Override
    public boolean equals(final Object other)
    {
        if ((other == null) || (false == (other instanceof XSRFToken)))
        {
            return false;
        }
        if (this == other)
        {
            return true;
        }
        final XSRFToken that = ((XSRFToken) other);

        return (that.getValue().equals(getValue()));
    }

    @Override
    public int hashCode()
    {
        return getValue().hashCode();
    }
}
