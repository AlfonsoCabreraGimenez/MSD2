package Codigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import GY.MyUI;
import diagramaclasesbd.Administrador;
import diagramaclasesbd.BD_Principal;
import diagramaclasesbd.Lista_De_Reproduccion;
import diagramaclasesbd.Registrado;
import diagramaclasesbd.Usuario;
import diagramaclasesbd.Video;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Perfil_Propio_R extends Perfil_Propio_R_ventana implements View{
	Window popup = new Window();
	Window popup2 = new Window();
	
	VerticalLayout subContent = new VerticalLayout();
	VerticalLayout subContent2 = new VerticalLayout();
	
	/*public Video2 _unnamed_Video2_;
	public Usuario2 _unnamed_Usuario2_;
	public Cabecera_R _unnamed_Cabecera_R_;
	public Crear_Lista_Reproduccion _unnamed_Crear_Lista_Reproduccion_;
	public Modificar_Datos_Usuario _unnamed_Modificar_Datos_Usuario_;
	public Conf_Eliminar_Video _unnamed_Conf_Eliminar_Video_;
	Registrarse registro = new Registrarse();*/
	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_R cr = new Cabecera_R();
	Video2 v2 = new Video2(1);
	Modificar_Datos_Usuario mdu = new Modificar_Datos_Usuario();
	Crear_Lista_Reproduccion clr = new Crear_Lista_Reproduccion();
	iUsuario_Registrado ur = new BD_Principal();
	
	
	public Perfil_Propio_R() throws PersistentException{
		hCabeceraInicio.addComponent(cc.inicio);
		hCabeceraRegistrado.addComponent(cr.avatar);
		hCabeceraRegistrado.addComponent(cr.botonSubirVideo);
		hCabeceraRegistrado.addComponent(cr.botonCerrarSesion);
		//hPanel.addComponent(v2.vVerticalVideoGeneral);
		crearAdministrador.setVisible(false);

		inicializar();
		cargarPerfilPropioR();
	}
	
	void inicializar(){
		//hPanel.addComponent(v2.vVerticalVideoGeneral);
		categoria.setVisible(false);
		
		modificarDatos.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {

				popup.setContent(subContent);
				subContent.addComponent(mdu);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
			}
		});
		
		mdu.nuevo.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				mdu.modificarDatos();
				popup.close();
			}
		});
		
		
		crearListaReproduccion.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {

				popup2.setContent(subContent2);
				subContent2.addComponent(clr);
				popup2.center();
				popup2.setWidth("720px");
				//popup.setClosable(false);
				popup2.setModal(true);
				UI.getCurrent().addWindow(popup2);
			}
		});
		clr.cancelar.addClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				popup2.close();
			}
		});
		clr.confirmar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				clr.crearListaRep();
				popup2.close();
			}
		});

		
	}
	public void borrarVideo() {
		throw new UnsupportedOperationException();
	}

	public void cargarPerfilPropioR() throws PersistentException {
		int cont = 0, i = 0;
		Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
		if (admon == null)
		{
			Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
			int visitas = registrado.getVisitas();
			nVisitas.setValue(String.valueOf(visitas));
			//CARGAR VIDEOS PROPIOS
			apodo.setCaption(registrado.getApodo());
			nombre.setValue(registrado.getNombre());
			apellidos.setValue(registrado.getApellido1()+" "+registrado.getApellido2());
			email.setValue(registrado.getEmail());
			fNacimiento.setValue(String.valueOf(registrado.getFechaN()));
			imagen.setSource(new ExternalResource("https://github.com/AlfonsoCabreraGimenez/MSD2/blob/Prueba/myapplication/descarga.jpg?raw=true"));
			//CARGAR DATOS DE USUARIO con el id de sesion ya podemos hacerlo
			List<HorizontalLayout> listaH = new ArrayList<HorizontalLayout>();
			HorizontalLayout h = new HorizontalLayout();
			h.setWidth("100%");
			h.setHeight("-1px");
			listaH.add(h);
			vPanel1.addComponent(listaH.get(i));
			for(Video v : ur.cargarVideosPropios(registrado.getID()))
			{
				Video2 video = new Video2(v.getID());
				video.categoria.setValue(String.valueOf(v.getCategoria()));
				video.titulo.setCaption(v.getTitulo());
				Date fecha = v.getFechaCreacion();
				video.fechasubida.setValue(fecha.toString());
				Usuario us = (Usuario) v.getUsuario_video();
				video.usuario.setCaption(us.getNombre());
				video.etiqueta.setValue(v.getEtiqueta());
				listaH.get(i).addComponent(video);
				cont++;
				if(cont == 3) {
					HorizontalLayout h1 = new HorizontalLayout();
					h1.setWidth("100%");
					h1.setHeight("-1px");
					listaH.add(h1);
					i++;
					vPanel1.addComponent(listaH.get(i));
					cont = 0;
				}	
			}
		} 
		else 
		{
			//ESTO EN PRINCIPIO SOBRARIA AQUI, HABRIA QUE HACERLO EN LA PAG PERFIL_PROPIO_A
			//CARGAR VIDEOS PROPIOS
			nombre.setValue(admon.getNombre());
			apellidos.setValue(admon.getApellido1()+" "+admon.getApellido2());
			email.setValue(admon.getEmail());
			fNacimiento.setValue(String.valueOf(admon.getFechaN()));
			//CARGAR DATOS DE USUARIO con el id de sesion ya podemos hacerlo
			for(Video v : ur.cargarVideosPropios(admon.getID()))
			{
				Video2 video = new Video2(v.getID());
				video.categoria.setValue(String.valueOf(v.getCategoria()));
				video.titulo.setCaption(v.getTitulo());
				Date fecha = v.getFechaCreacion();
				video.fechasubida.setValue(fecha.toString());
				Usuario us = (Usuario) v.getUsuario_video();
				video.usuario.setCaption(us.getNombre());
				video.etiqueta.setValue(v.getEtiqueta());
				//hPanel.addComponent(video);
			int visitas = admon.getVisitas();
			nVisitas.setValue(String.valueOf(visitas));
			//CARGAR VIDEOS PROPIOS
			
			//CARGAR DATOS DE USUARIO con el id de sesion ya podemos hacerlo
			
		}
		}		
	}
}