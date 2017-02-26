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

package com.themodernway.nativetools.client.collection;

import com.themodernway.nativetools.client.NUtils;

public class NFastDoubleDictionaryJSO extends NFastPrimitiveDictionarytBaseJSO<NFastDoubleDictionaryJSO>
{
    public static final NFastDoubleDictionaryJSO make()
    {
        return createNObjectBaseJSO();
    }

    protected NFastDoubleDictionaryJSO()
    {
    }

    public final void put(final String name, final double value)
    {
        put_0(NUtils.doKeyRepair(name), value);
    }

    public final double get(final String name)
    {
        return get_0(NUtils.doKeyRepair(name));
    }

    private final native void put_0(String name, double value)
    /*-{
		this[name] = value;
    }-*/;

    private final native double get_0(String name)
    /*-{
		return this[name];
    }-*/;
}
