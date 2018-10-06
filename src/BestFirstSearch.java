import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class BestFirstSearch extends SearchParent{
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		//int initialState[][] = { { 1, 0, 3, 7 }, { 5, 2, 6, 4 }, { 9, 10, 11, 8 } };
		//int initialState[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 0, 11 } };
		//int initialState[][] = { { 1, 2, 6, 4 }, { 5, 9, 7, 3 }, { 0, 10, 11, 8 } };
		int initialState[][] = { { 0, 11, 10, 9 }, { 8, 7, 6, 5 }, { 4, 3, 2, 1 } };
		//int initialState[][] = { { 0, 11, 9, 10 }, { 8, 7, 6, 5 }, { 4, 3, 2, 1 } };
		int[][] goalState = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 0 } };
		State root = new State(initialState, goalState);

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
		System.out.println("Time taken : " + (endTime - startTime)+" millisec");
		
	}
	
	public static List<State> BestFirst(State root) {
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		PriorityQueue<State> openList = new PriorityQueue<>( new StateComparatorManhattan());
		//PriorityQueue<State> openList = new PriorityQueue<>( new StateComparatorEuclidean());
		//PriorityQueue<State> openList = new PriorityQueue<>( new StateComparatorHamming());
		//PriorityQueue<State> openList = new PriorityQueue<>( new StateComparatorPermutaionInversion());

		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			closedList.add(currentState);
			currentState.generateChildrenStatesBestFirst();

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
	
}
