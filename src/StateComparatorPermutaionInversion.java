import java.util.Comparator;

class StateComparatorPermutaionInversion implements Comparator<State>{

	@Override
	public int compare(State a, State b) {
		if (a.heuristicPermutationInversion < b.heuristicPermutationInversion) {
			return -1;
		} else if (a.heuristicPermutationInversion > b.heuristicPermutationInversion) {
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
