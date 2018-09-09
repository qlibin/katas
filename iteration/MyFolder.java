package iteration;

import java.util.Iterator;
import java.util.Queue;

/**
 * @author qlibin@gmail.com
 *         Created on 1/23/15.
 */
public class MyFolder<T, U> implements Folder<T, U>
{
	public U fold(U u, Queue<T> ts, Function2<T, U, U> function)
	{
		if(u == null || ts == null || function == null)
			throw new IllegalArgumentException();

		if (ts.isEmpty()) {
			return u;
		}

		while (!ts.isEmpty()) {
			u = function.apply(ts.poll(), u);
		}
		return u;

		// unchangeable
//		for (T t : ts) {
//			u = function.apply(t, u);
//		}
//		return u;
//		return fold(function.apply(ts.poll(), u), ts, function);
	}
}
