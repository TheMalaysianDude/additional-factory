package af.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import mindustry.entities.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class AFFx{
	private static final Rand rand = new Rand();
	
	public static final Effect
	
	quadSmelt = new Effect(30f, e -> {
		
		for(int i = 0; i < 4; i++){
			float rotation = (i * 90f) + 45f;
			float tx = e.x + trnsx(rotation, 8f);
			float ty = e.y + trnsy(rotation, 8f);
			
			color(Color.valueOf("ffc999"));
			Drawf.tri(
				tx,
				ty,
				4.8f * e.fout(), 
				15f * e.finpow(),
				rotation
			);
			Fill.circle(tx, ty, 2.7f * e.fout());
			
			color(Color.white);
			Drawf.tri(
				tx,
				ty,
				3f * e.fout(), 
				10f * e.finpow(),
				rotation
			);
			Fill.circle(tx, ty, 1.7f * e.fout());
		}
	}),
	
	printing = new Effect(15f, e -> {
		
		randLenVectors(e.id, 4, 2f + e.fin() * 2f, (x, y) -> {
			color(Color.white, e.color, e.fin());
			Fill.square(e.x + x, e.y + y, 0.5f + e.fout() * 2f, 45);
		});
		
	});
}