import java.util.Comparator;

class AStarComparatorManhattan implements Comparator<State> {

	@Override
	public int compare(State a, State b) {
		if ((a.heuristicManhattanDistance + a.level) < (b.heuristicManhattanDistance + b.level)) {
			return -1;
		} else if ((a.heuristicManhattanDistance + a.level) > (b.heuristicManhattanDistance + b.level)) {
			return 1;
		} else {
			if (a.movePriority < b.movePriority) {
				return -1;
			} else if (a.movePriority > b.movePriority) {
				return 1;
			} else {
				return 0;
			}
		}
	}

}
