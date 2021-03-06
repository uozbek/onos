/*
 * Copyright 2017-present Open Networking Foundation
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

package org.onosproject.p4runtime.model;

import org.onosproject.net.pi.model.PiControlMetadataId;
import org.onosproject.net.pi.model.PiControlMetadataModel;

import java.util.Objects;

/**
 * Implementation of PiControlMetadataModel for P4Runtime.
 */
final class P4ControlMetadataModel implements PiControlMetadataModel {

    private final PiControlMetadataId id;
    private final int bitWidth;

    P4ControlMetadataModel(PiControlMetadataId id, int bitWidth) {
        this.id = id;
        this.bitWidth = bitWidth;
    }

    @Override
    public PiControlMetadataId id() {
        return id;
    }

    @Override
    public int bitWidth() {
        return bitWidth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bitWidth);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final P4ControlMetadataModel other = (P4ControlMetadataModel) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.bitWidth, other.bitWidth);
    }
}
