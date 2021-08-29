package af.world.draw;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.draw.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.production.GenericCrafter.*;

public class DrawLiquidRotator extends DrawBlock{
	public TextureRegion liquid, rotator, top;
	public boolean drawSpinSprite = false;
	
	@Override
	public void draw(GenericCrafterBuild build){
		GenericCrafter type = (GenericCrafter)build.block;
		float totalLiquids = build.liquids.total() / type.liquidCapacity;
		
		Draw.rect(build.block.region, build.x, build.y);
		
		Draw.color(build.liquids.current().color);
		Draw.rect(liquid, build.x, build.y, 
			(liquid.width/4) * totalLiquids,
			(liquid.height/4) * totalLiquids
		);
		Draw.color();
		
		if(drawSpinSprite){
			Drawf.spinSprite(rotator, build.x, build.y, build.totalProgress * 2);
		}else{
			Draw.rect(rotator, build.x, build.y, build.totalProgress * 2);
		}
		if(top.found()) Draw.rect(top, build.x, build.y);
	}
	
	@Override
	public void load(Block block){
		liquid = Core.atlas.find(block.name + "-liquid");
		rotator = Core.atlas.find(block.name + "-rotator");
		top = Core.atlas.find(block.name + "-top");
	}
	
	@Override
	public TextureRegion[] icons(Block block){
		return top.found() ? new TextureRegion[]{block.region, rotator, top} : new TextureRegion[]{block.region, rotator} ;
	}
}