package Codigo;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;

import diagramaclasesbd.BD_Principal;

public class Subir_Video extends Modificar_Video_ventana {

	public Cabecera_R _unnamed_Cabecera_R_;
	Modificar_Video mv = new Modificar_Video();
	ComboBox<diagramaclasesbd.Categoria> cbCategoria = new ComboBox<>();
	Label nombreCategoria = new Label("Hola");

	public iUsuario_Registrado ur = new BD_Principal();
	
	public Subir_Video() {
		modificarInformacion.setVisible(false);
		hURL.setVisible(true);
		etiqueta.setVisible(false);
		categoria.setVisible(false);
		
		@SuppressWarnings("unchecked")
		List<diagramaclasesbd.Categoria> listaCategorias = ur.cargarCategorias();

		cbCategoria.setCaption("Categorias");
		cbCategoria.setItems(listaCategorias);
		
		//cbCategoria.setItemIconGenerator(listaCategorias::get);

		vPropVideo.addComponent(cbCategoria);
		
		etiqueta.setVisible(true);
	}

	public void subirVideo(){


		String mini = miniatura.getValue();
		String titu = titulo.getValue();
		String cate = categoria.getValue();

		//vPropVideo.addComponent(nombreCategoria);
		String etique = etiqueta.getValue();
		String des = descripcion.getValue();
		String urls = url.getValue();
		java.util.Date utilDate = new java.util.Date();
		

		ur.subirVideo(1, mini, titu, cate, etique, des, urls, utilDate);
		
		

	}

	
	}
