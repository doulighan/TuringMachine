package doulighan;

//(State, symbol) = (State, symbol, direction)
public final class Pair {

	public final String state, symbol;

	public Pair(String st, String sy) {
		state = st;
		symbol = sy;
	}

	@Override
	public int hashCode() {
		return state.hashCode() ^ symbol.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Pair) && ((Pair) obj).state.equals(state)
				&& ((Pair) obj).symbol.equals(symbol);
	}
	
	public boolean equals(Pair b) {
	   return state.equals(b.state) && symbol.equals(b.symbol);
	}

	public String getState() {
		return state;
	}

	public String getSymbol() {
		return symbol;
	}
	
	public String toString() {
	   return "State: " + state + ", Symbol: " + symbol; 
	}

}
