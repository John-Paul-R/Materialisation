package me.shedaniel.materialisation.materials;

import com.google.common.collect.Lists;
import me.shedaniel.materialisation.api.GeneratedMaterial;
import me.shedaniel.materialisation.api.PartMaterial;

import java.util.List;

import static me.shedaniel.materialisation.api.BetterIngredient.fromTag;
import static me.shedaniel.materialisation.api.PartMaterials.getNewMaterial;
import static net.minecraft.util.Identifier.tryParse;

public class CottonResourcesMaterialsGetter {
    
    public static List<PartMaterial> get() {
        List<PartMaterial> materials = Lists.newArrayList();
        materials.add(newMat("copper").wEnch(12).aIngr(fromTag(tryParse("c:copper_ingot")), 2).aIngr(fromTag(tryParse("c:copper_block")), 18).wAtta(1).wFull(100).wSpeed(5.3f).wDuraMulti(1.05f).wSpeedMulti(1f).setBright(true).wColor(0xffffa21f).setToolDurability(275).setMiningLevel(1));
        materials.add(newMat("silver").wEnch(16).aIngr(fromTag(tryParse("c:silver_ingot")), 2).aIngr(fromTag(tryParse("c:silver_block")), 18).wAtta(3).wFull(100).wSpeed(5f).wDuraMulti(.9f).wSpeedMulti(1f).setBright(true).wColor(0xff9387ff).setToolDurability(325).setMiningLevel(1));
        materials.add(newMat("lead").wEnch(16).aIngr(fromTag(tryParse("c:lead_ingot")), 2).aIngr(fromTag(tryParse("c:lead_block")), 18).wAtta(1.5f).wFull(100).wSpeed(5.25f).wDuraMulti(.7f).wSpeedMulti(.6f).setBright(false).wColor(0xffaf96cc).setToolDurability(375).setMiningLevel(1));
        materials.add(newMat("zinc").wEnch(16).aIngr(fromTag(tryParse("c:zinc_ingot")), 2).aIngr(fromTag(tryParse("c:zinc_block")), 18).wAtta(1).wFull(100).wSpeed(4.75f).wDuraMulti(.8f).wSpeedMulti(.5f).setBright(true).wColor(0xffd1fff7).setToolDurability(200).setMiningLevel(1));
        materials.add(newMat("aluminum").wEnch(16).aIngr(fromTag(tryParse("c:aluminum_ingot")), 2).aIngr(fromTag(tryParse("c:aluminum_block")), 18).wAtta(2).wFull(100).wSpeed(5f).wDuraMulti(.85f).wSpeedMulti(1.3f).setBright(true).wColor(0xfff7b2d6).setToolDurability(300).setMiningLevel(1));
        materials.add(newMat("cobalt").wEnch(16).aIngr(fromTag(tryParse("c:cobalt_ingot")), 2).aIngr(fromTag(tryParse("c:cobalt_block")), 18).wAtta(4).wFull(200).wSpeed(12).wDuraMulti(1.1f).wSpeedMulti(1f).setBright(false).wColor(0xff172fd1).setToolDurability(800).setMiningLevel(3));
        materials.add(newMat("tin").wEnch(16).aIngr(fromTag(tryParse("c:tin_ingot")), 2).aIngr(fromTag(tryParse("c:tin_block")), 18).wAtta(2).wFull(100).wSpeed(5.1f).wDuraMulti(.9f).wSpeedMulti(1.1f).setBright(true).wColor(0xff63aeff).setToolDurability(290).setMiningLevel(1));
        materials.add(newMat("titanium").wEnch(16).aIngr(fromTag(tryParse("c:titanium_ingot")), 2).aIngr(fromTag(tryParse("c:titanium_block")), 18).wAtta(2.7f).wFull(150).wSpeed(7).wDuraMulti(.9f).wSpeedMulti(1).setBright(true).wColor(0xff777777).setToolDurability(600).setMiningLevel(2));
        materials.add(newMat("tungsten").wEnch(16).aIngr(fromTag(tryParse("c:tungsten_ingot")), 2).aIngr(fromTag(tryParse("c:tungsten_block")), 18).wAtta(3).wFull(175).wSpeed(8).wDuraMulti(1).wSpeedMulti(1).setBright(true).wColor(0xff2f2d44).setToolDurability(700).setMiningLevel(3));
        materials.add(newMat("platinum").wEnch(16).aIngr(fromTag(tryParse("c:platinum_ingot")), 2).aIngr(fromTag(tryParse("c:platinum_block")), 18).wAtta(2).wFull(50).wSpeed(10).wDuraMulti(.5f).wSpeedMulti(.7f).setBright(true).wColor(0xffffffff).setToolDurability(150).setMiningLevel(2));
        materials.add(newMat("palladium").wEnch(16).aIngr(fromTag(tryParse("c:palladium_ingot")), 2).aIngr(fromTag(tryParse("c:palladium_block")), 18).wAtta(3.5f).wFull(25).wSpeed(16).wDuraMulti(.4f).wSpeedMulti(.3f).setBright(true).wColor(0xffe1b4e8).setToolDurability(100).setMiningLevel(3));
        materials.add(newMat("osmium").wEnch(16).aIngr(fromTag(tryParse("c:osmium_ingot")), 2).aIngr(fromTag(tryParse("c:osmium_block")), 18).wAtta(2).wFull(125).wSpeed(4.25f).wDuraMulti(1.1f).wSpeedMulti(1).setBright(true).wColor(0xffc2dfed).setToolDurability(500).setMiningLevel(2));
        materials.add(newMat("iridium").wEnch(16).aIngr(fromTag(tryParse("c:iridium_ingot")), 2).aIngr(fromTag(tryParse("c:iridium_block")), 18).wAtta(5).wFull(150).wSpeed(6.5f).wDuraMulti(.9f).wSpeedMulti(1.2f).setBright(true).wColor(0xffb0f2b7).setToolDurability(600).setMiningLevel(3));
        materials.add(newMat("steel").wEnch(16).aIngr(fromTag(tryParse("c:steel_ingot")), 2).aIngr(fromTag(tryParse("c:steel_block")), 18).wAtta(3).wFull(150).wSpeed(8).wDuraMulti(1.1f).wSpeedMulti(.8f).setBright(false).wColor(0xff777777).setToolDurability(600).setMiningLevel(2));
        materials.add(newMat("brass").wEnch(16).aIngr(fromTag(tryParse("c:brass_ingot")), 2).aIngr(fromTag(tryParse("c:brass_block")), 18).wAtta(2.5f).wFull(100).wSpeed(5.5f).wDuraMulti(.9f).wSpeedMulti(1.1f).setBright(true).wColor(0xffffd000).setToolDurability(400).setMiningLevel(2));
        materials.add(newMat("electrum").wEnch(16).aIngr(fromTag(tryParse("c:electrum_ingot")), 2).aIngr(fromTag(tryParse("c:electrum_block")), 18).wAtta(3).wFull(110).wSpeed(6).wDuraMulti(.9f).wSpeedMulti(1f).setBright(true).wColor(0xffead470).setToolDurability(440).setMiningLevel(2));
        materials.add(newMat("mercury").wEnch(16).aIngr(fromTag(tryParse("c:mercury")), 2).wAtta(0).wFull(13).wSpeed(2).wDuraMulti(.1f).wSpeedMulti(.13f).setBright(false).wColor(0xffff0000).setToolDurability(50).setMiningLevel(0));
        return materials;
    }
    
    private static GeneratedMaterial newMat(String s) {
        return getNewMaterial("cotton-resources:" + s);
    }
    
}
