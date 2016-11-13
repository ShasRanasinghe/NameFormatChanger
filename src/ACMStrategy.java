
public class ACMStrategy implements Strategies {

	@Override
	public String format(String firstName, String lastName) throws IllegalArgumentException{
		isValid(firstName,lastName);
		return firstName + " " + lastName + ".";
	}

}
