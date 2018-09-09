package flatten;

import java.util.LinkedList;
import java.util.List;

/**
 * @author qlibin@gmail.com
 *         Created on 1/24/15.
 */
public class MyFlattenTree<T> implements FlattenTree<T> {

	@Override
	public List<T> flattenInOrder(Tree<T> tree) {

		if (tree == null)
			throw new IllegalArgumentException("The tree is null");

		final List<T> result = new LinkedList<T>();

		Function<T, T> getLeaf = new Function<T, T>() {
			@Override
			public T apply(T t) {
				return t;
			}
		};

		Function<Triple<Tree<T>>, Triple<Tree<T>>> getTriple = new Function<Triple<Tree<T>>, Triple<Tree<T>>>() {
			@Override
			public Triple<Tree<T>> apply(Triple<Tree<T>> treeTriple) {
				return treeTriple;
			}
		};

		final LinkedList<Tree<T>> stack = new LinkedList<Tree<T>>();
		stack.push(tree);

		while (!stack.isEmpty()) {

			Tree<T> currentNode = stack.pop();

			Either<T, Triple<Tree<T>>> either = currentNode.get();

			if (either.isLeft()) {
				T leaf = either.ifLeft(getLeaf);
				System.out.format("Leaf %s\n", leaf);
				result.add(leaf);
			} else {
				Triple<Tree<T>> triple = either.ifRight(getTriple);
				if (triple.right() != null) stack.push(triple.right());
				if (triple.middle() != null) stack.push(triple.middle());
				if (triple.left() != null) stack.push(triple.left());
			}

		}

		return result;
	}
}
