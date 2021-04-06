
public class Rank {

	public int rank(char c) {
		c = Character.toUpperCase(c);
		int rank = c-'A'+1;
		return rank;
	}
}
