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

package com.themodernway.nativetools.client.datamodel.controller;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;

import com.themodernway.nativetools.client.datamodel.AbstractDataModelID;

public interface IDataModelIDController<T extends AbstractDataModelID<T>> extends IDataModelController<T>
{
    public void delete(T model, Consumer<Boolean> callback);

    public void update(Collection<T> batch, Consumer<Boolean> callback);

    public void update(T model, Consumer<Boolean> callback);

    public void getIDSet(Collection<T> list, Consumer<Set<String>> callback);

    public boolean isUpdateToStorage();

    public boolean isUpdateWaitingOn();

    public boolean isDeleteWaitingOn();
}
