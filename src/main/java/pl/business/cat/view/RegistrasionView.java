package pl.business.cat.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.selection.SelectionModel.Single;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("registrasion") 
@PageTitle("Registrasion")
@AnonymousAllowed
public class RegistrasionView extends VerticalLayout {

	private RegistrasionForm regis;
	
	public RegistrasionView() {
		this.setId("regis");
		regis = new RegistrasionForm();
		addViews();
	}

	private void addViews() {
		H1 pi = new H1("Picate");
		pi.setId("picate");
		Button regisButton = new Button("Sing up");
		
		add(pi,regis,regisButton);
	}
}
