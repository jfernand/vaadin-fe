package com.hw.fe2;

import com.vaadin.annotations.Theme;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Service
	public static class MyService {
		public String sayHi() {
			return "Hello Spring Initializr!";
		}

	}

	@Theme("valo-metro")
	@SpringUI(path = "")
	public static class VaadinUI extends UI {

		@Autowired
		MyService myService;

		@Override
		protected void init(VaadinRequest request) {
            val root = new VerticalLayout();
            setContent(root);

            val titleBar = new HorizontalLayout();
            titleBar.setWidth("100%");
            root.addComponent(titleBar);

            val image = new Image("", new ThemeResource("images/logo.png"));
            titleBar.addComponent(image);
			val title = new Label("Fulfillment Engine");

			title.addStyleName(ValoTheme.LABEL_H1);
			titleBar.addComponent(title);
            titleBar.setExpandRatio(title, 1.0f);

			val titleComment = new Label("Logout");
			titleComment.setSizeUndefined(); // Take minimum space
			titleBar.addComponent(titleComment);

            val mainPane = new HorizontalLayout();
            root.addComponent(mainPane);
            root.setCaption("Main Pane");

            val tabSheet = new TabSheet();

            val tab1 = new VerticalLayout();
            val tab2 = new VerticalLayout();
            val tab3 = new VerticalLayout();
            val tab4 = new VerticalLayout();
            val tab5 = new VerticalLayout();

            tabSheet.addTab(tab1, "Search Winners");
            tabSheet.addTab(tab2, "Import blah");
            tabSheet.addTab(tab3, "Manage Email Templates");
            tabSheet.addTab(tab4, "Export Wins");
            tabSheet.addTab(tab5, "Logout");
            mainPane.addComponent(tabSheet);

        }

	}
}
