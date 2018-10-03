import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import javax.xml.soap.Node;

class DFS extends SearchParent{

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		// Scanner sc = new Scanner(System.in);
		// int initState[] = new int[12];
		// for (int i = 0; i < 12; i++) {
		// initState[i] = sc.nextInt();
		// }
		// int initialState[][] = new int[3][4];
		// int k = 0;
		// for (int i = 0; i < 3; i++) {
		// for (int j = 0; j < 4; j++) {
		// initialState[i][j] = initState[k++];
		// }
		// }

		int initialState[][] = { { 1, 0, 3, 7 }, { 5, 2, 6, 4 }, { 9, 10, 11, 8 } };
		//int initialState[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 0, 11 } };
		//int initialState[][] = { { 1, 2, 6, 4 }, { 5, 9, 7, 3 }, { 0, 10, 11, 8 } };
		State root = new State(initialState);

		List<State> solutionPath = DFS(root);

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

	public static List<State> DFS(State root) {
		List<State> solutionPath = new ArrayList<>();
		// List<State> openList = new ArrayList<>();
		Stack<State> openList = new Stack<>();
		List<State> closedList = new ArrayList<>();

		// openList.add(root);
		openList.push(root);

		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.peek();
			closedList.add(currentState);
			// openList.remove(openList.size() - 1); // stack
			openList.pop();

			currentState.generateChildrenStatesDFS();
			// currentState.printCurrentState();

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
					openList.push(currentChild);
				}
			}
			if (isGoalReached) {
				break;
			}
		}

		return solutionPath;
	}



	

}
