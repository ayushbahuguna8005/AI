import java.util.Comparator;

class StateComparatorManhattan implements Comparator<State> {

	@Override
	public int compare(State a, State b) {
		if (a.heuristicManhattanDistance < b.heuristicManhattanDistance) {
			return -1;
		} else if (a.heuristicManhattanDistance > b.heuristicManhattanDistance) {
			return 1;
		} else {
			if (a.movePriority > b.movePriority) {
				return -1;
			} else {
				return 1;
			}
		}
	}

}
