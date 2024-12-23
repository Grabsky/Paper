package pl.firedot.paper.event;

import org.bukkit.block.Block;
import org.bukkit.block.data.type.Vault;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class VaultStateChangeEvent extends BlockEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean cancel;
    private final @NotNull Vault.State previousState;
    private final @NotNull Vault.State newState;

    @ApiStatus.Internal
    public VaultStateChangeEvent(final @NotNull Block theBlock, final @NotNull Vault.State previousState, final @NotNull Vault.State newState) {
        super(theBlock);
        this.previousState = previousState;
        this.newState = newState;
    }

    /**
     * Returns previous {@link Vault.State} of block involved in this event.
     *
     * @return the previous state
     */
    public @NotNull Vault.State getPreviousState() {
        return previousState;
    }

    /**
     * Returns the new {@link Vault.State} of block involved in this event.
     *
     * @return the new state
     */
    public @NotNull Vault.State getNewState() {
        return newState;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(final boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

}
