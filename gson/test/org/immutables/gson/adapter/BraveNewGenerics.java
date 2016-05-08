/*
   Copyright 2016 Immutables Authors and Contributors

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
package org.immutables.gson.adapter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

/**
 * Now you can serialize and deserialize
 * parametrized value objects using Gson
 */
@Gson.TypeAdapters
class BraveNewGenerics {
  @Value.Immutable
  interface Top {
    Params<String, Integer> stringAndInt();
    Params<Double, List<Integer>> doubleAndIntlist();
  }

  @Value.Immutable
  interface Params<T, V> {
    T t();
    Map<String, V> m();
  }

  static Top createTop() {
    return ImmutableTop.builder()
        .stringAndInt(ImmutableParams.<String, Integer>builder()
            .t("AAA")
            .putM("b", 1)
            .build())
        .doubleAndIntlist(ImmutableParams.<Double, List<Integer>>builder()
            .t(2.2)
            .putM("x", Arrays.asList(1, 2, 3))
            .build())
        .build();
  }
}