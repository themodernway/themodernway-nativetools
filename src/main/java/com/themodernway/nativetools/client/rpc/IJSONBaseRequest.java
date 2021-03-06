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

import com.themodernway.common.api.java.util.IHTTPConstants;
import com.themodernway.common.api.types.IActivatable;

public interface IJSONBaseRequest extends IActivatable, IHTTPConstants
{
    public String getURL();

    public boolean isXSRFActive();

    public boolean isCommandInBody();
}
