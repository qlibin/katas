package interview.concurrency;

/**
 * Created by alibin on 3/6/15.
 * Do thread join without join function
 */
public class ImplementThreadJoin {

	public static void main(String[] args) {

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				System.out.println("Runnable in thread");
			}
		});

		t.start();

		System.out.println("join");
/*
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
*/
		synchronized (t) {
			while (t.isAlive()) {
				System.out.println("wait");
				try {
					t.wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}

		System.out.println("done");

		System.exit(0);

	}

}
