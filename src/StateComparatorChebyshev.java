import java.util.Comparator;

class StateComparatorChebyshev implements Comparator<State> {
	
	@Override
	public int compare(State a, State b) {
		if ((a.heuristicChebyshev ) < (b.heuristicChebyshev )) {
			return -1;
		} else if ((a.heuristicChebyshev ) > (b.heuristicChebyshev )) {
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
