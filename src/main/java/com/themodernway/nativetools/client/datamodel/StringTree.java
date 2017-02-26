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

package com.themodernway.nativetools.client.datamodel;

import com.themodernway.common.api.types.IValued;
import com.themodernway.nativetools.client.NObject;

public final class StringTree extends AbstractJSONDataModel implements IValued<String>
{
    public StringTree()
    {
        this(new NObject());
    }

    public StringTree(final NObject object)
    {
        super(object);

        if (false == isString("value"))
        {
            setValue(null);
        }
        if (false == isArray("list"))
        {
            setTreeList(new StringTreeList());
        }
    }

    public StringTree(final String value)
    {
        this(new NObject());

        setValue(value);
    }

    @Override
    public final String getValue()
    {
        return getModel().getAsString("value");
    }

    public final void setValue(final String value)
    {
        getModel().put("value", value);
    }

    public final StringTreeList getTreeList()
    {
        return new StringTreeList(getModel().getAsArray("list"));
    }

    public final void setTreeList(final StringTreeList list)
    {
        getModel().put("list", list.getModel());
    }
}
