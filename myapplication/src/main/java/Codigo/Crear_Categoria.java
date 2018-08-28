package Codigo;

import java.util.Optional;

import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;

import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;

public class Crear_Categoria extends Crear_Categoria_ventana{

	public Perfil_Propio_A _unnamed_Perfil_Propio_A_;
	public iAdministrador2 admin = new BD_Principal();
	
	public Crear_Categoria() {
		confirmar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				crearCategoria();
			}
		});
	}
	public void crearCategoria() {
		boolean catCreada = false;
		boolean ok = true;
		String nombreCategoria = tCategoria.getValue();
		if(comboEdad.isSelected(null)) {
			Notification.show("¡Debe seleccionar una edad!", Type.WARNING_MESSAGE);
			ok = false;
		}
		if(nombreCategoria == "") {
			Notification.show("¡Introduzca el nombre de la categoria!", Type.WARNING_MESSAGE);
			ok = false;
		}
		if(ok) {
			Optional<String> seleccion = comboEdad.getSelectedItem();
			int numeroEdad = Integer.parseInt(seleccion.get());
			catCreada = admin.crearCategoria(nombreCategoria,numeroEdad);
			if(catCreada) {
				Notification.show("¡Categoria creada correctamente!", Type.WARNING_MESSAGE);
			} else {
				Notification.show("¡Ya existe una categoria con ese nombre!", Type.WARNING_MESSAGE);
			}
		}
	}
}