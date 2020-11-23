package view.panel;

import control.PveClickController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.PropertiesUtils;
import utils.Resource;

public class MainView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //背景音乐
        //背景图片
        //按钮元素
        //元素间距
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        //居中
        vBox.setAlignment(Pos.CENTER);
        String[] btnames = {"单机游戏", "网络对战", "游戏设置", "退出游戏"};
        for (String btname : btnames) {
            Button button = new Button(btname);
            button.setPrefSize(100, 45);
            vBox.getChildren().add(button);
            EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Button button1 = (Button) event.getSource();
                    switch ((button1.getText())) {
                        case "单机游戏":
                            PveView pveView = new PveView();
                            Pane chessBoard = pveView.getChessBoard();
                            PveClickController pcc = new PveClickController(chessBoard);
                            break;
                        case "网络游戏":
                            break;
                        case "游戏设置":
                            break;
                        case "退出游戏":
                            break;
                    }
                }
            };
            button.setOnAction(eventHandler);

            primaryStage.setTitle("主界面");
            PveView pv = new PveView();
            Scene scene = new Scene(pv.getChessBoard(), PropertiesUtils.getDoubleProperties(Resource.Windows.WINDOW_WIDTH),
                    PropertiesUtils.getDoubleProperties(Resource.Windows.WINDOW_HEIGHT));
            primaryStage.show();
        }
    }
}
