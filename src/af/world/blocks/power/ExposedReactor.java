package af.world.blocks.power;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
//import mindustry.annotations.Annotations.*;
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
	
	public @Load("@-bottom") TextureRegion bottomRegion;
	public @Load(value = "@-slider1", fallback = "clear-effect") TextureRegion slider1; 
	public @Load(value = "@-slider2", fallback = "clear-effect") TextureRegion slider2; 
	public float sliderLength = 14f/4f;
	
	public class ExposedReactorBuild extends ImpactReactor.ImpactReactorBuild{
		
		@Override
		public void draw(){
			Draw.rect(bottomRegion, x, y);
			drawSliders(warmup);
			Draw.rect(region, x, y);
		}
		
		public void drawSliders(float frame){
			float length = sliderLength * (frame - 1f) - 1f/4f;
            for(int i = 0; i < 4; i++){
                var reg = i >= 2 ? slider2 : slider1;
                float dx = Geometry.d4x[i] * length, dy = Geometry.d4y[i] * length;
                Draw.rect(reg, x + dx, y + dy, i * 90);
            }
		}
	}
}