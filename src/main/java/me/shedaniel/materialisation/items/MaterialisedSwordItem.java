package me.shedaniel.materialisation.items;

import me.shedaniel.materialisation.MaterialisationUtils;
import me.shedaniel.materialisation.ModReference;
import me.shedaniel.materialisation.api.PartMaterial;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.stat.Stats;
import net.minecraft.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

import static me.shedaniel.materialisation.MaterialisationUtils.isHandleBright;

public class MaterialisedSwordItem extends SwordItem implements MaterialisedMiningTool {
    
    public MaterialisedSwordItem(Settings settings) {
        super(MaterialisationUtils.DUMMY_MATERIAL, 0, -2.4F, settings.maxDamage(0));
        addPropertyGetter(new Identifier(ModReference.MOD_ID, "handle_isbright"), (itemStack, world, livingEntity) -> {
            return isHandleBright(itemStack) ? 1f : 0f;
        });
        addPropertyGetter(new Identifier(ModReference.MOD_ID, "handle_isnotbright"), (itemStack, world, livingEntity) -> {
            return !isHandleBright(itemStack) ? 1f : 0f;
        });
        addPropertyGetter(new Identifier(ModReference.MOD_ID, "sword_head_isbright"), (itemStack, world, livingEntity) -> {
            return isHeadBright(itemStack) ? 1f : 0f;
        });
        addPropertyGetter(new Identifier(ModReference.MOD_ID, "sword_head_isnotbright"), (itemStack, world, livingEntity) -> {
            return !isHeadBright(itemStack) ? 1f : 0f;
        });
    }
    
    public boolean isHeadBright(ItemStack itemStack) {
        if (itemStack.getOrCreateTag().containsKey("mt_sword_blade_bright"))
            return true;
        if (itemStack.getOrCreateTag().containsKey("mt_1_material"))
            return MaterialisationUtils.getMatFromString(itemStack.getOrCreateTag().getString("mt_1_material")).map(PartMaterial::isBright).orElse(false);
        return MaterialisationUtils.getMatFromString(itemStack.getOrCreateTag().getString("mt_sword_blade_material")).map(PartMaterial::isBright).orElse(false);
    }
    
    @Override
    public int getEnchantability(ItemStack stack) {
        if (!stack.getOrCreateTag().containsKey("mt_sword_blade_material") || !stack.getOrCreateTag().containsKey("mt_handle_material")) {
            if (!stack.getOrCreateTag().containsKey("mt_0_material") || !stack.getOrCreateTag().containsKey("mt_1_material"))
                return 0;
            PartMaterial handle = MaterialisationUtils.getMaterialFromString(stack.getOrCreateTag().getString("mt_0_material"));
            PartMaterial head = MaterialisationUtils.getMaterialFromString(stack.getOrCreateTag().getString("mt_1_material"));
            return (handle.getEnchantability() + head.getEnchantability()) / 2;
        }
        PartMaterial handle = MaterialisationUtils.getMaterialFromString(stack.getOrCreateTag().getString("mt_handle_material"));
        PartMaterial head = MaterialisationUtils.getMaterialFromString(stack.getOrCreateTag().getString("mt_sword_blade_material"));
        return (handle.getEnchantability() + head.getEnchantability()) / 2;
    }
    
    @Override
    public float getToolBlockBreakingSpeed(ItemStack stack, BlockState state) {
        Block block_1 = state.getBlock();
        if (block_1 == Blocks.COBWEB) {
            return 15.0F;
        } else {
            Material material_1 = state.getMaterial();
            return material_1 != Material.PLANT && material_1 != Material.REPLACEABLE_PLANT && material_1 != Material.UNUSED_PLANT && !state.matches(BlockTags.LEAVES) && material_1 != Material.PUMPKIN ? 1.0F : 1.5F;
        }
    }
    
    @Override
    public double getAttackSpeed() {
        return -2.4f;
    }
    
    @Override
    public boolean canEffectivelyBreak(ItemStack itemStack, BlockState state) {
        return state.getBlock() == Blocks.COBWEB;
    }
    
    @Override
    public boolean canRepair(ItemStack itemStack_1, ItemStack itemStack_2) {
        return false;
    }
    
    @Override
    public boolean postHit(ItemStack stack, LivingEntity livingEntity_1, LivingEntity livingEntity_2) {
        if (!livingEntity_1.world.isClient && (!(livingEntity_1 instanceof PlayerEntity) || !((PlayerEntity) livingEntity_1).abilities.creativeMode))
            if (MaterialisationUtils.getToolDurability(stack) > 0)
                if (MaterialisationUtils.applyDamage(stack, 1, livingEntity_1.getRand())) {
                    livingEntity_1.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
                    Item item_1 = stack.getItem();
                    stack.decrement(1);
                    if (livingEntity_1 instanceof PlayerEntity) {
                        ((PlayerEntity) livingEntity_1).incrementStat(Stats.BROKEN.getOrCreateStat(item_1));
                    }
                    MaterialisationUtils.setToolDurability(stack, 0);
                }
        return true;
    }
    
    @Override
    public boolean postMine(ItemStack stack, World world_1, BlockState blockState_1, BlockPos blockPos_1, LivingEntity livingEntity_1) {
        if (!world_1.isClient && blockState_1.getHardness(world_1, blockPos_1) != 0.0F)
            if (!livingEntity_1.world.isClient && (!(livingEntity_1 instanceof PlayerEntity) || !((PlayerEntity) livingEntity_1).abilities.creativeMode))
                if (MaterialisationUtils.getToolDurability(stack) > 0)
                    if (MaterialisationUtils.applyDamage(stack, 2, livingEntity_1.getRand())) {
                        livingEntity_1.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
                        Item item_1 = stack.getItem();
                        stack.decrement(1);
                        if (livingEntity_1 instanceof PlayerEntity) {
                            ((PlayerEntity) livingEntity_1).incrementStat(Stats.BROKEN.getOrCreateStat(item_1));
                        }
                        MaterialisationUtils.setToolDurability(stack, 0);
                    }
        return true;
    }
    
    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, World world_1, List<Text> list_1, TooltipContext tooltipContext_1) {
        int toolDurability = MaterialisationUtils.getToolDurability(stack);
        int maxDurability = MaterialisationUtils.getToolMaxDurability(stack);
        list_1.add(new TranslatableText("text.materialisation.max_durability", maxDurability));
        if (toolDurability > 0) {
            float percentage = toolDurability / (float) maxDurability * 100;
            Formatting coloringPercentage = MaterialisationUtils.getColoringPercentage(percentage);
            list_1.add(new TranslatableText("text.materialisation.durability", coloringPercentage.toString() + toolDurability, coloringPercentage.toString() + MaterialisationUtils.TWO_DECIMAL_FORMATTER.format(percentage) + Formatting.WHITE.toString()));
        } else
            list_1.add(new TranslatableText("text.materialisation.broken"));
    }
    
}
