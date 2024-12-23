package com.destroystokyo.paper.event.entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Fired when an Entity decides to start moving towards a location.
 * <p>
 * This event does not fire for the entities actual movement. Only when it
 * is choosing to start moving to a location.
 */
@NullMarked
public class EntityPathfindEvent extends EntityEvent implements Cancellable {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final @Nullable Entity targetEntity;
    private final Location location;
    private boolean cancelled;

    @ApiStatus.Internal
    public EntityPathfindEvent(final Entity entity, final Location location, final @Nullable Entity targetEntity) {
        super(entity);
        this.targetEntity = targetEntity;
        this.location = location;
    }

    /**
     * The Entity that is pathfinding.
     *
     * @return The Entity that is pathfinding.
     */
    @Override
    public Entity getEntity() {
        return this.entity;
    }

    /**
     * If the Entity is trying to pathfind to an entity, this is the entity in relation.
     * <br>
     * Otherwise, this will return {@code null}.
     *
     * @return The entity target or {@code null}
     */
    public @Nullable Entity getTargetEntity() {
        return this.targetEntity;
    }

    /**
     * The Location of where the entity is about to move to.
     * <br>
     * Note that if the target happened to of been an entity
     *
     * @return Location of where the entity is trying to pathfind to.
     */
    public Location getLoc() {
        return this.location.clone();
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(final boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
