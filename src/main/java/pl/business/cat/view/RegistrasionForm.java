package pl.business.cat.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrasionForm  extends FormLayout{

	private TextField firstName, lastName, userName, email;
	private DateTimePicker birth;
	private PasswordField password, conformPassword;
	private Button regisButton;
	private H1 pi;
	
	public RegistrasionForm() {
		this.getClassNames().add("regis-form");
		this.getElement().getStyle().set("max-width", "100vw");
		firstName = new TextField();
		firstName.setLabel("Imię");
		lastName= new TextField();
		lastName.setLabel("Nazwisko");
		email = new TextField();
		email.setLabel("Emial");
		userName= new TextField();
		userName.setLabel("Nazwa gracza");
		birth = new DateTimePicker();
		birth.setLabel("Data urodzin");
		password = new PasswordField();
		password.setLabel("Hasło");
		conformPassword = new PasswordField();
		conformPassword.setLabel("Powtórz hasło");
		regisButton = new Button("Sing up");
		pi = new H1("Picate");
		pi.setId("picate");
		add(pi,firstName,lastName,userName,email,password,conformPassword,regisButton);
		 // Max width of the Form
       setMaxWidth("500px");
       setColspan(pi, 2);
       // Allow the form layout to be responsive.
       // On device widths 0-490px we have one column.
       // Otherwise, we have two columns.
       setResponsiveSteps(
               new ResponsiveStep("0", 1, ResponsiveStep.LabelsPosition.TOP),
               new ResponsiveStep("490px", 2, ResponsiveStep.LabelsPosition.TOP));
	}
}
