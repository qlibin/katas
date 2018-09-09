import java.util.Arrays;

class HappenedBefore {

static volatile int sharedVar;

public static void main(String[] args) throws Exception {
  final long startTime = System.currentTimeMillis();
  final long[] aTimes = new long[5], bTimes = new long[5];
  final int[] aVals = new int[5], bVals = new int[5];
  final Thread
    a = new Thread() { public void run() {
      for (int i = 0; i < 5; i++) {
        aVals[i] = sharedVar++;
        aTimes[i] = System.currentTimeMillis()-startTime;
        briefPause();
      }
    }},
    b = new Thread() { public void run() {
      for (int i = 0; i < 5; i++) {
        bVals[i] = sharedVar++;
        bTimes[i] = System.currentTimeMillis()-startTime;
        briefPause();
      }
    }};
  a.start(); b.start();
  a.join(); b.join();
  System.out.format("Thread A read %s at %s\n",
      Arrays.toString(aVals), Arrays.toString(aTimes));
  System.out.format("Thread B read %s at %s\n",
      Arrays.toString(bVals), Arrays.toString(bTimes));
}

static void briefPause() {
  try { Thread.sleep(3); }
  catch (InterruptedException e) {throw new RuntimeException(e);}
}

}
