package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;

import diagramaclasesbd.BD_Principal;

public class Subir_Video extends Modificar_Video_ventana {

	public Cabecera_R _unnamed_Cabecera_R_;
	Modificar_Video mv = new Modificar_Video();
	Label nombreCategoria = new Label("Hola");

	public iUsuario_Registrado ur = new BD_Principal();
	
	public Subir_Video() {
		modificarInformacion.setVisible(false);
		hURL.setVisible(true);
		etiqueta.setVisible(false);
		
		@SuppressWarnings("unchecked")
		List <String> nombresCat = new ArrayList<String>();
		for(diagramaclasesbd.Categoria cat :  ur.cargarCategorias()) {
			nombresCat.add(cat.getNombre());
		}
		categoria.setItems(nombresCat);	
		etiqueta.setVisible(true);
	}

	public void subirVideo(){


		String mini = miniatura.getValue();
		String titu = titulo.getValue();
		Optional<String> seleccion = categoria.getSelectedItem();
		String cate = seleccion.get();
		//vPropVideo.addComponent(nombreCategoria);
		String etique = etiqueta.getValue();
		String des = descripcion.getValue();
		String urls = url.getValue();
		java.util.Date utilDate = new java.util.Date();
		

		ur.subirVideo(1, mini, titu, cate, etique, des, urls, utilDate);
		
		

	}

	
	}
