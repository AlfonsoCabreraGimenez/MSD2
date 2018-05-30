package Codigo;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class Cabecera_R extends Cabecera_R_ventana{
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	public Pag_Inicio_R _unnamed_Pag_Inicio_R_;
	public Subir_Video _unnamed_Subir_Video_;
	public Perfil_Propio_R _unnamed_Perfil_Propio_R_;
	public Perfil_Propio_A _unnamed_Perfil_Propio_A_;
	
	Subir_Video sv = new Subir_Video();
	
	public Cabecera_R() {
		botonSubirVideo.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {

				popup.setContent(subContent);
				subContent.addComponent(sv.vModificarDatosVideo);
				popup.center();
				popup.setWidth("720px");
				//popup.setClosable(false);
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);
			}
		});
	}
}