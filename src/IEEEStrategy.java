
public class IEEEStrategy implements Strategies {

	@Override
	public String format(String firstName, String lastName) throws IllegalArgumentException{
		isValid(firstName,lastName);
		return firstName.substring(0,1) + ". " + lastName;
	}

}
