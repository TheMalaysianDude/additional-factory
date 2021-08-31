package af.world.draw;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import mindustry.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.draw.*;
import mindustry.world.blocks.production.GenericCrafter.*;
import af.content.*;

public class DrawWeavePrinter extends DrawBlock{
	public TextureRegion weave, bottom, slider, pointer, printer;
	public Color printColor = Pal.accent;
	public float percentageRadius = 40; // percentage/100 * block.size
	public float xWave = 3;
	public float yWave = 2;
	
	@Override
	public void draw(GenericCrafterBuild build){
		float rotation = 360f * build.progress;
		
		float tx = build.x + Mathf.sin(build.progress * (xWave * 2) * Mathf.pi) * (Vars.tilesize * (percentageRadius / 100 * build.block.size) / 2);
		float ty = build.y + Mathf.sin(build.progress * (yWave * 2) * Mathf.pi) * (Vars.tilesize * (percentageRadius / 100 * build.block.size) / 2);
		
		Draw.rect(bottom, build.x, build.y);
		
		Draw.alpha(build.progress);
		Draw.rect(weave, build.x, build.y);
		
		Draw.reset();
		Draw.rect(build.block.region, build.x, build.y);
		Draw.rect(slider, build.x, ty);
		Draw.rect(pointer, tx, ty);
		Draw.alpha(build.warmup);
		Draw.rect(printer, tx, ty, rotation);
		Draw.reset();
		
		AFFx.printing.at(tx, ty, 0, printColor, build);
	}
	
	@Override
	public void load(Block block){
		weave = Core.atlas.find(block.name + "-weave");
		bottom = Core.atlas.find(block.name + "-bottom");
		slider = Core.atlas.find(block.name + "-slider");
		pointer = Core.atlas.find(block.name + "-pointer");
		printer = Core.atlas.find(block.name + "-printer");
	}
	
	@Override
	public TextureRegion[] icons(Block block){
		return new TextureRegion[]{bottom, slider, block.region, pointer, printer};
	}
}