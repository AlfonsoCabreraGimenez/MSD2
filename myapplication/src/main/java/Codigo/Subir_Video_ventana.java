package Codigo;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
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
public class Subir_Video_ventana extends VerticalLayout {
	protected VerticalLayout vSubirVideo;
	protected Label subirVideo;
	protected HorizontalLayout hDatosVideo;
	protected VerticalLayout vPropVideo;
	protected HorizontalLayout hURL;
	protected TextField url;
	protected Upload upload1;
	protected TextField titulo;
	protected ComboBox<java.lang.String> categoria;
	protected TextField etiqueta;
	protected VerticalLayout vImagen;
	protected Label miniatura;
	protected HorizontalLayout hImagen;
	protected Image imagen;
	protected Upload upload;
	protected TextArea descripcion;
	protected HorizontalLayout hAccion;
	protected Button cancelar;
	protected Button confirmar;

	public Subir_Video_ventana() {
		Design.read(this);
	}
}
