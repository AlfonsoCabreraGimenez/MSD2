package Codigo;

import javax.persistence.metamodel.ListAttribute;

import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import diagramaclasesbd.BD_Principal;

public class Lista_De_Reproduccion2 extends Lista_De_Reproduccion2_ventana{
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	
	/*private Label _nombreListaL;
	private Boton _nombreListaB;
	private Imagen _miniaturaI;
	private Boton _miniaturaB;*/
	public Lista_Listas_De_Reproduccion _unnamed_Lista_Listas_De_Reproduccion_;
	public Anadir_a_ListaReproduccion _unnamed_Anadir_a_ListaReproduccion_;
	public Lista_Videos_De_Reproduccion _unnamed_Lista_Videos_De_Reproduccion_;
	iUsuario_Registrado ur =new BD_Principal();
	iAdministrador2 admin = new BD_Principal();
	public int idLista=-1;
	
	
	public Lista_De_Reproduccion2(int id) {
		this.idLista = id;
		Conf_Eliminar_Lista confEliminarLista = new Conf_Eliminar_Lista();
		
		botonBorrar.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				popup.setContent(subContent);
				subContent.addComponent(confEliminarLista);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
				
				confEliminarLista.aceptar.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {
						confEliminarLista.borrarLista(idLista);
						popup.close();
						
					}
				});
				
				confEliminarLista.cancelar.addClickListener(new ClickListener() {
					
					@Override
					public void buttonClick(ClickEvent event) {
						popup.close();
						
					}
				});
				
			}
		});
		
		
	}
}