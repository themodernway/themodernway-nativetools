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

public interface JSONWebSocketCallback
{
    public void onOpen(JSONWebSocket ws);

    public void onClose(JSONWebSocket ws);

    public void onError(JSONWebSocket ws, Throwable error);

    public void onMessage(JSONWebSocket ws, NObject message);

    public void onMessage(JSONWebSocket ws, NArray message);
}
