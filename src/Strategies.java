
public interface Strategies{
	public String format(String firstText, String secondText) throws IllegalArgumentException;
	
	public default boolean isValid(String firstText, String secondText) throws IllegalArgumentException{
		if(firstText.isEmpty() || secondText.isEmpty() ||firstText.matches(".*\\d+.*") || secondText.matches(".*\\d+.*")){
			throw new IllegalArgumentException();
		}
		return true;
	}
}
