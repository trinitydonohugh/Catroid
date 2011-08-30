/**
 *  Catroid: An on-device graphical programming language for Android devices
 *  Copyright (C) 2010  Catroid development team 
 *  (<http://code.google.com/p/catroid/wiki/Credits>)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package at.tugraz.ist.catroid.test.content.brick;

import android.test.AndroidTestCase;
import at.tugraz.ist.catroid.content.Sprite;
import at.tugraz.ist.catroid.content.bricks.ClearGraphicEffectBrick;

public class ClearGraphicEffectBrickTest extends AndroidTestCase {

	public void testClearGraphicEffect() {
		double value = 100.0;
		Sprite sprite = new Sprite("new sprite");
		sprite.setGhostEffectValue(value);
		assertEquals("Sprite has ghost effect.", value, sprite.getGhostEffectValue());
		sprite.setBrightnessValue(value);
		assertEquals("Sprite has ghost effect.", value, sprite.getGhostEffectValue());

		ClearGraphicEffectBrick clearGraphicEffectBrick = new ClearGraphicEffectBrick(sprite);
		clearGraphicEffectBrick.execute();
		assertEquals("Sprite's ghost effect is removed.", 0.0, sprite.getGhostEffectValue());
		assertEquals("Sprite's ghost effect is removed.", 0.0, sprite.getBrightnessValue());
	}

	public void testNullSprite() {
		ClearGraphicEffectBrick clearGraphicEffectBrick = new ClearGraphicEffectBrick(null);
		try {
			clearGraphicEffectBrick.execute();
			fail("Execution of ClearGraphicEffectBrick with null Sprite did not cause a NullPointerException to be thrown");
		} catch (NullPointerException expected) {
			// expected behavior
		}
	}
}