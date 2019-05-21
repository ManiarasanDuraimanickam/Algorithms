package algo.tryout.search.string;

public class Matched {

	public String phase;
	public int startIndex;
	public int endIndex;

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("phase--").append(phase).append(", StartIndex--").append(startIndex).append(", EndIndex--")
				.append(endIndex);
		return builder.toString();
	}
}
