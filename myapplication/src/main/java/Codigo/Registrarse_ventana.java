package Codigo;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class Registrarse_ventana extends VerticalLayout {
	protected VerticalLayout vRegistrarse;
	protected HorizontalLayout hVacio;
	protected VerticalLayout vPersonales;
	protected Label lPersonales;
	protected HorizontalLayout hPersonales;
	protected TextField tNombre;
	protected TextField tApellido1;
	protected TextField tApellido2;
	protected VerticalLayout vFechaN;
	protected Label fechaNacimiento;
	protected DateTimeField fechaUsuario;
	protected HorizontalLayout hUsuario;
	protected VerticalLayout vUsuario;
	protected Label lUsuario;
	protected TextField tApodo;
	protected TextField tEmail;
	protected HorizontalLayout hPass;
	protected PasswordField tPass;
	protected PasswordField tRepPass;
	protected VerticalLayout vAvatar;
	protected Label lAvatar;
	protected HorizontalLayout hAvatar;
	protected Image imagen;
	protected Upload botonSubir;
	protected HorizontalLayout hVacio1;
	protected Button botonRegistrarse;
	protected Button modificarDatosUser;

	public Registrarse_ventana() {
		Design.read(this);
	}
}
