import java.util.concurrent.*;

class LeftRightThreadStepper2 {

	private static final int STEP_COUNT = 5;

	private static ExecutorService executor = Executors.newCachedThreadPool();

	public static final void main(String[] args) throws InterruptedException {
		System.out.println("started");


                Thread t1 = new Thread(new Foot("left", STEP_COUNT, 600));
                Thread t2 = new Thread(new Foot("right", STEP_COUNT, 300));

		t1.start();
		t2.start();

		t1.join();
		t2.join();
                System.out.println("finished");

	}




	private static class Foot implements Runnable {
		
		private final String foot;
		private final int count, delay;

	        volatile private static String prevFoot;

		public Foot(String value, int count, int delay) {
			if (count < 0) throw new IllegalArgumentException("count must not be negative");
                        if (delay < 0) throw new IllegalArgumentException("delay must not be negative");

			this.count = count; this.delay = delay;
			foot = value;
		}

	        public void step() throws InterruptedException {

			synchronized (this) {	
        	        while (foot.equals(prevFoot)) {
				System.out.println("wait till lastStep not " + prevFoot);
                	        wait();
	                }
        	        System.out.println("Step " + foot);
                	prevFoot = foot;
	                notifyAll();
			}

        	}

		@Override
		public void run() {

			for (int i = 0; i < count; i++) {
				try {
					step();
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					System.out.println("interrupted");
				}
			}

		}
		
	}
	
}

