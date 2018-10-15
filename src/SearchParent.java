import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.PriorityQueue;

class SearchParent {

	public static void getSolutionPath(List<State> solutionPath, State state) {
		// System.out.println("Printing Solution path");
		State currentState = state;
		solutionPath.add(currentState);

		while (currentState.parent != null) {
			currentState = currentState.parent;
			solutionPath.add(currentState);
		}
		// System.out.println("Printing Solution path 2");

	}

	public static boolean doesListAlreadyHasChildState(List<State> list, State state) {
		boolean exists = false;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isCurrentStateRegenerated(state.currentState))
				exists = true;
		}

		return exists;
	}

	public static boolean doesListAlreadyHasChildState(PriorityQueue<State> list, State state) {
		boolean exists = false;

		for (State stateList : list) {
			if (stateList.isCurrentStateRegenerated(state.currentState))
				exists = true;
		}

		return exists;
	}

	public static State findExistingChildStateInListAStar(PriorityQueue<State> list, State state) {
		State state2 = null;
		for (State stateList : list) {
			if (stateList.isCurrentStateRegenerated(state.currentState))
				state2 = stateList;
		}

		return state2;
	}

	public static void printSolution(List<State> solutionPath) {

		if (solutionPath.size() > 0) {
			for (int i = solutionPath.size() - 1; i >= 0; i--) {
				solutionPath.get(i).printCurrentState();
			}
			System.out.println("Size: " + solutionPath.size() + " Moves = " + (solutionPath.size() - 1));
		} else {
			System.out.println("No solution path found");
		}

	}

	public static void printSolution(List<State> solutionPath, String fileName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(fileName);
		if (solutionPath.size() > 0) {
			for (int i = solutionPath.size() - 1; i >= 0; i--) {
				State current = solutionPath.get(i);
				writer.print(current.getCharacterLocation() + " [");
				for (int k = 0; k < current.currentState.length; k++) {
					for (int j = 0; j < current.currentState[0].length; j++) {
						if (k == current.currentState.length - 1 && j == current.currentState[0].length - 1)
							writer.print(current.currentState[k][j]);
						else
							writer.print(current.currentState[k][j] + ", ");
					}
					// System.out.println();
				}
				// System.out.println("]" + " cheby = "+this.heuristicChebyshev
				// + " level = " + this.level);
				writer.println("]");
			}
		} else {
			writer.println("No solution path found");
		}
		writer.flush();
		writer.close();
	}

}
