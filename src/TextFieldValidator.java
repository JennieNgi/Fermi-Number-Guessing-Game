import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TextFieldValidator {
	// "\\w" = [a-zA-Z0-9_]
	private String regExp = "\\w";
	private Color errorColor = Color.RED;
	private JTextField target;
	
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
	
	public boolean check() {
		if (target.getText().matches(regExp)) {
			return true;
		}else {
			target.setBorder(new LineBorder(errorColor, 2));
			return false;
		}
	}
	
	public void reset() {
			
	}
	
	
}
