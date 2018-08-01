package diagramaclasesbd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.vaadin.ui.UI;

import diagramaclasesbd.Video;
import Codigo.TipoBusqueda;
import Codigo.Video2;

public class BD_Videos {
	public BD_Principal _bd_prin_videos;
	public Vector<Video> _contiene_videos = new Vector<Video>();

	public List<diagramaclasesbd.Video> cargar_Videos_Masmegusta() throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		List<diagramaclasesbd.Video> lVideosMgusta = null;
		ArrayList<Integer> megusta = new ArrayList<Integer>();
		ArrayList<diagramaclasesbd.Video> resultado = new ArrayList<diagramaclasesbd.Video>();
		//int max = -1;
		//int pos = -1;
		//int cont = 0;
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
		//int max = -1;
		//int pos = -1;
		//int cont = 0;
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

	public List cargar_Videos_Suscriptores(int aID) {
		throw new UnsupportedOperationException();
	}

	public void subirVideo(int aID, String aMiniatura, String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aUrl, Date aFechaCreacion) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			diagramaclasesbd.Usuario r = diagramaclasesbd.UsuarioDAO.getUsuarioByORMID(aID);
			diagramaclasesbd.Video video = diagramaclasesbd.VideoDAO.createVideo();
			
			video.setMiniatura(aMiniatura);
			video.setTitulo(aTitulo);
			video.setEtiqueta(aEtiqueta);
			video.setDescripcion(aDescripcion);
			video.setUrl(aUrl);
			video.setFechaCreacion(aFechaCreacion);
			diagramaclasesbd.Categoria cate=null;	
			for(diagramaclasesbd.Categoria cat : CategoriaDAO.listCategoriaByQuery(null, null)) {
				if(cat.getNombre().equals(aCategoria)) {
					cate = cat;
				}
			}
			video.setCategoria(cate);
			video.setUsuario_video(r);
			diagramaclasesbd.VideoDAO.save(video);
			
			
			t.commit();
			
		} catch (Exception e) {
			t.rollback();
		}
	}

	public List cargar_Videos_Subidos(int aID) {
		throw new UnsupportedOperationException();
	}

	public List cargar_Videos_ListaReproduccion(int aID) {
		throw new UnsupportedOperationException();
	}

	public diagramaclasesbd.Video cargarDatosVideo(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		diagramaclasesbd.Video video = null;
		try {
			video = diagramaclasesbd.VideoDAO.getVideoByORMID(aID);			
			t.commit();		
		} catch (Exception e) {
			t.rollback();
		}
		return video;
	}

	public void modificarDatosVideo(String aTitulo, String aCategoria, String aEtiqueta, String aDescripcion, String aMiniatura) throws PersistentException {
	
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			diagramaclasesbd.Video video = diagramaclasesbd.VideoDAO.getVideoByORMID(1);
			diagramaclasesbd.Categoria cate=null;	
			for(diagramaclasesbd.Categoria cat : CategoriaDAO.listCategoriaByQuery(null, null)) {
				if(cat.getNombre().equals(aCategoria)) {
					cate = cat;
				}
			}
			video.setCategoria(cate);
			video.setMiniatura(aMiniatura);
			video.setTitulo(aTitulo);
			video.setEtiqueta(aEtiqueta);
			video.setDescripcion(aDescripcion);
			diagramaclasesbd.VideoDAO.save(video);	
			
			t.commit();		
		} catch (Exception e) {
			t.rollback();
		}
	}

	public void darMegusta(int aID) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		try {
			diagramaclasesbd.Video video = diagramaclasesbd.VideoDAO.getVideoByORMID(aID);
			Administrador admon = (Administrador) UI.getCurrent().getSession().getAttribute("admin");
			int nMeGusta = video.getMegusta();
			video.setMegusta(nMeGusta+1);
			if(admon == null)
			{
				Registrado regis = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
				video.da_megusta.add(regis);
				regis.me_gusta.add(video);
				RegistradoDAO.save(regis);
			} 
			else 
				
			{
				
				video.da_megusta.add(admon);
				admon.me_gusta.add(video);
				AdministradorDAO.save(admon);
			}
			
			VideoDAO.save(video);
			t.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		t.rollback();	
		}

	}

	public void quitarMegusta(int aID) {
		throw new UnsupportedOperationException();
	}

	public void borrarVideo(int aID) {
		throw new UnsupportedOperationException();
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

	public void eliminarVideoListaReproduccion(int aID) {
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
	public List cargarVideosPropios(int iD) throws PersistentException {
		PersistentTransaction t = diagramaclasesbd.Actividad11CabreraFuentesPersistentManager.instance().getSession().beginTransaction();
		Registrado registrado = (Registrado) UI.getCurrent().getSession().getAttribute("usuario");
		
		List listaVideos = null;
		List listaVideosPropios = null;
		diagramaclasesbd.Video video = null;
		try
		{
			listaVideos = VideoDAO.queryVideo(null, null);
			
			for(int i = 0; i<= listaVideos.size()-1;i++)
			{
				video = (Video)listaVideos.get(i);
				if(video.getUsuario_video() != null && video.getUsuario_video().equals(registrado))
				{
					listaVideosPropios.add(video);
				}
			}
			t.commit();
		}catch (Exception e) {
			t.rollback();
		}
		return listaVideosPropios;
	}

}