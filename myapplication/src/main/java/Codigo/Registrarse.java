package Codigo;

import com.vaadin.ui.UI;

import diagramaclasesbd.BD_Principal;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.flute.parser.ParseException;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
public class Registrarse extends Registrarse_ventana {
	
	iUsuario_No_Registrado unr = new BD_Principal();
	public Ingreso_Aplicacion _unnamed_Ingreso_Aplicacion_;
	public Perfil_Ajeno _unnamed_Perfil_Ajeno_;
	public Nuevo_Pass _unnamed_Nuevo_Pass_;

	public Registrarse() {
		modificarDatosUser.setVisible(false);
		botonRegistrarse.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
					try {
						registrarse();
					} catch (java.text.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					UI.getCurrent().getNavigator().navigateTo("PagIR");
					
				}	
		});
	}
	public void registrarse() throws java.text.ParseException  {
		String aNombre = tNombre.getValue();
		String aApellido1 = tApellido1.getValue();
		String aApellido2 = tApellido2.getValue();
		/*Parametros de la fecha*/
		String anio = Integer.toString(fechaUsuario.getValue().getYear());
		String mes = Integer.toString(fechaUsuario.getValue().getMonthValue());
		String dia = Integer.toString(fechaUsuario.getValue().getDayOfMonth());
		
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		String fechaAlta = anio+"-"+mes+"-"+dia;
		Date fechaFinal = null;
		try {
			fechaFinal = formatoDelTexto.parse(fechaAlta);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		String aApodo = tApodo.getValue();
		String aPass = tPass.getValue();
		String aRepPass = tRepPass.getValue();
		String aEmail = tEmail.getValue();
		String aAvatar = "as";
		unr.registrarse(aNombre, aApellido1, aApellido2, fechaFinal, aApodo, aPass, aRepPass, aEmail, aAvatar);
	}
}