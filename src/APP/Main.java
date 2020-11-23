package APP;

import javafx.application.Application;
import view.panel.MainView;

/**
 * @author EDZ
 */
public class Main {
    public static void main(String[] args) {
        //.class是反射机制
        Application.launch(MainView.class);
    }
}
