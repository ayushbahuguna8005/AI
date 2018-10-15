import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

class BestFirstManhattan extends BestFirstSearch{

	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int initState[] = new int[12];
		System.out.println("Enter space separated intergers as initial puzzle");
		for (int i = 0; i < 12; i++) {
			initState[i] = sc.nextInt();
		}
		int initialState[][] = new int[3][4];
		int k = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				initialState[i][j] = initState[k++];
			}
		}
		//int initialState[][] = { { 1, 0, 3, 7 }, { 5, 2, 6, 4 }, { 9, 10, 11, 8 } };
		//int initialState[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 0, 11 } };
		//int initialState[][] = { { 1, 2, 6, 4 }, { 5, 9, 7, 3 }, { 0, 10, 11, 8 } };
		//int initialState[][] = { { 0, 11, 10, 9 }, { 8, 7, 6, 5 }, { 4, 3, 2, 1 } };
		//int initialState[][] = { { 0, 11, 9, 10 }, { 8, 7, 6, 5 }, { 4, 3, 2, 1 } };
		//int initialState[][] = { { 1, 8, 6, 2 }, { 5, 11, 7, 9 }, { 3, 4, 0, 10 } };
		int[][] goalState = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 0 } };
		State root = new State(initialState, goalState);
		//root.printCurrentState();
		List<State> solutionPath = BestFirstManhattan(root);
		//List<State> solutionPath = AStarSearchEuclidean(root);
		//List<State> solutionPath = AStarSearchGaschnig(root);

		printSolution(solutionPath);
		printSolution(solutionPath, "puzzleBFS-h5-Experiment.txt");
		long endTime = System.currentTimeMillis();
		//System.out.println("Time taken : " + (endTime - startTime) / 1000 + " seconds");
		System.out.println("Time taken : " + (endTime - startTime) + " milliseconds");
	}

}
