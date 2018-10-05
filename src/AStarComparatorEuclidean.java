import java.util.Comparator;

class AStarComparatorEuclidean implements Comparator<State>{

	@Override
	public int compare(State a, State b) {
		if (a.heuristicEuclideanDistance < b.heuristicEuclideanDistance) {
			return -1;
		} else if (a.heuristicEuclideanDistance > b.heuristicEuclideanDistance) {
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
