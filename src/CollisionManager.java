import java.util.ArrayList;

public class CollisionManager {

	/**
	 * check to see which mobs are touching to see if they die
	 */
	public void checkKillMobCollision(ArrayList<Mob> mobsToDraw, ArrayList<Bullet> bullets, Hero hero) {
		ArrayList<Mob> mobsToDelete = new ArrayList<Mob>();
		for (int i = 0; i < mobsToDraw.size(); i++) {
			Mob thisMob = mobsToDraw.get(i);

			if (this.mobCollision(thisMob, hero) && !thisMob.equals(hero)) {

				mobsToDelete.add(thisMob);
				thisMob.collidedWithHero();

			}
		}
		this.killDeadMobs(mobsToDraw);
		// some mobs that have multiple requirements for death will be marked not dead
		// when calling collide with hero,
		// so a kill function is used

	}

	private boolean mobCollision(Mob mob1, Mob mob2) {
		return mob1.getBounds().intersects(mob2.getBounds());
	}

	/**
	 * Handles actions having to do with the death of mobs, removing them if hasDied
	 * is true
	 */
	public void killDeadMobs(ArrayList<Mob> mobsToDraw) {
		ArrayList<Mob> mobsToDelete = new ArrayList<Mob>();
		for (int i = 0; i < mobsToDraw.size(); i++) {
			if ((mobsToDraw.get(i)).getHasDied()) {
				mobsToDelete.add(mobsToDraw.get(i));
			}
		}
		for (int i = 0; i < mobsToDelete.size(); i++) {

			for (int j = 0; j < mobsToDraw.size(); j++) { // bullets have to be deleted in two places

				if (mobsToDelete.get(i).equals(mobsToDraw.get(j))) {
					(mobsToDraw.get(j)).kill(); // nested in case kill changes into an egg which has another
												// life
					if (mobsToDelete.get(i).getHasDied()) {
						mobsToDraw.remove(j);
					}

				}
			}
		}
	}

	/**
	 * Check for a collision between a mob and a solid tile
	 * 
	 * @param mob
	 * @param tile
	 * @return
	 */

	public boolean collision(Mob mob, Tile tile) {
		return mob.getBounds().intersects(tile.getBounds());
	}


}
