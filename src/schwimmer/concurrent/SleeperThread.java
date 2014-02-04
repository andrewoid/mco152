package schwimmer.concurrent;

public class SleeperThread extends Thread {

	private int seconds;

	public SleeperThread(int seconds) {
		this.seconds = seconds;
	}

	@Override
	public void run() {
		try {
			System.out.println("Going to Sleep for " + seconds + " seconds");
			Thread.sleep(seconds * 1000);
			System.out.println("Awake after sleeping for " + seconds
					+ " seconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
