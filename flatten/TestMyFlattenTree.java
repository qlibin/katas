package flatten;

import java.util.Collections;
import java.util.List;

/**
 * @author qlibin@gmail.com
 *         Created on 1/24/15.
 */
public class TestMyFlattenTree {

	public static void main(String[] args) {

		FlattenTree<Integer> flattenTree = new MyFlattenTree<Integer>();

		Tree<Integer> tree = new Tree.Node<Integer>(
				Tree.Leaf.leaf(1),
//				new Tree.Node<Integer>(
//						Tree.Leaf.leaf(2),
						Tree.Node.tree(
								5,
								4,
								9
						),
//						null
//				),
				Tree.Leaf.leaf(6)
		);

/*
		Tree<Integer> tree = new Tree.Node<Integer>(
				Tree.Leaf.leaf(1),
				Tree.Node.tree(
						5,
						4,
						9
				),
				Tree.Leaf.leaf(6)
		);

*/
		List<Integer> leafs = flattenTree.flattenInOrder(tree);

		System.out.format("Leafs:\n");

		for (Integer leaf : leafs) {
			System.out.format(" %s ", leaf);
		}

	}

}
