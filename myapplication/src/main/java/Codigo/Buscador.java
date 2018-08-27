package Codigo;

import org.orm.PersistentException;

import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.Registrado;

public class Buscador extends Buscador_ventana{
	/*private RadioButton _tituloRB;
	private RadioButton _categoriaRB;
	private RadioButton _etiquetaRB;
	private RadioButton _apodoRB;
	private TextField _buscarTF;*/
	Cabecera_NR cnr = new Cabecera_NR();
	//Cabecera_R cr = new Cabecera_R();
	public Pag_Inicio_NR _unnamed_Pag_Inicio_NR_;
	public Buscador() {
		botonBuscar.addClickListener(new ClickListener() {	
			@Override
			public void buttonClick(ClickEvent event) {
				TipoBusqueda bus = null;
				if(rButons.isSelected("Usuarios")) {
					bus = TipoBusqueda.usuario;
				}
				if(rButons.isSelected("Categoria")) {
					bus = TipoBusqueda.categoria;
				}
				if(rButons.isSelected("Etiqueta")) {
					bus = TipoBusqueda.etiqueta;
				}
				if(rButons.isSelected("Descripcion")) {
					bus = TipoBusqueda.descripcion;
				}
				if(rButons.isSelected("Titulo") || rButons.isSelected(null)){
					bus = TipoBusqueda.titulo;
				}
				if(bus.toString() == "usuario") {
					MyUI.getCurrent().getNavigator().addView("Buscador_usuario", new Buscador_Usuario(tBuscador.getValue()));
					UI.getCurrent().getNavigator().navigateTo("Buscador_usuario");
				} else {
					MyUI.getCurrent().getNavigator().addView("Buscador_video", new Buscador_Video(tBuscador.getValue(), bus));
					UI.getCurrent().getNavigator().navigateTo("Buscador_video");
				}
			}
		});
	}
}