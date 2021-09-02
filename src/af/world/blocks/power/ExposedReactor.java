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
	public TextureRegion bottomRegion, slider1, slider2, orb;
	
	public float minOrb = 2;
	public float orbSpeed = 1;
	public float orbScale = 4;
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
		orb = Core.atlas.find(name + "-orb");
	}
	
	public class ExposedReactorBuild extends ImpactReactorBuild{
		float totalProgress;
		
		@Override
		public void updateTile(){
			super.updateTile();
			totalProgress += warmup * delta()
		}
		
		@Override
		public void draw(){
			Draw.rect(bottomRegion, x, y);
			drawSliders();
			Draw.rect(region, x, y);
			
			Draw.alpha(warmup);
			Draw.rect(orb, x, y,
				(orb.height / 4) * warmup,
				Mathf.sin(totalProgress * orbSpeed * warmup, orbScale * Mathf.pi, (orb.height / 4) * warmup),
				totalProgress * orbSpeed * warmup
			);
			Draw.reset();
		}
		
		public void drawSliders(){
			float length = -(sliderLength * warmup);
            for(int i = 0; i < 4; i++){
                var reg = i >= 2 ? slider2 : slider1;
                float dx = Geometry.d4x[i] * length;
				float dy = Geometry.d4y[i] * length;
				
                Draw.rect(reg, x + dx, y + dy, i * 90);
            }
		}
	}
}