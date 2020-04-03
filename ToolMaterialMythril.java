package net.obsidia;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ToolMaterialMythril implements ToolMaterial {

@Override
public int getDurability() {
        return 0;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 12.0f;
    }

    @Override
    public float getAttackDamage() {
        return 5f;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Obsidia.end_diamond);
    }
}