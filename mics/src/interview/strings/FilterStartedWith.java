package interview.strings;


/**
 * Created by alibin on 3/4/15.
 * You are given a list of strings
 
 /flapp/server/apache
 /d/apps
 /d/apps/pub
 /flapp
 /flocal/firms
 /d/sw/java
 /d/sw/orcl/jdbc
 
 
 The filtered strings shoud be
 /flapp
 /d/apps
 /d/sw/java
 /d/sw/orcl/jdbc
 /flocal/firms
 
 You have to identify the problem/requirement and provide solution that can work for any input with similar pattern.
 */
public class FilterStartedWith {

	public static void main(String[] args) {
		String[] strings = {
				"/flapp/server/apache",
				"/d/apps",
				"/d/apps/pub",
				"/flapp",
				"/flocal/firms",
				"/d/sw/java",
				"/d/sw/orcl/jdbc"
		};

		System.out.println("\ninput: ");
		for (String s : strings) {
			System.out.println("\t"+s);
		}

		String[] result = filter(strings);

		System.out.println("\nresult: ");
		for (String s : result) {
			if (s == null) break;
			System.out.println("\t"+s);
		}

	}

	private static String[] filter(String[] strings) {
		String[] result = new String[strings.length];
		int resultSize = 0;
		for (String str : strings) {
			if (!containsStartedWith(result, resultSize, str)) {
				resultSize++;
			}
		}
		if (resultSize < strings.length) {
			result[resultSize] = null;
		}
		return result;
	}

	private static boolean containsStartedWith(String[] result, int resultSize, String str) {
		for (int i = 0; i < resultSize; i++) {
			if (result[i].startsWith(str)) {
				result[i] = str;
				return true;
			}
			if (str.startsWith(result[i])) {
				return true;
			}
		}
		result[resultSize] = str;
		return false;
	}

}
