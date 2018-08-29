package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.orm.PersistentException;

import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Registrado;

public class Subir_Video extends Modificar_Video {

	public Cabecera_R _unnamed_Cabecera_R_;
	//Modificar_Video mv = new Modificar_Video(2,"");

	public iUsuario_Registrado ur = new BD_Principal();
	public iAdministrador2 admin = new BD_Principal();
	public Subir_Video() {
		inicializar();
		bMiniatura.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(tUrlMin.isEmpty()) {
					imagen.setSource(new ExternalResource("http://www.webdelcule.com/15-16/resutem15.jpg"));
				} else {
					imagen.setSource(new ExternalResource(tUrlMin.getValue()));
				}
			}
		});
		confirmar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				subirVideo();
			}
		});
	}
	public void inicializar() {
		modificarInformacion.setVisible(false);
		url.setVisible(true);
		tUrlMin.setPlaceholder("Url de la miniatura...");
		etiqueta.setVisible(true);
		
		List <String> nombresCat = new ArrayList<String>();
		for(diagramaclasesbd.Categoria cat :  ur.cargarCategorias()) {
			nombresCat.add(cat.getNombre());
		}
		categoria.setItems(nombresCat);
		categoria.setSelectedItem(null);
	}
	public void subirVideo(){
		boolean datosOk = true;
		if(categoria.isSelected(null)) {
			Notification.show("¡Debe seleccionar una categoria!", Type.WARNING_MESSAGE);
			datosOk = false;
		}
		String mini = tUrlMin.getValue();
		if(mini.isEmpty()) {
			mini = "http://www.webdelcule.com/15-16/resutem15.jpg";
		}
		String titu = titulo.getValue();
		String etique = etiqueta.getValue();
		String des = descripcion.getValue();
		String urls = url.getValue();
		if(titu.isEmpty() || etique.isEmpty() || des.isEmpty() || urls.isEmpty()) {
			Notification.show("¡Debe completar todos los campos!", Type.WARNING_MESSAGE);
			datosOk = false;
		}
		if(datosOk) {
			Optional<String> seleccion = categoria.getSelectedItem();
			String cate = seleccion.get();
			java.util.Date utilDate = new java.util.Date();
			Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
			int idUser = -1;
			if(admon == null) {
				Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
				idUser = registrado.getID();
				ur.subirVideo(idUser, mini, titu, cate, etique, des, urls, utilDate);

			} else {
				idUser = admon.getID();
				admin.subirVideo(idUser, mini, titu, cate, etique, des, urls, utilDate);
			}
		}
	}	
}
