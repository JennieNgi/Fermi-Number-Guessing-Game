import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TextFieldValidator {
	private String regExp = "^[0-9]$";
	private Color errorColor = Color.RED;
	private JTextField target;
	private boolean validateStatus;
	
	public TextFieldValidator(JTextField myTarget, Color myErrorColor) {
		setErrorColor(myErrorColor);
		target = myTarget;
    }
	
	public TextFieldValidator(JTextField myTarget) {
		target = myTarget;
    }
	
	public void setRegExp(String myRegExp) {
        regExp = myRegExp;
    }
	
	public void setErrorColor(Color myColor) {
		errorColor = myColor;
    }
	
	public boolean getValidateStatus() {
		return validateStatus;
	}
	
	public boolean check() {
		if (target.getText().matches(regExp)) {
			validateStatus = true;
		}else {
			target.setBorder(new LineBorder(errorColor, 2));
			validateStatus = false;
		}
		return validateStatus;
	}
	
	public void reset() {
			target.setBorder(new JTextField().getBorder());
	}
	
	
}
