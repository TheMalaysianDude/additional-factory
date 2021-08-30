package af.world.draw;

import arc.*;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.draw.*;
import mindustry.world.blocks.production.GenericCrafter.*;

public class DrawPiston extends DrawBlock{
	public TextureRegion piston, heat;
	public int x = 2;
	public int y = 2;
	public float spacing = 4;
	
	@Override
	public void draw(GenericCrafterBuild build){
		
		Draw.rect(build.block.region, build.x, build.y);
		
		for(int dx = 1; dx <= x; dx++){
			for(int dy = 1; dy <= y; dy++){
				float tx = (dx/2 * spacing) - (spacing * x);
				float ty = (dy/2 * spacing) - (spacing * y);
				
				Draw.rect(piston, build.x + tx, build.y + ty);
			}
		}
		
		if(heat.found()){
			Draw.color(heatColor, tile.heat);
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