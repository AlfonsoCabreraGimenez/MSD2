package Codigo;

import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Registrarse extends Registrarse_ventana {
	/*private Label _datosPL;
	private TextField _nombreTF;
	private TextField _apellido1;
	private TextField _apellido2;
	private Label _fechaNL;
	private ComboBox _mesCB;
	private ComboBox _diaCB;
	private ComboBox _anoCB;
	private Label _datosUL;
	private TextField _apodoTF;
	private TextField _emailTF;
	private TextField _passTF;
	private TextField _recPassTF;
	private Label _avatarL;
	private Image _avatarI;
	private Boton _registrarB;*/
	public Ingreso_Aplicacion _unnamed_Ingreso_Aplicacion_;
	public Perfil_Ajeno _unnamed_Perfil_Ajeno_;
	public Nuevo_Pass _unnamed_Nuevo_Pass_;
	
	public Registrarse() {
		modificarDatosUser.setVisible(false);
		botonRegistrarse.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("PagIR");	
			}
		});
	}
	public void registrarse() {
		throw new UnsupportedOperationException();
	}
}