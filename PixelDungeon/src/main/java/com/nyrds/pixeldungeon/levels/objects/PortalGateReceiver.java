package com.nyrds.pixeldungeon.levels.objects;

import com.nyrds.pixeldungeon.windows.WndPortalReturn;
import com.watabou.pixeldungeon.actors.hero.Hero;
import com.watabou.pixeldungeon.items.Amulet;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.utils.GLog;

public class PortalGateReceiver extends PortalGate {

	@Override
	public boolean portalInteract(Hero hero) {
		if(!used && hero.belongings.getItem(Amulet.class) == null && hero.portalLevelPos != null){
			if(!animationRunning){
				if (!activated){
					playStartUpAnim();
				} else {
					GameScene.show(new WndPortalReturn(this, hero, hero.portalLevelPos));
				}
			}
		} else{
			GLog.w( TXT_USED );
		}
		return false;
	}
}
