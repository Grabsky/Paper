package org.bukkit.craftbukkit.inventory;

import com.google.common.base.Joiner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffectType;
import org.junit.jupiter.params.provider.Arguments;

public class ItemStackPotionsTest extends ItemStackTest {

    public static Stream<Arguments> data() {
        return StackProvider.compound(ItemStackPotionsTest.operators(), "%s %s", NAME_PARAMETER, Material.POTION);
    }

    @SuppressWarnings("unchecked")
    static List<Object[]> operators() {
        return CompoundOperator.compound(
            Joiner.on('+'),
            NAME_PARAMETER,
            Long.parseLong("10", 2),
            ItemStackLoreEnchantmentTest.operators(),
            Arrays.asList(
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            final PotionMeta meta = (PotionMeta) cleanStack.getItemMeta();
                            meta.addCustomEffect(PotionEffectType.NAUSEA.createEffect(1, 1), false);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            return cleanStack;
                        }
                    },
                    "Potion vs Null"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            final PotionMeta meta = (PotionMeta) cleanStack.getItemMeta();
                            meta.addCustomEffect(PotionEffectType.INSTANT_DAMAGE.createEffect(2, 1), false);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            final PotionMeta meta = (PotionMeta) cleanStack.getItemMeta();
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Potion vs Blank"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            final PotionMeta meta = (PotionMeta) cleanStack.getItemMeta();
                            meta.addCustomEffect(PotionEffectType.MINING_FATIGUE.createEffect(1, 1), false);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            final PotionMeta meta = (PotionMeta) cleanStack.getItemMeta();
                            meta.addCustomEffect(PotionEffectType.HASTE.createEffect(1, 1), false);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Potion vs Harder"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            final PotionMeta meta = (PotionMeta) cleanStack.getItemMeta();
                            meta.addCustomEffect(PotionEffectType.JUMP_BOOST.createEffect(1, 1), false);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            final PotionMeta meta = (PotionMeta) cleanStack.getItemMeta();
                            meta.addCustomEffect(PotionEffectType.JUMP_BOOST.createEffect(1, 1), false);
                            meta.addCustomEffect(PotionEffectType.REGENERATION.createEffect(1, 1), false);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Potion vs Better"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            final PotionMeta meta = (PotionMeta) cleanStack.getItemMeta();
                            meta.addCustomEffect(PotionEffectType.SPEED.createEffect(10, 1), false);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            final PotionMeta meta = (PotionMeta) cleanStack.getItemMeta();
                            meta.addCustomEffect(PotionEffectType.SPEED.createEffect(5, 1), false);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Potion vs Faster"
                },
                new Object[] {
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            final PotionMeta meta = (PotionMeta) cleanStack.getItemMeta();
                            meta.addCustomEffect(PotionEffectType.STRENGTH.createEffect(1, 1), false);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    new Operator() {
                        @Override
                        public ItemStack operate(ItemStack cleanStack) {
                            final PotionMeta meta = (PotionMeta) cleanStack.getItemMeta();
                            meta.addCustomEffect(PotionEffectType.STRENGTH.createEffect(1, 2), false);
                            cleanStack.setItemMeta(meta);
                            return cleanStack;
                        }
                    },
                    "Potion vs Stronger"
                }
            )
        );
    }
}
