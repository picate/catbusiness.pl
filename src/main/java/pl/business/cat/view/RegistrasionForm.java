package pl.business.cat.view;

import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrasionForm  extends FormLayout{

	private TextField firstName, lastName, userName;
	private DateTimePicker birth;
	private PasswordField password, conformPassword;
	
	public RegistrasionForm() {
		this.setClassName("regis-form");
		firstName = new TextField();
		lastName= new TextField();
		userName= new TextField();
		birth = new DateTimePicker();
		password = new PasswordField();
		conformPassword = new PasswordField();
		
		add(firstName,lastName,userName,birth,password,conformPassword);
		 // Max width of the Form
       setMaxWidth("500px");

       // Allow the form layout to be responsive.
       // On device widths 0-490px we have one column.
       // Otherwise, we have two columns.
       setResponsiveSteps(
               new ResponsiveStep("0", 1, ResponsiveStep.LabelsPosition.TOP),
               new ResponsiveStep("490px", 2, ResponsiveStep.LabelsPosition.TOP));

       // These components always take full width
       setColspan(lastName, 2);
       setColspan(birth, 2);	
	}
}
