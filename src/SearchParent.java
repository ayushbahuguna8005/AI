import java.util.List;
import java.util.PriorityQueue;

class SearchParent {

	public static void getSolutionPath(List<State> solutionPath, State state) {
		//System.out.println("Printing Solution path");
		State currentState = state;
		solutionPath.add(currentState);

		while (currentState.parent != null) {
			currentState = currentState.parent;
			solutionPath.add(currentState);
		}
		//System.out.println("Printing Solution path 2");

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

		for(State stateList: list){
			if (stateList.isCurrentStateRegenerated(state.currentState))
				exists = true;
		}

		return exists;
	}
	
}
