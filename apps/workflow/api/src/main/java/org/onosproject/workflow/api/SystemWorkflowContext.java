/*
 * Copyright 2018-present Open Networking Foundation
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
package org.onosproject.workflow.api;

import com.google.common.base.MoreObjects;

import java.net.URI;

/**
 * WorkflowContext for system workflow.
 */
public class SystemWorkflowContext extends DefaultWorkflowContext {

    /**
     * Timestamp when this system workflow context was created.
     */
    private final long timestamp;

    /**
     * Distributor string for designating which onos node executes this workflow context with work partition.
     */
    private String distributor;

    /**
     * The constructor of SystemWorkflowContext.
     * @param workflowId id of workflow
     * @param workplaceName workplace name
     * @param data data model tree
     */
    public SystemWorkflowContext(URI workflowId, String workplaceName, DataModelTree data) {
        super(workflowId, workplaceName, data);
        timestamp = System.currentTimeMillis();
        //initial distributor(It can be changed)
        distributor = name();
    }

    @Override
    public String distributor() {
        return distributor;
    }

    /**
     * Sets distributor string of this workflow context.
     * @param distributor distributor string
     */
    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    @Override
    public String name() {
        return workflowId().toString()
                + ":" + timestamp
                + "@" + workplaceName();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
                .add("name", name())
                .add("triggernext", triggerNext())
                .add("data", data())
                .add("current", current())
                .add("state", state())
                .add("cause", cause())
                .toString();
    }
}
