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
import com.themodernway.common.api.types.INamed;
import com.themodernway.nativetools.client.NArray;
import com.themodernway.nativetools.client.NObject;
import com.themodernway.nativetools.client.datamodel.AbstractJSONDataModel;
import com.themodernway.nativetools.client.datamodel.IJSONModel;

public interface IJSONNamedCommandRequest extends INamed, IJSONBaseRequest
{
    public Request call(AsyncCallback<NObject> callback);

    public Request call(NObject request, AsyncCallback<NObject> callback);

    public Request call(JSONObject request, AsyncCallback<NObject> callback);

    public Request call(NArray request, AsyncCallback<NObject> callback);

    public Request call(NArray request, String name, AsyncCallback<NObject> callback);

    public Request call(JSONArray request, AsyncCallback<NObject> callback);

    public Request call(JSONArray request, String name, AsyncCallback<NObject> callback);

    public <T extends IJSONModel<?>> Request call(Collection<T> request, AsyncCallback<NObject> callback);

    public <T extends IJSONModel<?>> Request call(Collection<T> request, String name, AsyncCallback<NObject> callback);

    public Request call(AbstractJSONDataModel request, AsyncCallback<NObject> callback);

    public Request call(AbstractModelRepresentation<NArray> request, AsyncCallback<NObject> callback);

    public Request call(AbstractModelRepresentation<NArray> request, String name, AsyncCallback<NObject> callback);
}