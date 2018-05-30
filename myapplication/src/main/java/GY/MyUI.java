package GY;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import Codigo.Ingreso_Aplicacion;
import Codigo.Pag_Inicio_NR;
import Codigo.Pag_Inicio_R;
import Codigo.Perfil_Ajeno;
import Codigo.Perfil_Ajeno_A;
import Codigo.Perfil_Ajeno_R;
import Codigo.Perfil_Propio_A;
import Codigo.Perfil_Propio_R;
import Codigo.Visualizacion_Video_Ajeno;
import Codigo.Visualizacion_Video_Ajeno_A;
import Codigo.Visualizacion_Video_Propio_AR;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	Navigator navigator;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	navigator = new Navigator(this, this);
    	//navigator.addView("",new Pag_Inicio_NR());
    	navigator.addView("",new Perfil_Ajeno_A());
    	navigator.addView("inicioNR",new Pag_Inicio_NR());
    	navigator.addView("Ingreso",new Ingreso_Aplicacion());
    	navigator.addView("PagIR",new Pag_Inicio_R());
    	navigator.addView("VisAjeno",new Visualizacion_Video_Ajeno());
    	navigator.addView("PAjeno",new Perfil_Ajeno());
    /*Visualizacion_Video_Ajeno_A p = new Visualizacion_Video_Ajeno_A();
    
    setContent(p);*/
    
    }
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
