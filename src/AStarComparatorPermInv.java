import java.util.Comparator;

class AStarComparatorPermInv implements Comparator<State> {

	@Override
	public int compare(State a, State b) {
		if ((a.heuristicPermutationInversion + a.level) < (b.heuristicPermutationInversion + b.level)) {
			return -1;
		} else if ((a.heuristicPermutationInversion + a.level) > (b.heuristicPermutationInversion + b.level)) {
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
