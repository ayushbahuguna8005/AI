import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class AStar extends SearchParent {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		long startTime = System.currentTimeMillis();
		
		
		//int initialState[][] = { { 1, 0, 3, 7 }, { 5, 2, 6, 4 }, { 9, 10, 11,
		//8 } };
		// int initialState[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 0,
		// 11 } };
		// int initialState[][] = { { 1, 2, 6, 4 }, { 5, 9, 7, 3 }, { 0, 10, 11,
		// 8 } };
		//int initialState[][] = { { 0, 11, 10, 9}, { 8, 7, 6, 5 }, { 4, 3, 2, 1 } };
		int initialState[][] = { { 0, 11, 9, 10 }, { 8, 7, 6, 5 }, { 4, 3, 2, 1 } };
		int[][] goalState = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 0 } };
		State root = new State(initialState, goalState);
		
		List<State> solutionPath = AStarSearch(root);

		if (solutionPath.size() > 0) {
			for (int i = solutionPath.size() - 1; i >= 0; i--) {
				solutionPath.get(i).printCurrentState();
			}
			System.out.println("Size: " + solutionPath.size());
		} else {
			System.out.println("No solution path found");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken : " + (endTime - startTime)/1000 + " seconds");

	}

	public static List<State> AStarSearch(State root) throws FileNotFoundException, UnsupportedEncodingException {
		//PrintWriter writer = new PrintWriter("puzzle12.txt");
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		PriorityQueue<State> openList = new PriorityQueue<>(new AStarComparatorManhattan());
		//PriorityQueue<State> openList = new PriorityQueue<>( new AStarComparatorEuclidean());
		//PriorityQueue<State> openList = new PriorityQueue<>( new AStarComparatorHamming());
		//PriorityQueue<State> openList = new PriorityQueue<>( new AStarComparatorPermInv());

		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			closedList.add(currentState);
			currentState.generateChildrenStatesBestFirst();
			if (currentState.isGoalReached()) {
				System.out.println("Reached goal state");
				isGoalReached = true;
				getSolutionPath(solutionPath, currentState);
				break;
			}

			for (int i = 0; i < currentState.childrenStates.size(); i++) {
				State currentChild = currentState.childrenStates.get(i);
//				if (currentChild.isGoalReached()) {
//					System.out.println("Reached goal state");
//					isGoalReached = true;
//					getSolutionPath(solutionPath, currentChild);
//					break;
//				}

				if (!doesListAlreadyHasChildState(openList, currentChild)
						&& !doesListAlreadyHasChildState(closedList, currentChild)) {
					// openList.add(currentChild);
					openList.add(currentChild);
				}
				
				if (doesListAlreadyHasChildState(openList, currentChild)) {
					State stateInList = findExistingChildStateInListAStar(openList, currentChild);
					if(compareHeuristicManhattanFirstBetter(currentChild, stateInList) && stateInList!=null){
						//System.out.println("Already in open List current level: "+ currentChild.level + "stateinlist leve: "+ stateInList.level);
						//System.out.println("Removed "+openList.remove(stateInList)+ " with level and heuristic:" +stateInList.heuristicManhattanDistance+" "+stateInList.level);
						//openList.add(currentChild);
						//System.out.println("Added "+openList.add(currentChild)+ " with level and heuristic:" +currentChild.heuristicManhattanDistance+" "+currentChild.level);
						//System.out.println("Added "+openList.add(currentChild)+ " with level and heuristic:" +currentChild.heuristicManhattanDistance+" "+currentChild.level);
					}
				}
			}
			if (isGoalReached) {
				break;
			}
		}

		return solutionPath;
	}

	public static boolean compareHeuristicManhattanFirstBetter(State s1, State s2) {
		if ((s1.heuristicManhattanDistance + s1.level) < (s2.heuristicManhattanDistance + s2.level))
			return true;
		else
			return false;

	}
}
