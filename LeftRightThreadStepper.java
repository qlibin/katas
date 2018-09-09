import java.util.concurrent.*;

class LeftRightThreadStepper {

	private static final int STEP_COUNT = 5;

	private static ExecutorService executor = Executors.newCachedThreadPool();

	public static final void main(String[] args) throws InterruptedException {
		System.out.println("started");

		LeftRightThreadStepper stepper = new LeftRightThreadStepper();

                Thread t1 = new Thread(new Foot(stepper, "left", STEP_COUNT, 600));
                Thread t2 = new Thread(new Foot(stepper, "right", STEP_COUNT, 300));

		t1.start();
		t2.start();

		t1.join();
		t2.join();
                System.out.println("finished");

	}

	volatile private static String prevFoot;

	synchronized public void step(String foot) throws InterruptedException {

		while (foot.equals(prevFoot)) {
			wait();
		}
		System.out.println("Step " + foot);
		prevFoot = foot;
		notifyAll();

	}



	private static class Foot implements Runnable {
		
		private final String foot;
		private final LeftRightThreadStepper stepper;
		private final int count, delay;


		public Foot(LeftRightThreadStepper stepper, String value, int count, int delay) {
			if (count < 0) throw new IllegalArgumentException("count must not be negative");
                        if (delay < 0) throw new IllegalArgumentException("delay must not be negative");

			this.stepper = stepper;
			this.count = count; this.delay = delay;
			foot = value;
		}

		@Override
		public void run() {

			for (int i = 0; i < count; i++) {
				try {
					stepper.step(foot);
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					System.out.println("interrupted");
				}
			}

		}
		
	}
	
}

