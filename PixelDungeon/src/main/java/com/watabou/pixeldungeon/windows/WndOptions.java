/*
 * Pixel Dungeon
 * Copyright (C) 2012-2014  Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.watabou.pixeldungeon.windows;

import com.nyrds.android.util.GuiProperties;
import com.watabou.noosa.Text;
import com.watabou.pixeldungeon.scenes.PixelScene;
import com.watabou.pixeldungeon.ui.RedButton;
import com.watabou.pixeldungeon.ui.Window;

public class WndOptions extends Window {

	private static final int WIDTH         = 120;

	public WndOptions( String title, String message, String... options ) {
		super();
		
		Text tfTitle = PixelScene.createMultiline( title, GuiProperties.titleFontSize() );
		tfTitle.hardlight( TITLE_COLOR );
		tfTitle.x = tfTitle.y = GAP;
		tfTitle.maxWidth(WIDTH - GAP * 2);
		add( tfTitle );
		
		Text tfMesage = PixelScene.createMultiline( message, GuiProperties.regularFontSize() );
		tfMesage.maxWidth(WIDTH - GAP * 2);
		tfMesage.x = GAP;
		tfMesage.y = tfTitle.y + tfTitle.height() + GAP;
		add( tfMesage );
		
		float pos = tfMesage.y + tfMesage.height() + GAP;
		
		for (int i=0; i < options.length; i++) {
			final int index = i;
			RedButton btn = new RedButton( options[i] ) {
				@Override
				protected void onClick() {
					hide();
					onSelect( index );
				}
			};

			btn.setRect(GAP, pos, WIDTH - GAP * 2, BUTTON_HEIGHT );
			add( btn );
			
			pos += BUTTON_HEIGHT;
		}
		
		resize( WIDTH, (int)pos );
	}

	protected void onSelect( int index ) {}
}
