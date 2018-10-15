import java.util.Comparator;

class AStarComparatorGaschnig implements Comparator<State> {

	@Override
	public int compare(State a, State b) {
		if ((a.heuristicGaschnig + a.level) < (b.heuristicGaschnig + b.level)) {
			return -1;
		} else if ((a.heuristicGaschnig + a.level) > (b.heuristicGaschnig + b.level)) {
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
