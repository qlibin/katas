package interview.graph.traverse;

import java.util.*;

/**
 * Created by alibin on 3/3/15.
 *
 * The SHIELD is a secretive organization entrusted with the task of guarding the world against any disaster.
 * Their arch nemesis is the organization called HYDRA.
 * Unfortunately some members from HYDRA had infiltrated into the SHIELD camp.
 * SHIELD needed to find out all these infiltrators to ensure  that it was not compromised.
 *
 * Nick Fury, the executive director and the prime SHIELD member figured out
 * that every one in SHIELD could send a SOS signal to every other SHIELD member he knew well.
 * The HYDRA members could send bogus SOS messages  to others to confuse others,
 * but they could never receive a SOS message from a SHIELD member.
 * Every SHIELD member would receive a SOS message ateast one other SHIELD member,
 * who in turn would have received from another SHIELD member and so on till NickFury.
 * SHIELD had a sophisticated mechanism to  capture who sent a SOS signal to whom.
 * Given this information, Nick needed someone to write a program
 * that could look into this data and figure out all HYDRA members.
 *
 * Sample Input
 * Nick Fury : Tony Stark, Maria Hill, Norman Osborn
 * Hulk : Tony Stark, HawkEye, Rogers
 * Rogers : Thor,
 * Tony Stark: Pepper Potts, Nick Fury
 * Agent 13 : Agent-X, Nick Fury, Hitler
 * Thor: HawkEye, BlackWidow
 * BlackWidow:Hawkeye
 * Maria Hill : Hulk, Rogers, Nick Fury
 * Agent-X : Agent 13, Rogers
 * Norman Osborn: Tony Stark, Thor
 *
 * Sample Output
 * Agent 13, Agent-X, Hitler
 *
 *
 * You can code in any language of your choice. Input and Output must be in the same format as above
 */
public class FindUnreachableNodes {




	public static void main(String[] args) {

		HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
		graph.put("Nick Fury", Arrays.asList("Tony Stark", "Maria Hill", "Norman Osborn"));
		graph.put("Hulk", Arrays.asList("Tony Stark", "Hawk Eye", "Rogers"));
		graph.put("Rogers", Collections.singletonList("Thor"));
		graph.put("Tony Stark", Arrays.asList("Pepper Potts", "Nick Fury"));
		graph.put("Pepper Potts", Collections.EMPTY_LIST);
		graph.put("Agent 13", Arrays.asList("Agent-X", "Nick Fury", "Hitler"));
		graph.put("Thor", Arrays.asList("Hawk Eye", "Black Widow"));
		graph.put("Black Widow", Collections.singletonList("Hawk Eye"));
		graph.put("Maria Hill", Arrays.asList("Hulk", "Rogers", "Nick Fury"));
		graph.put("Agent-X", Arrays.asList("Agent 13", "Rogers"));
		graph.put("Norman Osborn", Arrays.asList("Tony Stark", "Thor"));
		graph.put("Hitler", Collections.EMPTY_LIST);

		System.out.println("\nInput");
		for (String node : graph.keySet()) {
			System.out.println(node + ": " + graph.get(node));
		}

		Collection<String> result = findHydras("Nick Fury", graph);

		System.out.println("\nOutput");
		System.out.println(result);

	}

	private static Collection<String> findHydras(String primeNode, HashMap<String, List<String>> graph) {

		Set<String> hydra = new HashSet<String>(graph.keySet());
		hydra.remove(primeNode);
		Queue<String> queue = new LinkedList<String>();
		queue.add(primeNode);
		while (!queue.isEmpty()) {
			String current = queue.poll();
			List<String> nextNodes = graph.get(current);
			if (nextNodes != null) {
				// add all that not in shield
				for (String node : nextNodes) {
					if (hydra.contains(node)) {
						queue.add(node);
						// add all to shield
						hydra.remove(node);
					}
				}
			}
		}

		return hydra;
	}

	private static Collection<String> _findHydras(String primeNode, HashMap<String, List<String>> graph) {

		Set<String> shield = new HashSet<String>();
		shield.add(primeNode);
		Queue<String> queue = new LinkedList<String>();
		queue.add(primeNode);
		while (!queue.isEmpty()) {
			String current = queue.poll();
			List<String> nextNodes = graph.get(current);
			if (nextNodes != null) {
				// add all that not in shield
				for (String node : nextNodes) {
					if (!shield.contains(node)) {
						queue.add(node);
						// add all to shield
						shield.add(node);
					}
				}
			}
		}

		Set<String> hydra = new HashSet<String>();
		for (String node : graph.keySet()) {
			if (!shield.contains(node)) {
				hydra.add(node);
			}
		}
		return hydra;
	}


}
