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

package com.themodernway.nativetools.client.websocket;

import com.themodernway.nativetools.client.NArray;
import com.themodernway.nativetools.client.NObject;
import com.themodernway.nativetools.client.util.Client;

public abstract class AbstractJSONWebSocketCallback implements JSONWebSocketCallback
{
    @Override
    public void onOpen(final JSONWebSocket ws)
    {
    }

    @Override
    public void onClose(final JSONWebSocket ws)
    {
    }

    @Override
    public void onError(final JSONWebSocket ws, final Throwable error)
    {
        Client.get().error("JSONWebSocket", error);
    }

    @Override
    public void onMessage(final JSONWebSocket ws, final NArray message)
    {
        if (null != message)
        {
            final int size = message.size();

            for (int i = 0; i < size; i++)
            {
                final NObject object = message.asNObject();

                if (null != message)
                {
                    onMessage(ws, object);
                }
            }
        }
    }
}
