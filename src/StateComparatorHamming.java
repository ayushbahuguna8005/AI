import java.util.Comparator;

class StateComparatorHamming implements Comparator<State>{

	@Override
	public int compare(State a, State b) {
		if (a.heuristicHammingDistance< b.heuristicHammingDistance) {
			return -1;
		} else if (a.heuristicHammingDistance > b.heuristicHammingDistance) {
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
