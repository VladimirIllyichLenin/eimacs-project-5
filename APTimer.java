package main;

public class APTimer {
	private long myStartTime, myEndTime;

	public APTimer() {
		myStartTime = 0;
		myEndTime = 0;
	}

	public void start() {
		myStartTime = System.currentTimeMillis();
	}

	public void stop() {
		myEndTime = System.currentTimeMillis();
	}

	public double interval() {
		return (double) (myEndTime - myStartTime);
	}

	public String toString() {
		return interval() + "";
	}
}
