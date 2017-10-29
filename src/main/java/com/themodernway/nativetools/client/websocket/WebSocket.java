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

import java.util.Collection;
import java.util.Objects;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.http.client.URL;
import com.themodernway.common.api.java.util.StringOps;
import com.themodernway.common.api.java.util.UUID;
import com.themodernway.nativetools.client.collection.NFastStringArray;

public class WebSocket implements IWebSocket<String>
{
    private boolean                 m_isopened;

    private String                  m_sockuuid;

    private final WebSocketCallback m_callback;

    public WebSocket(final String url, final WebSocketCallback callback)
    {
        this(url, (NFastStringArray) null, callback);
    }

    public WebSocket(final String url, final String protocol, final WebSocketCallback callback)
    {
        this(url, new NFastStringArray(Objects.requireNonNull(protocol)), callback);
    }

    public WebSocket(final String url, final Collection<String> protocols, final WebSocketCallback callback)
    {
        this(url, new NFastStringArray(protocols), callback);
    }

    public WebSocket(final String url, final NFastStringArray protocols, final WebSocketCallback callback)
    {
        if (false == isSupported())
        {
            throw new IllegalStateException("WebSocket is not supported");
        }
        m_callback = Objects.requireNonNull(callback, "WebSocketCallback is null");

        if ((null == protocols) || (protocols.isEmpty()))
        {
            connect_0(URL.encode(StringOps.requireTrimOrNull(wsPath(url))), null);
        }
        else
        {
            connect_0(URL.encode(StringOps.requireTrimOrNull(wsPath(url))), protocols.getJSO());
        }
    }

    @Override
    public void send(final String message)
    {
        if (null == message)
        {
            throw new NullPointerException("message is null");
        }
        try
        {
            send_0(message);
        }
        catch (final Exception e)
        {
            m_callback.onError(this, e);
        }
    }

    @Override
    public void close()
    {
        m_isopened = false;

        close_0();
    }

    @Override
    public int getBufferedAmount()
    {
        return getBufferedAmount_0();
    }

    @Override
    public int getReadyState()
    {
        return getReadyState_0();
    }

    @Override
    public String getURL()
    {
        return getURL_0();
    }

    @Override
    public String getProtocol()
    {
        return getProtocol_0();
    }

    @Override
    public boolean isOpen()
    {
        return m_isopened;
    }

    @Override
    public String uuid()
    {
        if (null == m_sockuuid)
        {
            m_sockuuid = UUID.uuid();
        }
        return m_sockuuid;
    }

    private final void onOpenHelper()
    {
        m_isopened = true;

        m_callback.onOpen(this);
    }

    private final void onCloseHelper()
    {
        m_isopened = false;

        m_callback.onClose(this);
    }

    private final void onMessageHelper(final String message)
    {
        m_callback.onMessage(this, message);
    }

    private final void onErrorHelper(final String error)
    {
        m_callback.onError(this, new Exception(error));
    }

    public static final String wsPath(String path)
    {
        path = StringOps.requireTrimOrNull(path);

        if (path.startsWith("ws://") || path.startsWith("wss://"))
        {
            return path;
        }
        String host = GWT.getHostPageBaseURL().replaceFirst("http", "ws").trim();

        while (host.endsWith("/"))
        {
            if (host.length() > 0)
            {
                host = host.substring(0, host.length() - 1).trim();
            }
        }
        while (path.endsWith("/"))
        {
            if (path.length() > 0)
            {
                path = path.substring(0, path.length() - 1).trim();
            }
        }
        while (path.startsWith("/"))
        {
            if (path.length() > 0)
            {
                path = path.substring(1).trim();
            }
        }
        return host + "/" + path;
    }

    public static final native boolean isSupported()
    /*-{
		return (!!$wnd.WebSocket);
    }-*/;

    private final native void connect_0(String url, JavaScriptObject protocols)
    /*-{
		var self = this;

		var list = protocols;

		if ((list) && (list.length > 0)) {
			self.socket = new $wnd.WebSocket(url, list);
		} else {
			self.socket = new $wnd.WebSocket(url);
		}
		self.socket.onopen = function() {
			if (!self.socket) {
				self.@com.themodernway.nativetools.client.websocket.WebSocket::onErrorHelper(Ljava/lang/String;)("WebSocket connections not supported by this browser");
				return;
			}
			self.@com.themodernway.nativetools.client.websocket.WebSocket::onOpenHelper()();
		};
		self.socket.onmessage = function(response) {
			if ((response) && (response.data)) {
				self.@com.themodernway.nativetools.client.websocket.WebSocket::onMessageHelper(Ljava/lang/String;)(response.data);
			}
		};
		self.socket.onerror = function(error) {
			if (error) {
				self.@com.themodernway.nativetools.client.websocket.WebSocket::onErrorHelper(Ljava/lang/String;)("WebSocket ERROR: " + error);
			} else {
				self.@com.themodernway.nativetools.client.websocket.WebSocket::onErrorHelper(Ljava/lang/String;)("WebSocket ERROR: UNKNOWN");
			}
		};
		self.socket.onclose = function(m) {
			self.@com.themodernway.nativetools.client.websocket.WebSocket::onCloseHelper()();
		};
    }-*/;

    private final native void close_0()
    /*-{
		this.socket.close();
    }-*/;

    private final native int getReadyState_0()
    /*-{
		this.socket.readyState;
    }-*/;

    private final native int getBufferedAmount_0()
    /*-{
		this.socket.bufferedAmount;
    }-*/;

    private final native String getProtocol_0()
    /*-{
		this.socket.protocol;
    }-*/;

    private final native String getURL_0()
    /*-{
		this.socket.url;
    }-*/;

    private final native void send_0(String message)
    /*-{
		this.socket.send(message);
    }-*/;
}
