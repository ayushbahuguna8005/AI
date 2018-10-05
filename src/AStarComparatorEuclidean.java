import java.util.Comparator;

class AStarComparatorEuclidean implements Comparator<State> {

	@Override
	public int compare(State a, State b) {
		if ((a.heuristicEuclideanDistance + a.level) < (b.heuristicEuclideanDistance + b.level)) {
			return -1;
		} else if ((a.heuristicEuclideanDistance + a.level) > (b.heuristicEuclideanDistance + b.level)) {
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
