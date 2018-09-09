package interview.patterns;

/**
 * Created by alibin on 3/4/15.
 *
 */
public enum SingletonEnum {

	INSTANCE(1);

	private int i;

	SingletonEnum(int i) {
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
