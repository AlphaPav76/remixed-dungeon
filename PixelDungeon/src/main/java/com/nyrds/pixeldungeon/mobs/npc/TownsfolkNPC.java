package com.nyrds.pixeldungeon.mobs.npc;

import com.nyrds.pixeldungeon.ml.R;
import com.watabou.noosa.Game;
import com.watabou.pixeldungeon.actors.hero.Hero;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.windows.WndQuest;
import com.watabou.utils.Random;

public class TownsfolkNPC extends ImmortalNPC {

	public TownsfolkNPC() {
	}

	@Override
	public boolean interact(final Hero hero) {
		getSprite().turnTo( getPos(), hero.getPos() );

		final String TXT_MESSAGE1 = Game.getVar(R.string.TownsfolkNPC_Message1);
		final String TXT_MESSAGE2 = Game.getVar(R.string.TownsfolkNPC_Message2);
		final String TXT_MESSAGE3 = Game.getVar(R.string.TownsfolkNPC_Message3);
		final String TXT_MESSAGE4 = Game.getVar(R.string.TownsfolkNPC_Message4);

		final String[] TXT_PHRASES = {TXT_MESSAGE1, TXT_MESSAGE2, TXT_MESSAGE3, TXT_MESSAGE4};


		int index = Random.Int(0, TXT_PHRASES.length);
		GameScene.show(new WndQuest(this, TXT_PHRASES[index]));
		return true;
	}
}


