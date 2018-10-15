import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class BestFirstSearch extends SearchParent{
		
	public static List<State> BestFirstManhattan(State root) {
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		PriorityQueue<State> openList = new PriorityQueue<>( new StateComparatorManhattan());

		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			closedList.add(currentState);
			currentState.generateChildrenStates();

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
					openList.add(currentChild);
				}
			}
			if (isGoalReached) {
				break;
			}
		}

		return solutionPath;		
	}

	
	public static List<State> BestFirstEuclidean(State root) {
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		PriorityQueue<State> openList = new PriorityQueue<>( new StateComparatorEuclidean());

		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			closedList.add(currentState);
			currentState.generateChildrenStates();

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
					openList.add(currentChild);
				}
			}
			if (isGoalReached) {
				break;
			}
		}

		return solutionPath;		
	}

	
	public static List<State> BestFirstHamming(State root) {
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		PriorityQueue<State> openList = new PriorityQueue<>( new StateComparatorHamming());

		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			closedList.add(currentState);
			currentState.generateChildrenStates();

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

	
	public static List<State> BestFirstChebyshev(State root) {
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		PriorityQueue<State> openList = new PriorityQueue<>( new StateComparatorChebyshev());

		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			closedList.add(currentState);
			currentState.generateChildrenStates();

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

	
	public static List<State> BestFirstGaschnig(State root) {
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		PriorityQueue<State> openList = new PriorityQueue<>( new StateComparatorGaschnig());

		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			closedList.add(currentState);
			currentState.generateChildrenStates();

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

	
	public static List<State> BestFirstPermutationInversion(State root) {
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		PriorityQueue<State> openList = new PriorityQueue<>( new StateComparatorPermutaionInversion());

		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			closedList.add(currentState);
			currentState.generateChildrenStates();

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
