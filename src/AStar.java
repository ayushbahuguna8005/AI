import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class AStar extends SearchParent {

		public static List<State> AStarSearchHamming(State root) throws FileNotFoundException, UnsupportedEncodingException {
		// PrintWriter writer = new PrintWriter("puzzle12.txt");
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		PriorityQueue<State> openList = new PriorityQueue<>( new AStarComparatorHamming());
		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			closedList.add(currentState);
			currentState.generateChildrenStates();

			if (currentState.isGoalReached()) {
				System.out.println("Reached goal state");
				isGoalReached = true;
				getSolutionPath(solutionPath, currentState);
				break;
			}

			for (int i = 0; i < currentState.childrenStates.size(); i++) {
				State currentChild = currentState.childrenStates.get(i);

				if (!doesListAlreadyHasChildState(openList, currentChild)
						&& !doesListAlreadyHasChildState(closedList, currentChild)) {
					openList.add(currentChild);
				}

				if (doesListAlreadyHasChildState(openList, currentChild)) {
					State stateInList = findExistingChildStateInListAStar(openList, currentChild);
					if (compareHeuristicHammingFirstBetter(currentChild, stateInList) && stateInList != null) {
						openList.remove(stateInList);
						openList.add(currentChild);
					}
				}
			}
			if (isGoalReached) {
				break;
			}
		}

		return solutionPath;
	}
		
	public static List<State> AStarSearchEuclidean(State root) throws FileNotFoundException, UnsupportedEncodingException {
		// PrintWriter writer = new PrintWriter("puzzle12.txt");
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		PriorityQueue<State> openList = new PriorityQueue<>( new AStarComparatorEuclidean());
		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			//currentState.printCurrentState();
			closedList.add(currentState);
			currentState.generateChildrenStates();

			if (currentState.isGoalReached()) {
				System.out.println("Reached goal state");
				isGoalReached = true;
				getSolutionPath(solutionPath, currentState);
				break;
			}

			for (int i = 0; i < currentState.childrenStates.size(); i++) {
				State currentChild = currentState.childrenStates.get(i);

				if (!doesListAlreadyHasChildState(openList, currentChild)
						&& !doesListAlreadyHasChildState(closedList, currentChild)) {
					openList.add(currentChild);
				}

				if (doesListAlreadyHasChildState(openList, currentChild)) {
					State stateInList = findExistingChildStateInListAStar(openList, currentChild);
					if (compareHeuristicEuclideanFirstBetter(currentChild, stateInList) && stateInList != null) {
						openList.remove(stateInList);
						openList.add(currentChild);
					}
				}
			}
			if (isGoalReached) {
				break;
			}
		}

		return solutionPath;
	}
	
	public static List<State> AStarSearchManhattan(State root) throws FileNotFoundException, UnsupportedEncodingException {
		// PrintWriter writer = new PrintWriter("puzzle12.txt");
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		PriorityQueue<State> openList = new PriorityQueue<>(new AStarComparatorManhattan());

		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			closedList.add(currentState);
			currentState.generateChildrenStates();

			if (currentState.isGoalReached()) {
				System.out.println("Reached goal state");
				isGoalReached = true;
				getSolutionPath(solutionPath, currentState);
				break;
			}

			for (int i = 0; i < currentState.childrenStates.size(); i++) {
				State currentChild = currentState.childrenStates.get(i);

				if (!doesListAlreadyHasChildState(openList, currentChild)
						&& !doesListAlreadyHasChildState(closedList, currentChild)) {
					openList.add(currentChild);
				}

				else if (doesListAlreadyHasChildState(openList, currentChild)) {
					State stateInList = findExistingChildStateInListAStar(openList, currentChild);
					if (compareHeuristicManhattanFirstBetter(currentChild, stateInList) && stateInList != null) {
						openList.remove(stateInList);
						openList.add(currentChild);
					}
				}
			}
			if (isGoalReached) {
				break;
			}
		}

		return solutionPath;
	}
	
	public static List<State> AStarSearchGaschnig(State root) throws FileNotFoundException, UnsupportedEncodingException {
		// PrintWriter writer = new PrintWriter("puzzle12.txt");
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		 PriorityQueue<State> openList = new PriorityQueue<>( new AStarComparatorGaschnig());

		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			closedList.add(currentState);
			currentState.generateChildrenStates();

			if (currentState.isGoalReached()) {
				System.out.println("Reached goal state");
				isGoalReached = true;
				getSolutionPath(solutionPath, currentState);
				break;
			}

			for (int i = 0; i < currentState.childrenStates.size(); i++) {
				State currentChild = currentState.childrenStates.get(i);

				if (!doesListAlreadyHasChildState(openList, currentChild)
						&& !doesListAlreadyHasChildState(closedList, currentChild)) {
					openList.add(currentChild);
				}

				if (doesListAlreadyHasChildState(openList, currentChild)) {
					State stateInList = findExistingChildStateInListAStar(openList, currentChild);
					if (compareHeuristicGaschnigFirstBetter(currentChild, stateInList) && stateInList != null) {
						openList.remove(stateInList);
						openList.add(currentChild);
					}
				}
			}
			if (isGoalReached) {
				break;
			}
		}

		return solutionPath;
	}

	public static List<State> AStarSearchChebyshev(State root) throws FileNotFoundException, UnsupportedEncodingException {
		// PrintWriter writer = new PrintWriter("puzzle12.txt");
		List<State> solutionPath = new ArrayList<>();
		List<State> closedList = new ArrayList<>();
		PriorityQueue<State> openList = new PriorityQueue<>( new AStarComparatorChebyshev());
		
		openList.add(root);
		boolean isGoalReached = false;

		while (!openList.isEmpty() && !isGoalReached) {
			State currentState = openList.poll();
			closedList.add(currentState);
			currentState.generateChildrenStatesDFS();
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//currentState.printCurrentState();
			
			if (currentState.isGoalReached()) {
				System.out.println("Reached goal state");
				isGoalReached = true;
				getSolutionPath(solutionPath, currentState);
				break;
			}

			for (int i = 0; i < currentState.childrenStates.size(); i++) {
				State currentChild = currentState.childrenStates.get(i);

				if (!doesListAlreadyHasChildState(openList, currentChild)
						&& !doesListAlreadyHasChildState(closedList, currentChild)) {
					openList.add(currentChild);
				}

				else if (doesListAlreadyHasChildState(openList, currentChild)) {
					State stateInList = findExistingChildStateInListAStar(openList, currentChild);
					if (compareHeuristicChebyshevFirstBetter(currentChild, stateInList) && stateInList != null) {
						openList.remove(stateInList);
						openList.add(currentChild);
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
	
	public static boolean compareHeuristicHammingFirstBetter(State s1, State s2) {
		if ((s1.heuristicHammingDistance + s1.level) < (s2.heuristicHammingDistance + s2.level))
			return true;
		else
			return false;

	}

	public static boolean compareHeuristicPermutationInversionFirstBetter(State s1, State s2) {
		if ((s1.heuristicPermutationInversion + s1.level) < (s2.heuristicPermutationInversion + s2.level))
			return true;
		else
			return false;

	}
	
	public static boolean compareHeuristicEuclideanFirstBetter(State s1, State s2) {
		if ((s1.heuristicEuclideanDistance + s1.level) < (s2.heuristicEuclideanDistance + s2.level))
			return true;
		else
			return false;

	}
	
	public static boolean compareHeuristicGaschnigFirstBetter(State s1, State s2) {
		if ((s1.heuristicGaschnig + s1.level) < (s2.heuristicGaschnig + s2.level))
			return true;
		else
			return false;
	}
	
	public static boolean compareHeuristicChebyshevFirstBetter(State s1, State s2) {
		if ((s1.heuristicChebyshev + s1.level) < (s2.heuristicChebyshev + s2.level))
			return true;
		else
			return false;
	}
	
}
