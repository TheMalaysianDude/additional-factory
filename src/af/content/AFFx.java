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
	
	printing = new Effect(15f, b -> {
		float intensity = b.rotation;
        float baseLifetime = 26f + intensity * 15f;
        b.lifetime = 43f + intensity * 35f;
		
        b.scaled(baseLifetime, e -> {
			
            color(Pal.lighterOrange, Pal.lightOrange, Color.gray, e.fin());
            stroke((1.7f * e.fout()) * (1f + (intensity - 1f) / 2f));

            Draw.z(Layer.effect + 0.001f);
            randLenVectors(e.id + 1, e.finpow() + 0.001f, (int)(9 * intensity), 40f * intensity, (x, y, in, out) -> {
                lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + out * 4 * (3f + intensity));
                Drawf.light(e.x + x, e.y + y, (out * 4 * (3f + intensity)) * 3.5f, Draw.getColor(), 0.8f);
            });
        });
		
	});
}