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

package com.themodernway.nativetools.client.storage.event;

import com.google.gwt.event.shared.GwtEvent;
import com.themodernway.nativetools.client.storage.IClientStorage;

public final class SessionStorageEvent extends GwtEvent<SessionStorageHandler>
{
    public static final Type<SessionStorageHandler> TYPE = new Type<SessionStorageHandler>();

    private final IClientStorage                    m_stg;

    private final String                            m_key;

    private final String                            m_old;

    private final String                            m_now;

    public SessionStorageEvent(final IClientStorage stg, final String key, final String old, final String now)
    {
        m_stg = stg;

        m_key = key;

        m_old = old;

        m_now = now;
    }

    public final IClientStorage getStorage()
    {
        return m_stg;
    }

    public final String getKey()
    {
        return m_key;
    }

    public final String getOld()
    {
        return m_old;
    }

    public final String getNow()
    {
        return m_now;
    }

    @Override
    public final Type<SessionStorageHandler> getAssociatedType()
    {
        return TYPE;
    }

    @Override
    protected void dispatch(final SessionStorageHandler handler)
    {
        handler.onSessionStorageChange(this);
    }
}
