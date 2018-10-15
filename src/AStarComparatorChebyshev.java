import java.util.Comparator;

class AStarComparatorChebyshev implements Comparator<State> {

	@Override
	public int compare(State a, State b) {
		//System.out.println("comaprator");
		if ((a.heuristicChebyshev + a.level) < (b.heuristicChebyshev + b.level)) {
			return -1;
		} else if ((a.heuristicChebyshev + a.level) > (b.heuristicChebyshev + b.level)) {
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
