package utils.fivechess;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author EDZ
 * 继承序列化接口，为存读档做准备，需要存储棋子对象和棋盘对象状态
 */
public class FiveChess implements Serializable {
    public static final long serialVersionUID = 1L;
    private int x;
    private int y;
    private String chessColor;


    public FiveChess(int x, int y, String chessColor) {
        this.x = x;
        this.y = y;
        this.chessColor = chessColor;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getChessColor() {
        return chessColor;
    }

    @Override
    public String toString() {
        return "FiveChess{" +
                "x=" + x +
                ", y=" + y +
                ", chessColor='" + chessColor + '\'' +
                '}';
    }


    private enum side {
        BLACK("黑方", false), WHITE("白方", true);
        private String name;
        private boolean value;

        side(String name, boolean value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public boolean isValue() {
            return value;
        }

        public void changeSide() {
            value = !value;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiveChess fiveChess = (FiveChess) o;
        return x == fiveChess.x &&
                y == fiveChess.y &&
                Objects.equals(chessColor, fiveChess.chessColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, chessColor);
    }
}
