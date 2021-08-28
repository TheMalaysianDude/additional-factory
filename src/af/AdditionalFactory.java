package af;

import arc.*;
import arc.func.*;
import arc.util.*;
import mindustry.ctype.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import af.content.*;

public class AdditionalFactory extends Mod {
	
	private final ContentList[] afContent = {
		new AFBlocks(),
		new AFTechTree()
	};
	
	@Override
    public void loadContent(){
        for(ContentList list : afContent){
            list.load();

            //Log.info("@: Loaded content list: @", getClass().getSimpleName(), list.getClass().getSimpleName());
        }
    }
	

}