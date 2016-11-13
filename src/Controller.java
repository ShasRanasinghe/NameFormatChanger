import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
	
	private View view;
	private Model model;
	
	public Controller(Model model, View view){
		this.view = view;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Submit!")){
			model.setInfo(view.getFirstText(), view.getSecondText());
			try {
				if(view.isFirstOption()){
					model.format(new IEEEStrategy());	
				}else if(view.isSecondOption()){
					model.format(new ACMStrategy());
				}
			} catch (IllegalArgumentException e1) {
				notifyViewOfError();
			}
		}
	}
	
	public void notifyViewOfError(){
		view.popUpError();
	}

}
