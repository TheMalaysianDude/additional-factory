package af.world.blocks.power;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.logic.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.power.*;
import af.content.*;

import static mindustry.Vars.*;

public class ExposedReactor extends ImpactReactor{
	public TextureRegion bottomRegion, slider1, slider2, heat, orb;
	public Color heatColor = Pal.turretHeat;
	
	public float minOrb = 2;
	public float scaleOrb = 4;
	public float magnitudeOrb = 4;
	public float sliderLength = 4;
	
	public ExposedReactor(String name){
		super(name);
	}
	
	@Override
	public void load(){
		super.load();
		bottomRegion = Core.atlas.find(name + "-bottom");
		slider1 = Core.atlas.find(name + "-slider1");
		slider2 = Core.atlas.find(name + "-slider2");
		heat = Core.atlas.find(name + "-heat");
		orb = Core.atlas.find(name + "-orb");
	}
	
	public class ExposedReactorBuild extends ImpactReactorBuild{
		
		@Override
		public void draw(){
			Draw.rect(bottomRegion, x, y);
			drawSliders();
			Draw.rect(region, x, y);
			
			if(heat.found()){
				Draw.color(heatColor, warmup);
				Draw.blend(Blending.additive);
				Draw.rect(heat, x, y);
				Draw.blend();
				Draw.color();
			}
			
			Draw.alpha(warmup);
			Draw.rect(orb, x, y, Time.time * warmup);
			Draw.reset();
		}
		
		public void drawSliders(){
			float length = sliderLength * warmup;
            for(int i = 0; i < 4; i++){
                var reg = i >= 2 ? slider2 : slider1;
                float dx = Geometry.d4x[i] * -length;
				float dy = Geometry.d4y[i] * -length;
				
                Draw.rect(reg, x + dx, y + dy, i * 90);
            }
		}
	}
}