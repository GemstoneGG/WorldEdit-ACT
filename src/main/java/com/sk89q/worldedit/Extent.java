/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit;

import com.sk89q.worldedit.blocks.BaseBlock;

/**
 * A world, portion of a world, clipboard, or other object that can have blocks set or
 * entities placed.
 */
public interface Extent {

    /**
     * Get a copy of the block at the given location. May return null if the location
     * given is out of bounds. The returned block must not be tied to any real block
     * in the world, so changes to the returned {@link BaseBlock} have no effect until
     * {@link #setBlock(Vector, BaseBlock)} is called.
     *
     * @param location location of the block
     * @return the block, or null if the block does not exist
     */
    BaseBlock getBlock(Vector location);

    /**
     * Get the block ID at the given location.
     *
     * @param location location of the block
     * @return the block ID
     */
    int getBlockType(Vector location);

    /**
     * Get the data value of the block at the given location.
     *
     * @param location the location of the block
     * @return the block data value
     */
    int getBlockData(Vector location);

    /**
     * Change the block at the given location to the given block. The operation may
     * not tie the given {@link BaseBlock} to the world, so future changes to the
     * {@link BaseBlock} do not affect the world until this method is called again.
     *
     * <p>The return value of this method indicates whether the change "went through," as
     * in the block was changed in the world in any way. If the new block is no different
     * than the block already at the position in the world, 'false' would be returned.
     * If the position is invalid (out of bounds, for example), then nothing should
     * occur and 'false' should be returned. If possible, the return value should be
     * accurate as possible, but implementations may choose to not provide an accurate
     * value if it is not possible to know.</p>
     *
     * @param location location of the block
     * @param block block to set
     * @param notifyAdjacent true to notify adjacent blocks of changes
     * @return true if the block was successfully set (return value may not be accurate)
     */
    boolean setBlock(Vector location, BaseBlock block, boolean notifyAdjacent);

}
