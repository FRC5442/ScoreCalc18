package frc.team5442.scorecalc2018;

import java.util.ArrayList;

public class PowerUps {

	private ArrayList<PowerUp> _powerUps;
	private boolean isScheduled;
	
	public PowerUps() {
		_powerUps = new ArrayList<>();
		isScheduled = false;
	}
	
	public void Add(PowerUp powerup) {
		_powerUps.add(powerup);
		isScheduled = false;
	}
	
	public PowerUp get_currentPowerUp(int tick) {
		if (!isScheduled)
			ScheduledPowerUps();
		return findActivePowerUp(tick);
	}
	
	private PowerUp findActivePowerUp(int tick) {
		for(PowerUp current: _powerUps) {
			if (current.get_tickStart() <= tick && current.get_tickEnd() > tick)
				return current;
		}
		return null;
	}
	
	private void ScheduledPowerUps() {
		int lastPowerUpEnd = 0;
		
		for (int tick = 1; tick <= 150; tick++ ) {
			PowerUp found = null;
			for(PowerUp current: _powerUps) {
				if (current.get_tickEvent() == tick)
					found = current;
			}
			if (found != null) {
				int start = found.get_tickEvent();
				if (lastPowerUpEnd > start)
					start = lastPowerUpEnd;
				found.set_tickStart(start);
				lastPowerUpEnd = found.get_tickEnd();
			}
		}
		
		isScheduled = true;
	}
}
