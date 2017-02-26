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

import java.util.Collection;

import com.themodernway.nativetools.client.NArray;

public final class AttachmentList extends StringList
{
    public AttachmentList()
    {
    }

    public AttachmentList(final NArray array)
    {
        super(array);
    }

    public AttachmentList(final String value)
    {
        super(value);
    }

    public AttachmentList(final String value, final String... values)
    {
        super(value, values);
    }

    public AttachmentList(final Collection<String> values)
    {
        super(values);
    }

    public AttachmentList(final StringList list)
    {
        super(list);
    }

    @Override
    public AttachmentList copy()
    {
        return new AttachmentList(this);
    }
}
