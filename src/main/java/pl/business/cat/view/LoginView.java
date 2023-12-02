package pl.business.cat.view;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("login") 
@PageTitle("Login In")
@AnonymousAllowed
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

	private final LoginForm login = new LoginForm(); 

	public LoginView(){
		this.setId("main");
		addClassName("login-view");
		setSizeFull(); 
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);
		setHComp();
		login.setAction("login");

		
	}

	@Override
	public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
		// inform the user about an authentication error
		if(beforeEnterEvent.getLocation()  
        .getQueryParameters()
        .getParameters()
        .containsKey("error")) {
            login.setError(true);
        }
	}
	
	public void setHComp(){
		H1 pi = new H1("Picate");
		Button sign = new Button("Sign-in");
		pi.setId("picate");
		sign.setId("sign-in");
		pi.setClassName("sign-in-h");
		sign.setClassName("sign-in-h");
		add(pi, login,sign);
		this.login.addLoginListener((e)->auth(e));
	}

	private void auth(LoginEvent e) {
		Authentication auth = new UsernamePasswordAuthenticationToken(e.getUsername(), e.getPassword());
		Authentication pass = new DaoAuthenticationProvider().authenticate(auth);
		SecurityContextHolder.getContext().setAuthentication(pass);	
		UI.getCurrent().navigateToClient("/{e.getUsername}");
	}
}