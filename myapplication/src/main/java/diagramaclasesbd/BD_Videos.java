package diagramaclasesbd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.commons.mail.HtmlEmail;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import diagramaclasesbd.Video;
import Codigo.TipoBusqueda;
import Codigo.Video2;

public class BD_Videos {
	public BD_Principal _bd_prin_videos;
	public Vector<Video> _contiene_videos = new Vector<Video>();
	public BD_Comentarios comentario = new BD_Comentarios();

	public List<diagramaclasesbd.Video> cargar_Videos_Masmegusta() throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<diagramaclasesbd.Video> lVideosMgusta = null;
		ArrayList<Integer> megusta = new ArrayList<Integer>();
		ArrayList<diagramaclasesbd.Video> resultado = new ArrayList<diagramaclasesbd.Video>();
		try {
			lVideosMgusta = VideoDAO.queryVideo(null, null);
			for(diagramaclasesbd.Video v : lVideosMgusta){
				megusta.add(v.getMegusta());
			}
			while(!megusta.isEmpty()) {
				int  max = -1;
				int pos = -1;
				for(int i = 0 ; i < megusta.size();i++) {
					int actual=megusta.get(i);
					if(actual > max) {
						max = actual;
						pos=i;
					}
				}
				resultado.add(lVideosMgusta.get(pos));
				lVideosMgusta.remove(pos);
				megusta.remove(pos);
			}
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return resultado;
	}

	public List cargar_Videos_Ultimos() throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<diagramaclasesbd.Video> lVideosUltimos = null;
		ArrayList<Date> ultimos = new ArrayList<Date>();
		ArrayList<diagramaclasesbd.Video> resultado = new ArrayList<diagramaclasesbd.Video>();
		try {
			lVideosUltimos = VideoDAO.queryVideo(null, null);
			for(diagramaclasesbd.Video v : lVideosUltimos){
				ultimos.add(v.getFechaCreacion());
			}
			while(!ultimos.isEmpty()) {
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
				Date max = formatoDelTexto.parse("0000-00-00");
				int pos = -1;
				for(int i = 0 ; i < ultimos.size();i++) {
					Date actual = ultimos.get(i);
					if(actual.compareTo(max) == 1) {
						max = actual;
						pos=i;
					}
				}
				resultado.add(lVideosUltimos.get(pos));
				lVideosUltimos.remove(pos);
				ultimos.remove(pos);
			}
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	public List<diagramaclasesbd.Video> buscar(String buscador, TipoBusqueda aTipoBusqueda) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<diagramaclasesbd.Video> lista = null;
		ArrayList<diagramaclasesbd.Video> resultado = new ArrayList<diagramaclasesbd.Video>();
		try {
			lista = VideoDAO.queryVideo(null, null);
			if(aTipoBusqueda.toString() == "titulo") {
				for(diagramaclasesbd.Video v : lista){
					if(v.getTitulo().contains(buscador)) {
						resultado.add(v);
					}
				}
			} else if(aTipoBusqueda.toString() == "categoria") {
				for(diagramaclasesbd.Video v : lista){
					if(v.getCategoria().getNombre().contains(buscador)) {
						resultado.add(v);
					}
				}
			} else if(aTipoBusqueda.toString() == "descripcion") {
				for(diagramaclasesbd.Video v : lista){
					if(v.getDescripcion().contains(buscador)) {
						resultado.add(v);
					}
				}
			}else if(aTipoBusqueda.toString() == "etiqueta") {
				for(diagramaclasesbd.Video v : lista){
					if(v.getEtiqueta().contains(buscador)) {
						resultado.add(v);
					}
				}
			}
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
		}
		return resultado;
	}

	public List cargar_Videos_Historial(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Videos_Relacionados(int aID) {
		throw new UnsupportedOperationException();
	}

	public List<Video> cargar_Videos_Suscriptores(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<Video> lista = new ArrayList<Video>();
		try {
			Usuario user = UsuarioDAO.getUsuarioByORMID(aID);
			//Devuelve los dos ultimos videos de los usuarios que esta suscrito
			for(Usuario susc : user.suscripciones.toArray()) {		
				try {			
					int ultimo = susc.prop_video_de.toArray().length -1;
					lista.add(susc.prop_video_de.toArray()[ultimo]);	
					lista.add(susc.prop_video_de.toArray()[ultimo-1]);		
				}catch(Exception e) {	
					
				}
		}			
			t.commit();
		}catch(Exception e) {
			t.rollback();
		}
		return lista;
	}

	public void subirVideo(int aID, String aMiniatura, String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aUrl, Date aFechaCreacion) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();

		try {
			Usuario r = UsuarioDAO.getUsuarioByORMID(aID);
			Video video = VideoDAO.createVideo();
			video.setMiniatura(aMiniatura);
			video.setTitulo(aTitulo);
			video.setEtiqueta(aEtiqueta);
			video.setDescripcion(aDescripcion);
			video.setUrl(aUrl);
			video.setFechaCreacion(aFechaCreacion);
			Categoria cate=null;	
			for(Categoria cat : CategoriaDAO.listCategoriaByQuery(null, null)) {
				if(cat.getNombre().equals(aCategoria)) {
					cate = cat;
				}
			}
			video.setCategoria(cate);
			video.setUsuario_video(r);

			VideoDAO.save(video);
			
			t.commit();
			
		} catch (Exception e) {
			t.rollback();
		}
	}

	public List cargar_Videos_Subidos(int aID) {
		throw new UnsupportedOperationException();
	}

	public List<Video> cargar_Videos_ListaReproduccion(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<Video> videos = new ArrayList<Video>();
		try {
			Lista_De_Reproduccion lista = Lista_De_ReproduccionDAO.getLista_De_ReproduccionByORMID(aID);
			for(Object v : lista.video.getCollection()) {
				Video vid = (Video) v;
				videos.add(vid);
			}
			t.commit();		
		} catch (Exception e) {
			t.rollback();
		}
		return videos;
	}

	public diagramaclasesbd.Video cargarDatosVideo(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		Video video = null;
		try {
			video = VideoDAO.getVideoByORMID(aID);			
			t.commit();		
		} catch (Exception e) {
			t.rollback();
		}
		return video;
	}

	public void modificarDatosVideo(int idVideo, String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aMiniatura) throws PersistentException {
	
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Video video = VideoDAO.getVideoByORMID(idVideo);
			Categoria cate=null;	
			for(Categoria cat : CategoriaDAO.listCategoriaByQuery(null, null)) {
				if(cat.getNombre().equals(aCategoria)) {
					cate = cat;
				}
			}
			video.setCategoria(cate);
			video.setMiniatura(aMiniatura);
			video.setTitulo(aTitulo);
			video.setEtiqueta(aEtiqueta);
			video.setDescripcion(aDescripcion);
			VideoDAO.save(video);	
			t.commit();		
		} catch (Exception e) {
			t.rollback();
		}
	}

	public boolean darQuitarMegusta(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		boolean mg = false;
		try {
			diagramaclasesbd.Video video = diagramaclasesbd.VideoDAO.getVideoByORMID(aID);
			Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
			//video.setMegusta(video.getMegusta()+1);
			if(admon == null){
				Registrado regis = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
				Registrado reg = RegistradoDAO.getRegistradoByORMID(regis.getID());
				if(reg.me_gusta.contains(video)) {
					reg.me_gusta.remove(video);
					video.setMegusta(video.getMegusta()-1);
				} else {
					reg.me_gusta.add(video);
					video.setMegusta(video.getMegusta()+1);
					mg = true;
				}
				/*video.da_megusta.add(reg);
				reg.me_gusta.add(video);*/
				RegistradoDAO.save(reg);
			} else {
				Administrador adm = AdministradorDAO.getAdministradorByORMID(admon.getID());
				if(adm.me_gusta.contains(video)) {
					adm.me_gusta.remove(video);
					video.setMegusta(video.getMegusta()-1);
				} else {
					adm.me_gusta.add(video);
					video.setMegusta(video.getMegusta()+1);
					mg = true;
				}
				/*video.da_megusta.add(adm);
				adm.me_gusta.add(video);*/
				AdministradorDAO.save(adm);
			}
			VideoDAO.save(video);
			t.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			t.rollback();	
		}
		return mg;
	}

	public void quitarMegusta(int aID) {
		throw new UnsupportedOperationException();
	}

	public void borrarVideo(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Video vid = VideoDAO.getVideoByORMID(aID);
			Usuario admon = (Usuario) UI.getCurrent().getSession().getAttribute("admin");
			if(admon != null) {
					if((vid.getUsuario_video().equals(admon)) == false) {
						HtmlEmail email = new HtmlEmail();
						email.setHostName("smtp.gmail.com");
						email.setSmtpPort(200);
						email.setSSLOnConnect(true);			
						email.setAuthentication("modeladopruebaemail@gmail.com", "fcbarcelona92");
						email.setFrom("modeladopruebaemail@gmail.com");
						email.addTo(vid.getUsuario_video().getEmail());				
						email.setSubject("Eliminacion de video");
						String cuerpo="";
						cuerpo+="Se ha procedido a dar de baja su video: " + vid.getTitulo() + ".<br/><br/>"
								+ "Disculpe las molestias.<br/><br/><br/>" 
								+"Administrador: " + admon.getApodo();					
						email.setHtmlMsg(cuerpo);				
						email.send();
					}
			}
			List<Lista_De_Reproduccion> listas = Arrays.asList(Lista_De_ReproduccionDAO.listLista_De_ReproduccionByQuery(null, null));
			List<Usuario> usuarios = Arrays.asList(UsuarioDAO.listUsuarioByQuery(null, null));
			List<Comentario> comentarios = Arrays.asList(ComentarioDAO.listComentarioByQuery(null, null));
			for(Lista_De_Reproduccion lista : listas) {
				if(lista.video.contains(vid)) {
					lista.video.remove(vid);
				}
				Lista_De_ReproduccionDAO.save(lista);
			}
			for(Usuario usuario : usuarios) {
				if(usuario.me_gusta.contains(vid)) {
					usuario.me_gusta.remove(vid);
				}
				if(usuario.prop_video_de.contains(vid)) {
					usuario.prop_video_de.remove(vid);
				}
				UsuarioDAO.save(usuario);
			}
			for(Comentario comentario : comentarios) {
				if(comentario.getVideo().equals(vid)) {
					ComentarioDAO.delete(comentario);
				}
			}
			
			VideoDAO.delete(vid);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public List buscarVideo(String aTitulo) {
		throw new UnsupportedOperationException();
	}

	public void crearListaRep(String aTitulo, List aVideo) {
		throw new UnsupportedOperationException();
	}

	public void decargarVideo(int aID) {
		throw new UnsupportedOperationException();
	}

	public boolean videoPropio(int id,int iduser) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		//VER SI EL QUE HA INICIADO SESION ES ADMIN O NO
		boolean videop = false;
		try {
			diagramaclasesbd.Video v = VideoDAO.loadVideoByORMID(id);
			if(v.getUsuario_video().getID() == iduser || v.getUsuario_video().getID() == iduser)
			{
				videop = true;
			} 
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		return videop;
	}

	@SuppressWarnings("null")
	public List<Video> cargarVideosPropios(int iD) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<Video> videoProp = new ArrayList<Video>();
		try
		{
			for(Object video : UsuarioDAO.getUsuarioByORMID(iD).prop_video_de.getCollection())
			{
				Video videoAux;
				videoAux = (Video) video;
				videoProp.add(videoAux);
			}
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		return videoProp;
	}

	public void aumentarVisualizaciones(int idVideo) throws PersistentException{
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			Video vid = VideoDAO.getVideoByORMID(idVideo);
			vid.setVisualizaciones(vid.getVisualizaciones()+1);
			VideoDAO.save(vid);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
}