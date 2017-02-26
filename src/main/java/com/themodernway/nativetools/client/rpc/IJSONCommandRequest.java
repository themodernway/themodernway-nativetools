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

import java.util.Collection;

import com.google.gwt.http.client.Request;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.themodernway.common.api.model.AbstractModelRepresentation;
import com.themodernway.nativetools.client.NArray;
import com.themodernway.nativetools.client.NObject;
import com.themodernway.nativetools.client.datamodel.AbstractJSONDataModel;
import com.themodernway.nativetools.client.datamodel.IJSONModel;

public interface IJSONCommandRequest extends IJSONBaseRequest
{
    public Request call(String command, AsyncCallback<NObject> callback);

    public Request call(String command, NObject request, AsyncCallback<NObject> callback);

    public Request call(String command, JSONObject request, AsyncCallback<NObject> callback);

    public Request call(String command, NArray request, AsyncCallback<NObject> callback);

    public Request call(String command, NArray request, String name, AsyncCallback<NObject> callback);

    public Request call(String command, JSONArray request, AsyncCallback<NObject> callback);

    public Request call(String command, JSONArray request, String name, AsyncCallback<NObject> callback);

    public <T extends IJSONModel<?>> Request call(String command, Collection<T> request, AsyncCallback<NObject> callback);

    public <T extends IJSONModel<?>> Request call(String command, Collection<T> request, String name, AsyncCallback<NObject> callback);

    public Request call(String command, AbstractJSONDataModel request, AsyncCallback<NObject> callback);

    public Request call(String command, AbstractModelRepresentation<NArray> request, AsyncCallback<NObject> callback);

    public Request call(String command, AbstractModelRepresentation<NArray> request, String name, AsyncCallback<NObject> callback);
}