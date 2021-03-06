import java.util.Comparator;

class AStarComparatorHamming implements Comparator<State> {

	@Override
	public int compare(State a, State b) {
		if ((a.heuristicHammingDistance + a.level) < (b.heuristicHammingDistance + b.level)) {
			return -1;
		} else if ((a.heuristicHammingDistance + a.level) > (b.heuristicHammingDistance + b.level)) {
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
