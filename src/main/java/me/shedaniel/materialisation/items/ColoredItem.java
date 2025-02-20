package me.shedaniel.materialisation.items;

import me.shedaniel.materialisation.Materialisation;
import me.shedaniel.materialisation.MaterialisationUtils;
import me.shedaniel.materialisation.ModReference;
import me.shedaniel.materialisation.api.PartMaterial;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ColoredItem extends Item {
    
    public ColoredItem(Settings item$Settings_1) {
        super(item$Settings_1);
        addPropertyGetter(new Identifier(ModReference.MOD_ID, "bright"), (itemStack, world, livingEntity) -> {
            return itemStack.getOrCreateTag().containsKey("mt_bright") ? 1f : 0f;
        });
    }
    
    public static UUID getItemModifierDamage() {
        return ATTACK_DAMAGE_MODIFIER_UUID;
    }
    
    public static UUID getItemModifierSwingSpeed() {
        return ATTACK_SPEED_MODIFIER_UUID;
    }
    
    @Environment(EnvType.CLIENT)
    public static Optional<String> getItemTranslationKey(ItemStack stack) {
        if (stack.getOrCreateTag().containsKey("mt_name_key")) {
            return Optional.ofNullable(stack.getOrCreateTag().getString("mt_name_key"));
        } else if (stack.getOrCreateTag().containsKey("mt_0_material")) {
            if (stack.getItem() == Materialisation.HANDLE)
                return Optional.ofNullable(I18n.translate("item.materialisation.materialised_handle", I18n.translate("material.materialisation." + stack.getOrCreateTag().getString("mt_0_material").replace(':', '.'))));
            if (stack.getItem() == Materialisation.PICKAXE_HEAD)
                return Optional.ofNullable(I18n.translate("item.materialisation.materialised_pickaxe_head", I18n.translate("material.materialisation." + stack.getOrCreateTag().getString("mt_0_material").replace(':', '.'))));
            if (stack.getItem() == Materialisation.AXE_HEAD)
                return Optional.ofNullable(I18n.translate("item.materialisation.materialised_axe_head", I18n.translate("material.materialisation." + stack.getOrCreateTag().getString("mt_0_material").replace(':', '.'))));
            if (stack.getItem() == Materialisation.SHOVEL_HEAD)
                return Optional.ofNullable(I18n.translate("item.materialisation.materialised_shovel_head", I18n.translate("material.materialisation." + stack.getOrCreateTag().getString("mt_0_material").replace(':', '.'))));
            if (stack.getItem() == Materialisation.SWORD_BLADE)
                return Optional.ofNullable(I18n.translate("item.materialisation.materialised_sword_blade", I18n.translate("material.materialisation." + stack.getOrCreateTag().getString("mt_0_material").replace(':', '.'))));
            if (stack.getItem() == Materialisation.HAMMER_HEAD)
                return Optional.ofNullable(I18n.translate("item.materialisation.materialised_hammer_head", I18n.translate("material.materialisation." + stack.getOrCreateTag().getString("mt_0_material").replace(':', '.'))));
            if (stack.getItem() == Materialisation.MEGAAXE_HEAD)
                return Optional.ofNullable(I18n.translate("item.materialisation.materialised_megaaxe_head", I18n.translate("material.materialisation." + stack.getOrCreateTag().getString("mt_0_material").replace(':', '.'))));
        } else if (stack.getOrCreateTag().containsKey("mt_material")) {
            if (stack.getItem() == Materialisation.HANDLE)
                return Optional.ofNullable(I18n.translate("item.materialisation.materialised_handle", I18n.translate("material.materialisation." + stack.getOrCreateTag().getString("mt_material").replace(':', '.'))));
            if (stack.getItem() == Materialisation.PICKAXE_HEAD)
                return Optional.ofNullable(I18n.translate("item.materialisation.materialised_pickaxe_head", I18n.translate("material.materialisation." + stack.getOrCreateTag().getString("mt_material").replace(':', '.'))));
            if (stack.getItem() == Materialisation.AXE_HEAD)
                return Optional.ofNullable(I18n.translate("item.materialisation.materialised_axe_head", I18n.translate("material.materialisation." + stack.getOrCreateTag().getString("mt_material").replace(':', '.'))));
            if (stack.getItem() == Materialisation.SHOVEL_HEAD)
                return Optional.ofNullable(I18n.translate("item.materialisation.materialised_shovel_head", I18n.translate("material.materialisation." + stack.getOrCreateTag().getString("mt_material").replace(':', '.'))));
            if (stack.getItem() == Materialisation.SWORD_BLADE)
                return Optional.ofNullable(I18n.translate("item.materialisation.materialised_sword_blade", I18n.translate("material.materialisation." + stack.getOrCreateTag().getString("mt_material").replace(':', '.'))));
            if (stack.getItem() == Materialisation.HAMMER_HEAD)
                return Optional.ofNullable(I18n.translate("item.materialisation.materialised_hammer_head", I18n.translate("material.materialisation." + stack.getOrCreateTag().getString("mt_material").replace(':', '.'))));
        }
        return Optional.empty();
    }
    
    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, World world_1, List<Text> list, TooltipContext tooltipContext_1) {
        super.appendTooltip(stack, world_1, list, tooltipContext_1);
        if (stack.getOrCreateTag().containsKey("mt_0_material")) {
            PartMaterial material = MaterialisationUtils.getMaterialFromPart(stack);
            if (material != null)
                if (stack.getItem() == Materialisation.HANDLE) {
                    list.add(new TranslatableText("text.materialisation.tool_handle_durability_multiplier", MaterialisationUtils.getColoring(material.getDurabilityMultiplier()).toString() + "x" + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getDurabilityMultiplier())));
                    list.add(new TranslatableText("text.materialisation.tool_handle_speed_multiplier", MaterialisationUtils.getColoring(material.getBreakingSpeedMultiplier()).toString() + "x" + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getBreakingSpeedMultiplier())));
                } else if (stack.getItem() == Materialisation.PICKAXE_HEAD || stack.getItem() == Materialisation.AXE_HEAD || stack.getItem() == Materialisation.SHOVEL_HEAD) {
                    list.add(new TranslatableText("text.materialisation.head_part_speed", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getToolSpeed())));
                    list.add(new TranslatableText("text.materialisation.head_part_durability", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getToolDurability())));
                    list.add(new TranslatableText("text.materialisation.head_part_damage", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(getExtraDamage(stack.getItem()) + material.getAttackDamage())));
                } else if (stack.getItem() == Materialisation.SWORD_BLADE) {
                    list.add(new TranslatableText("text.materialisation.head_part_durability", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getToolDurability())));
                    list.add(new TranslatableText("text.materialisation.head_part_damage", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(getExtraDamage(stack.getItem()) + material.getAttackDamage())));
                } else if (stack.getItem() == Materialisation.HAMMER_HEAD) {
                    list.add(new TranslatableText("text.materialisation.head_part_speed", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getToolSpeed() / 6f)));
                    list.add(new TranslatableText("text.materialisation.head_part_durability", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getToolDurability())));
                    list.add(new TranslatableText("text.materialisation.head_part_damage", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(getExtraDamage(stack.getItem()) + material.getAttackDamage())));
                } else if (stack.getItem() == Materialisation.MEGAAXE_HEAD) {
                    list.add(new TranslatableText("text.materialisation.head_part_speed", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getToolSpeed() / 6.5f)));
                    list.add(new TranslatableText("text.materialisation.head_part_durability", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getToolDurability())));
                    list.add(new TranslatableText("text.materialisation.head_part_damage", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(getExtraDamage(stack.getItem()) + material.getAttackDamage())));
                }
        } else if (stack.getOrCreateTag().containsKey("mt_material")) {
            PartMaterial material = MaterialisationUtils.getMaterialFromPart(stack);
            if (material != null)
                if (stack.getItem() == Materialisation.HANDLE) {
                    list.add(new TranslatableText("text.materialisation.tool_handle_durability_multiplier", MaterialisationUtils.getColoring(material.getDurabilityMultiplier()).toString() + "x" + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getDurabilityMultiplier())));
                    list.add(new TranslatableText("text.materialisation.tool_handle_speed_multiplier", MaterialisationUtils.getColoring(material.getBreakingSpeedMultiplier()).toString() + "x" + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getBreakingSpeedMultiplier())));
                } else if (stack.getItem() == Materialisation.PICKAXE_HEAD || stack.getItem() == Materialisation.AXE_HEAD || stack.getItem() == Materialisation.SHOVEL_HEAD) {
                    list.add(new TranslatableText("text.materialisation.head_part_speed", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getToolSpeed())));
                    list.add(new TranslatableText("text.materialisation.head_part_durability", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getToolDurability())));
                    list.add(new TranslatableText("text.materialisation.head_part_damage", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(getExtraDamage(stack.getItem()) + material.getAttackDamage())));
                } else if (stack.getItem() == Materialisation.SWORD_BLADE) {
                    list.add(new TranslatableText("text.materialisation.head_part_durability", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getToolDurability())));
                    list.add(new TranslatableText("text.materialisation.head_part_damage", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(getExtraDamage(stack.getItem()) + material.getAttackDamage())));
                } else if (stack.getItem() == Materialisation.HAMMER_HEAD) {
                    list.add(new TranslatableText("text.materialisation.head_part_speed", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getToolSpeed() / 6f)));
                    list.add(new TranslatableText("text.materialisation.head_part_durability", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(material.getToolDurability())));
                    list.add(new TranslatableText("text.materialisation.head_part_damage", Formatting.YELLOW.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(getExtraDamage(stack.getItem()) + material.getAttackDamage())));
                }
        }
    }
    
    public float getExtraDamage(Item item) {
        if (item == Materialisation.SWORD_BLADE)
            return 4f;
        if (item == Materialisation.PICKAXE_HEAD)
            return 2f;
        if (item == Materialisation.AXE_HEAD)
            return 7f;
        if (item == Materialisation.MEGAAXE_HEAD)
            return 10f;
        if (item == Materialisation.HAMMER_HEAD)
            return 9f;
        if (item == Materialisation.SHOVEL_HEAD)
            return 2.5f;
        return 0f;
    }
    
    @Override
    public Text getName(ItemStack itemStack_1) {
        return getItemTranslationKey(itemStack_1).map(s -> (Text) new TranslatableText(s)).orElse(super.getName(itemStack_1));
    }
    
}
