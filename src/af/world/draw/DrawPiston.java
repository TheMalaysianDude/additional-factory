package af.world.draw;

import arc.*;
import arc.util.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.draw.*;
import mindustry.world.blocks.production.GenericCrafter.*;

public class DrawPiston extends DrawBlock{
	public TextureRegion piston, heat;
	public Color heatColor = Pal.turretHeat;
	public int x = 2;
	public int y = 2;
	public float spacing = 8;
	
	@Override
	public void draw(GenericCrafterBuild build){
		
		Draw.rect(build.block.region, build.x, build.y);
		
		for(int dx = 0; dx < x; dx++){
			for(int dy = 0; dy < y; dy++){
				//((dx) - ((x - 1)/x) * (x/2)) * spacing
				float tx = (dx - ((x-1)/x)*(x/2)) * spacing;
				float ty = (dy - ((y-1)/y)*(y/2)) * spacing;
				
				//debug
				Log.info(tx + ", " + ty);
				
				Draw.rect(piston, build.x + tx, build.y + ty);
			}
		}
		
		if(heat.found()){
			Draw.color(heatColor, build.warmup);
			Draw.blend(Blending.additive);
			Draw.rect(heat, build.x, build.y);
			Draw.blend();
			Draw.color();
		}
	}
	
	@Override
	public void load(Block block){
		this.piston = Core.atlas.find(block.name + "-piston");
		this.heat = Core.atlas.find(block.name + "-heat");
	}
	
	@Override
	public TextureRegion[] icons(Block block){
		return new TextureRegion[]{block.region};
	}
}