import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class BestFirstSearch extends SearchParent{
	
	public static HashMap<Integer, ArrayList<Integer>> hashLocationGoalItems = new HashMap<>();
	//int[][] goalState = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
	

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int initialState[][] = { { 1, 0, 3, 7 }, { 5, 2, 6, 4 }, { 9, 10, 11, 8 } };
		//int initialState[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 0, 11 } };
		//int initialState[][] = { { 1, 2, 6, 4 }, { 5, 9, 7, 3 }, { 0, 10, 11, 8 } };
		State root = new State(initialState);

		List<State> solutionPath = BestFirst(root);

		if (solutionPath.size() > 0) {
			for (int i = solutionPath.size() - 1; i >= 0; i--) {
				solutionPath.get(i).printCurrentState();
			}
			System.out.println("Size: " + solutionPath.size());
		} else {
			System.out.println("No solution path found");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken : " + (endTime - startTime));
		
	}
	
	public static List<State> BestFirst(State root) {
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		PriorityQueue<State> openList = new PriorityQueue<>( new StateComparatorManhattan());

		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			closedList.add(currentState);
			currentState.generateChildrenStatesDFS();

			for (int i = 0; i < currentState.childrenStates.size(); i++) {
				State currentChild = currentState.childrenStates.get(i);
				if (currentChild.isGoalReached()) {
					System.out.println("Reached goal state");
					isGoalReached = true;
					getSolutionPath(solutionPath, currentChild);
					break;
				}

				if (!doesListAlreadyHasChildState(openList, currentChild)
						&& !doesListAlreadyHasChildState(closedList, currentChild)) {
					// openList.add(currentChild);
					openList.add(currentChild);
				}
			}
			if (isGoalReached) {
				break;
			}
		}

		return solutionPath;		
	}
	
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

}
