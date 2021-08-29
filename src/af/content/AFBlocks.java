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

import static mindustry.type.ItemStack.*;

public class AFBlocks implements ContentList{
	public static Block
	
	//production
	coalCentripetal, phaseCoalescer, surgePurifier;
	
	@Override
	public void load(){
		
		coalCentripetal = new GenericCrafter("coal-centripetal"){{
			requirements(Category.crafting, with(
				Items.lead, 70,
				Items.graphite, 100,
				Items.titanium, 50,
				Items.metaglass, 30
			));
			
			craftEffect = Fx.coalSmeltsmoke;
			outputItem = new ItemStack(Items.coal, 5);
			craftTime  = 45;
			size = 3;
			hasPower = hasItems = hasLiquids = true;
			itemCapacity = 30;
			drawer = new DrawLiquidRotator(){{
				drawSpinSprite = true;
			}};
			
			consumes.liquid(Liquids.oil, 0.16f);
			consumes.power(1.4f);
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
		
		//region crafting
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
		
	}
}