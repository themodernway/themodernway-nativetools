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

package com.themodernway.nativetools.client.storage;

import java.util.Collection;
import java.util.Map;

import com.themodernway.nativetools.client.NArray;
import com.themodernway.nativetools.client.NObject;

public interface IClientStorage
{
    public CacheType getType();

    public boolean isSupported();

    public Collection<String> keys();

    public void clear();

    public void remove(String key);

    public String getString(String key);

    public void putString(String key, String value);

    public NObject getNObject(String key);

    public void putNObject(String key, NObject value);

    public NArray getNArray(String key);

    public void putNArray(String key, NArray value);

    public boolean copyFrom(NObject object);

    public boolean copyFrom(Map<String, ?> map);

    public boolean copyFrom(IClientStorage storage);
}
