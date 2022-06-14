/**
 * Personium
 * Copyright 2014-2021 Personium Project Authors
 * - FUJITSU LIMITED
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.personium.common.es.response.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;

import co.elastic.clients.elasticsearch.core.msearch.MultiSearchResponseItem;
import io.personium.common.es.response.PersoniumItem;
import io.personium.common.es.response.PersoniumSearchHit;

/**
 * Wrapper class for MultiSeasrchResponseItem.
 */
public class PersoniumItemImpl extends ElasticsearchResponseWrapper<MultiSearchResponseItem<ObjectNode>>
        implements PersoniumItem {
    /**
     * .
     * @param response .
     */
    protected PersoniumItemImpl(MultiSearchResponseItem<ObjectNode> response) {
        super(response);
    }

    /**
     * .
     * @param response .
     * @return .
     */
    public static PersoniumItem getInstance(MultiSearchResponseItem<ObjectNode> response) {
        return new PersoniumItemImpl(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersoniumSearchHit[] getSearchHits() {
        return PersoniumSearchHitsImpl.getInstance(getResponse().result().hits()).getHits();
    }

}
