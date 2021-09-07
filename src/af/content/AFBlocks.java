package af.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.production.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import af.world.draw.*;
import af.world.blocks.power.*;

import static mindustry.type.ItemStack.*;

public class AFBlocks implements ContentList{
	public static Block
	
	//production
	coalCentripetal, plastaniumConstrict, phaseCoalescer, surgePurifier,
	
	//experimental
	neutroniumReactor, bananaReactor;
	
	@Override
	public void load(){
		
		//region crafting
		
		coalCentripetal = new GenericCrafter("coal-centripetal"){{
			requirements(Category.crafting, with(
				Items.lead, 70,
				Items.graphite, 100,
				Items.titanium, 50,
				Items.plastanium, 80
			));
			
			craftEffect = Fx.coalSmeltsmoke;
			outputItem = new ItemStack(Items.coal, 3);
			craftTime  = 27f;
			size = 3;
			hasPower = hasItems = hasLiquids = true;
			itemCapacity = 30;
			drawer = new DrawLiquidRotator(){{
				drawSpinSprite = true;
			}};
			
			consumes.liquid(Liquids.oil, 0.2f);
			consumes.power(2f);
		}};
		
		plastaniumConstrict = new GenericCrafter("plastanium-constrict"){{
			requirements(Category.crafting, with(
				Items.silicon, 120,
				Items.lead, 210,
				Items.graphite, 80,
				Items.plastanium, 100
			));
			
			hasItems = true;
			liquidCapacity = 120f;
			outputItem = new ItemStack(Items.plastanium, 2);
			size = 3;
			craftTime = 45f;
			health = 580;
			hasPower = hasLiquids = true;
			craftEffect = Fx.formsmoke;
			updateEffect = Fx.plasticburn;
			drawer = new DrawPiston();
			
			consumes.liquid(Liquids.oil, 0.4f);
			consumes.power(5.5f);
			consumes.item(Items.titanium, 4);
		}};
		
		phaseCoalescer = new GenericCrafter("phase-coalescer"){{
			requirements(Category.crafting, with(
				Items.silicon, 180,
				Items.lead, 150,
				Items.thorium, 90,
				Items.phaseFabric, 30
			));
			
			craftEffect = Fx.smeltsmoke;
			outputItem = new ItemStack(Items.phaseFabric, 6);
			craftTime = 180f;
			size = 4;
			hasPower = true;
			itemCapacity = 25;
			drawer = new DrawWeavePrinter();
			
			consumes.power(6f);
			consumes.items(with(
				Items.thorium, 8,
				Items.sand, 20
			));
		}};
		
		surgePurifier = new GenericCrafter("alloy-purifier"){{
			requirements(Category.crafting, with(
				Items.silicon, 180,
				Items.lead, 90,
				Items.thorium, 80,
				Items.metaglass, 40,
				Items.surgeAlloy, 25
			));
			
			craftEffect = AFFx.quadSmelt;
			outputItem = new ItemStack(Items.surgeAlloy, 4);
			craftTime = 60f;
			size = 4;
			hasPower = true;
			itemCapacity = 20;
			drawer = new DrawSmelter();
			
			consumes.power(5f);
			consumes.items(with(
				Items.copper, 5,
				Items.lead, 7,
				Items.titanium, 3,
				Items.silicon, 5
			));
			consumes.liquid(Liquids.slag, 0.2f);
		}};
		//region end
		
		//region experimental
		neutroniumReactor = new ExposedReactor("neutronium-reactor"){{
			requirements(Category.power, BuildVisibility.sandboxOnly, with());
			size = 7;
			health = 1300;
			powerProduction = 240f;
			itemDuration = 200f;
			
            consumes.power(25f);
            consumes.item(Items.copper);
            consumes.liquid(Liquids.water, 0.1f);
		}};
		
		bananaReactor = new ExposedReactor("banana-reactor"){{
			requirements(Category.power, BuildVisibility.sandboxOnly, with());
			size = 7;
			health = 1300;
			powerProduction = 60;
			itemDuration = 60f;
			
            consumes.power(25f);
            consumes.item(Items.phaseFabric);
            consumes.liquid(Liquids.water, 0.1f);
		}};
		//region end
		
	}
}