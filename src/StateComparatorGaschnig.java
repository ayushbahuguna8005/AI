import java.util.Comparator;

class StateComparatorGaschnig implements Comparator<State> {

	@Override
	public int compare(State a, State b) {
		if ((a.heuristicGaschnig ) < (b.heuristicGaschnig )) {
			return -1;
		} else if ((a.heuristicGaschnig ) > (b.heuristicGaschnig )) {
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
