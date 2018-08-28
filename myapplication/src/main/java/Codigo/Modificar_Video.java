package Codigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Video;

public class Modificar_Video extends Modificar_Video_ventana{

	public Visualizacion_Video_Propio_AR _unnamed_Visualizacion_Video_Propio_AR_;
	Subir_Video_ventana svv = new Subir_Video_ventana();

	iUsuario_Registrado ur = new BD_Principal();
	iAdministrador2 adm = new BD_Principal();
	
	public Modificar_Video() {
		
	}
	
	public Modificar_Video(int idVideo, String pag) {
		inicializar();
		cargarModificarVideo(idVideo);
		
		bMiniatura.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(tUrlMin.getValue() == "") {
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
				modificarDatosVideo(idVideo);
				//Estabamos en la pagina de visualizacion y volvemos a ella con el video modificado
				if(pag == "PagVis" ) {
					MyUI.getCurrent().getNavigator().addView("Pagina_Visualizacion_Video_Propio_AR", new Visualizacion_Video_Propio_AR(idVideo));
					UI.getCurrent().getNavigator().navigateTo("Pagina_Visualizacion_Video_Propio_AR");
				}
				//Estabamos en la pagina de perfil propio Reg o Admin y volvemos a ella con el video modificado
				if(pag == "PagPerfil") {
					Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
					if(admon == null) {
						MyUI.getCurrent().getNavigator().addView("Perfil_Propio_R", new Perfil_Propio_R());
						UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_R");
					} else {
						MyUI.getCurrent().getNavigator().addView("Perfil_Propio_A", new Perfil_Propio_A());
						UI.getCurrent().getNavigator().navigateTo("Perfil_Propio_A");
					}
				}
			}
		});
	}
	public void inicializar() {
		url.setVisible(false);
		tUrlMin.setPlaceholder("Url de la miniatura...");
	}
	public void modificarDatosVideo(int idVideo) {
		String mini = tUrlMin.getValue();
		if(mini == "") {
			mini = "http://www.webdelcule.com/15-16/resutem15.jpg";
		}
		String titu = titulo.getValue();
		Optional<String> seleccion = categoria.getSelectedItem();
		String cate = seleccion.get();
		String etique = etiqueta.getValue();
		String des = descripcion.getValue();
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		if(admon == null) {
			ur.modificarDatosVideo(idVideo, titu, cate, etique, des, mini);
		} else {
			adm.modificarDatosVideo(idVideo, titu, cate, etique, des, mini);
		}
	}

	public void cargarModificarVideo(int idVideo) {
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		Video video;
		if(admon == null ) {
			video = ur.cargarDatosVideo(idVideo);
		} else {
			video = adm.cargarDatosVideo(idVideo);
		}
		titulo.setValue(video.getTitulo());
		List <String> nombresCat = new ArrayList<String>();
		for(diagramaclasesbd.Categoria cat :  ur.cargarCategorias()) {
			nombresCat.add(cat.getNombre());
		}
		tUrlMin.setValue(video.getMiniatura());
		imagen.setSource(new ExternalResource(video.getMiniatura()));
		categoria.setItems(nombresCat);
		categoria.setSelectedItem(video.getCategoria().getNombre());
		etiqueta.setValue(video.getEtiqueta());
		descripcion.setValue(video.getDescripcion());
	}
}