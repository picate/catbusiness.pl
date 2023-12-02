package pl.business.cat.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@Route(value = "/:user")
public class User extends VerticalLayout implements BeforeEnterObserver {
	
	private static String userName;
	
	public User(){
		add(new H1(userName));
	}
	
	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		userName = event.getRouteParameters().get("user").get();
	}
}
