/*
 * Copyright or © or Copr. Moribus (2013)
 * Copyright or © or Copr. ProkopyL <prokopylmc@gmail.com> (2015)
 * Copyright or © or Copr. Amaury Carrade <amaury@carrade.eu> (2016 – 2021)
 * Copyright or © or Copr. Vlammar <valentin.jabre@gmail.com> (2019 – 2021)
 *
 * This software is a computer program whose purpose is to allow insertion of
 * custom images in a Minecraft world.
 *
 * This software is governed by the CeCILL license under French law and
 * abiding by the rules of distribution of free software.  You can  use,
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 *
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability.
 *
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or
 * data to be ensured and,  more generally, to use and operate it in the
 * same conditions as regards security.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 */

package ru.fleyer.ftest.map;

import java.util.Map;
import java.util.UUID;
import org.bukkit.configuration.InvalidConfigurationException;

public class SingleMap extends ImageMap {
    protected final int mapID;

    public SingleMap(UUID ownerUUID, int mapID, String id, String name) {
        super(ownerUUID, Type.SINGLE, id, name);
        this.mapID = mapID;
    }

    public SingleMap(UUID ownerUUID, int mapID) {
        this(ownerUUID, mapID, null, null);
    }

    public SingleMap(Map<String, Object> map, UUID userUUID) throws InvalidConfigurationException {
        super(map, userUUID, Type.SINGLE);
        mapID = getFieldValue(map, "mapID");
    }

    @Override
    public int[] getMapsIDs() {
        return new int[] {mapID};
    }

    @Override
    public boolean managesMap(int mapID) {
        return this.mapID == mapID;
    }

    /* ====== Serialization methods ====== */

    @Override
    public int getMapCount() {
        return 1;
    }

    @Override
    protected void postSerialize(Map<String, Object> map) {
        map.put("mapID", mapID);
    }

}
