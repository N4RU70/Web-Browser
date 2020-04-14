package browser;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//test
public class main extends Application  {


    public void start(Stage stage) {

        try {
            StackPane rootPane = new StackPane();

            stage.initStyle(StageStyle.UNDECORATED);

            stage.setTitle("JavaFX WebBrowser");

            WebView w = new WebView();

            Rectangle rect = new Rectangle();
            Rectangle rect1 = new Rectangle();

            rect.setX(10);
            rect.setY(20);
            rect.setWidth(w.getPrefWidth());
            rect.setHeight(.055*w.getPrefHeight());
            rect.setTranslateY(-.555*w.getPrefHeight());

            rect1.setX(10);
            rect1.setY(20);
            rect1.setWidth(w.getPrefWidth());
            rect1.setHeight(.055*w.getPrefHeight());
            rect1.setTranslateY(-.5*w.getPrefHeight());
            rect1.setFill(Paint.valueOf("#333333"));

            WebEngine e = w.getEngine();

            w.setMaxHeight(1.055*w.getPrefHeight());

            e.load("https://start.duckduckgo.com/?kak=-1&kal=-1&kao=-1&kaq=-1&kae=d");

            Menu m = new Menu("Window");

            MenuItem m1 = new MenuItem("New Tab");
            MenuItem m2 = new MenuItem("New Window");
            MenuItem m3 = new MenuItem("Close All");

            Menu m4 = new Menu("Quick Launch");

            MenuItem m5 = new MenuItem("DuckDuckGo");
            MenuItem m6 = new MenuItem("SearchEncrypt");

            m5.setOnAction(i -> e.load("https://start.duckduckgo.com/?kak=-1&kal=-1&kao=-1&kaq=-1&kae=d"));

            m6.setOnAction(i -> e.load("https://searchencrypt.com/home"));


            m.getItems().addAll(m1,m2,m3);

            m4.getItems().addAll(m5,m6);

            MenuBar mb = new MenuBar();

            Button x = new Button(" x ");
            Button s = new Button(" - ");
            Button bo = new Button(" □ ");

            m3.setOnAction(i -> System.exit(0));



            MenuBar wd = new MenuBar();
            TextField t = new TextField ();
            mb.getMenus().addAll(m,m4);
            Button b = new Button("Go");
            b.setOnAction(i -> e.load(t.getText()));


            mb.setTranslateY(-.5*w.getPrefHeight());
            wd.setTranslateX(.4355*w.getPrefWidth());
            wd.setTranslateY(-.555*w.getPrefHeight());
            wd.setMaxWidth(.15*w.getPrefWidth());
            t.setTranslateY(-.5*w.getPrefHeight());
            w.setTranslateY(.055*w.getPrefHeight());
            t.setTranslateX(.08*w.getPrefWidth());
            b.setTranslateY(-.5*w.getPrefHeight()-1);
            b.setTranslateX(.42*w.getPrefWidth());
            x.setTranslateY(-.555*w.getPrefHeight());
            s.setTranslateY(-.555*w.getPrefHeight());
            bo.setTranslateY(-.555*w.getPrefHeight());
            x.setTranslateX(.47*w.getPrefWidth());
            s.setTranslateX(.37*w.getPrefWidth());
            bo.setTranslateX(.42*w.getPrefWidth());


            rootPane.getChildren().addAll(rect,rect1,w,mb,t,b,s,bo,x);

            Scene scene = new Scene(rootPane, w.getPrefWidth(),
                    w.getPrefHeight()*1.16);
            scene.getStylesheets().add("browser/style.css");
            stage.setScene(scene);
            stage.setMinHeight(w.getPrefHeight()*1.16);
            stage.setMinWidth(w.getPrefWidth());
            stage.setMaxHeight(w.getPrefHeight()*1.16);
            stage.setMaxWidth(w.getPrefWidth());
            b.setMinSize(60,30);
            b.setMaxSize(60,30);

            t.setText(e.getLocation());
            t.setMaxWidth(.6*w.getPrefWidth());
            stage.show();

            final WebHistory history = e.getHistory();
            history.getEntries().addListener((ListChangeListener<WebHistory.Entry>) c -> {
                c.next();
                for (WebHistory.Entry e1 : c.getAddedSubList()) {
                    t.setText(e1.getUrl());
                }
            }
            );



        }

        catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }


}




