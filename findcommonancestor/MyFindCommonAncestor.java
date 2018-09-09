package findcommonancestor;

import java.util.*;

public class MyFindCommonAncestor implements FindCommonAncestor
{
	public String findCommonAncestor(String[] commitHashes,
									 String[][] parentHashes, String commitHash1, String commitHash2)
	{

		if (commitHash1 == null || commitHash2 == null || commitHashes == null || parentHashes == null)
			throw new IllegalArgumentException("All arguments must be not null values");

		if (commitHashes.length == 0 || parentHashes.length == 0)
			throw new IllegalArgumentException("Empty hash arrays");

		if (commitHashes.length != parentHashes.length)
			throw new IllegalArgumentException("Arrays length not must be equal");

		if (commitHash1.equals(commitHash2) && commitHash2.equals(commitHashes[commitHashes.length - 1]))
			//throw new IllegalArgumentException("Commit hashes are the same root element which doesn't have ancestors");
			return null;

		Set<String> pathHeads1 = new HashSet<String>();
		Set<String> pathHeads2 = new HashSet<String>();
		pathHeads1.add(commitHash1);
		pathHeads2.add(commitHash2);

		for (int i = 0; i < commitHashes.length; i++) {
			if (pathHeads1.remove(commitHashes[i])) {
				for (int j = 0; j < parentHashes[i].length; j++) {
					String s = parentHashes[i][j];
					if (pathHeads2.contains(s))
						return s;
					pathHeads1.add(s);
				}
			}
			if (pathHeads2.remove(commitHashes[i])) {
				for (int j = 0; j < parentHashes[i].length; j++) {
					String s = parentHashes[i][j];
					if (pathHeads1.contains(s))
						return s;
					pathHeads2.add(s);
				}
			}
		}

		throw new IllegalStateException("Incorrect input data");
	}


}
