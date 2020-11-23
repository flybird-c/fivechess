package view.panel;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import utils.PropertiesUtils;

import static utils.Resource.Windows.*;

/**
 * @author EDZ
 */
public class PveView extends VBox {
    private static final int CHESS_LINE=14;
    private HBox hBox;
    private Pane board;
    public Pane getChessBoard(){return board;}
    public PveView(){

        drawChessBoard();
    }

    private   void drawChessBoard() {
       board = new Pane();
        for (int i = 1; i <=CHESS_LINE ; i++) {
            Line xLine = new Line(70, 35 + i * 40, 630, 35 + i * 40);
            Line yLine = new Line(70 + i * 40, 35, 70 + i * 40, 595);

//            Line xLine=new Line(PropertiesUtils.getDoubleProperties(CHESS_BOARD_SPACING),PropertiesUtils.getDoubleProperties(CHESS_BOARD_SPACING)+i*PropertiesUtils.getDoubleProperties(CELL_SIZE),PropertiesUtils.getDoubleProperties(CHESS_BOARD_SPACING)+CHESS_LINE*CHESS_LINE,PropertiesUtils.getDoubleProperties(CHESS_BOARD_SPACING)+i*PropertiesUtils.getDoubleProperties(CELL_SIZE));
//            Line yLine=new Line(PropertiesUtils.getDoubleProperties(CHESS_BOARD_SPACING)+i* PropertiesUtils.getDoubleProperties(CELL_SIZE),PropertiesUtils.getDoubleProperties(CHESS_BOARD_SPACING),PropertiesUtils.getDoubleProperties(CHESS_BOARD_SPACING)+CHESS_LINE*CHESS_LINE+i*PropertiesUtils.getDoubleProperties(CELL_SIZE),PropertiesUtils.getDoubleProperties(CHESS_BOARD_SPACING));
            board.getChildren().addAll(xLine,yLine);
        }
    }
}
