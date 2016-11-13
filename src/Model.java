import java.util.Observable;


public class Model extends Observable{

	private String firstText;
	private String secondText;
	
	public Model(){}
	
	public void format(Strategies strategy) throws IllegalArgumentException{
		String output = strategy.format(firstText, secondText);
		setChanged();
		notifyObservers(output);
	}

	public void setInfo(String firstText, String secondText){
		this.firstText = firstText;
		this.secondText = secondText;
	}
}
