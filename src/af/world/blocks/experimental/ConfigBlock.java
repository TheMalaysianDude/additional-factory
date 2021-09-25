package af.world.blocks.experimental;

import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.consumers.*;

import static mindustry.Vars.*;

public class ConfigBlock extends Block{
	
	public ConfigBlock(String name){
		super(name);
        configurable = true;
        solid = true;
        destructible = true;
        group = BlockGroup.logic;
        drawDisabled = false;
		
		config(Boolean.class,
		(ConfigBlockBuild entity, Boolean b) -> 
			entity.enabled = b;
		);
	}
	
	public class ConfigBlockBuild extends Block{
		@Override
		public draw(){
			super.draw();
			
			if(enabled){
				Draw.rect(onRegion, x, y);
			}
		}
		
		@Override
		public boolean configTapped(){
			configure(!enabled);
			Sounds.click.at(this);
			return false;
		}
		
		@Override
		public Boolean config(){
			return true;
		}
		
		@Override
		public void readAll(Reads read, byte revision){
			super.readAll(read, revision);
			
			if(revision == 1){
				enabled = read.bool();
			}
		}
		
		@Override
		public void write(Writes write){
			super.write(write);
			
			write.bool(enabled);
		}
	}
}
