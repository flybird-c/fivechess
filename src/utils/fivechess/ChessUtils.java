package utils.fivechess;

import javafx.scene.shape.Circle;

import java.util.Stack;

public class ChessUtils {
    private static ChessUtils instance;
    private Stack<FiveChess> chessStack;//存储在栈中的棋子对象
    private Stack<Circle> circleStack;//在棋盘上代表棋子的圆形对象
    public boolean flag;

    private ChessUtils() {
        chessStack = new Stack<>();
        circleStack = new Stack<>();
    }

    public static ChessUtils getInstance() {
        if (instance == null) {
            instance = new ChessUtils();
        }
        return instance;
    }

    public Stack<FiveChess> getChessStack() {
        return chessStack;
    }
    public void setChessStack(Stack<FiveChess> chessStack) {
        this.chessStack = chessStack;
    }

    public Stack<Circle> getCircleStack() {
        return circleStack;
    }
    public void setCircleStack(Stack<Circle> circleStack) {
        this.circleStack = circleStack;
    }

    /**
     * 左上角的点应该是(70,35),右上角的(630,35) 630 = 70 + 14*40
     * 左下角的点应该是(70,595) 35+14*40, 右下角的点应该是(630,595)
     * 实际考虑 边界外 棋子半径的距离是可以点的.
     *
     * @param x 鼠标点击点的x轴坐标
     * @param y 鼠标点击点的y轴坐标
     * @return 如果这个点在棋盘范围之外返回为true, 否则返回false
     */
    public boolean checkChessOutOfRange(double x, double y) {
        if (x < 50 || x > 650 || y < 15 || y > 615) {
            System.out.println("越界!!");
            return true;
        }
        return false;
    }
    /**
     * 判断第i条水平线和第j条垂直线,相交的点是否已经有棋子存在!
     *
     * @param i 第i条水平线
     * @param j 第j条垂直线
     * @return 如果已经有棋子存在返回值为true, 否则为false
     */
    public boolean checkChessExistsAtCurrent(int i, int j) {
        for (FiveChess chess : chessStack) {
            if (chess.getX() == i && chess.getY() == j) {
                System.out.println("已有棋子");
                return true;
            }
        }
        return false;
    }
    /**
     * 判断游戏的输赢
     *
     * @param chess 当前落子
     * @return
     */
    public boolean judgeWinner(FiveChess chess) {
        return method1(chess) || method2(chess) || method3(chess) || method4(chess);
    }

    //-- 水平方向判断
    private boolean method1(FiveChess chess) {
        int count = 1;
        //-- 算左横线
        for (int k = 1; k < 5; k++) {
            if (chessStack.contains(new FiveChess(chess.getX() - k, chess.getY(), chess.getChessColor()))) {
                count++;
            } else {
                break;
            }
        }

        //-- 算右横线
        for (int k = 1; k < 5; k++) {
            if (chessStack.contains(new FiveChess(chess.getX() + k, chess.getY(), chess.getChessColor()))) {
                count++;
            } else {
                break;
            }
        }
        if (count >= 5) {
            return true;
        }
        return false;
    }

    //-- 垂直方向判断
    private boolean method2(FiveChess chess) {
        int count = 1;
        //-- 算上竖线
        for (int k = 1; k < 5; k++) {
            if (chessStack.contains(new FiveChess(chess.getX(), chess.getY() - k, chess.getChessColor()))) {
                count++;
            } else {
                break;
            }
        }
        //-- 算下竖线
        for (int k = 1; k < 5; k++) {
            if (chessStack.contains(new FiveChess(chess.getX(), chess.getY() + k, chess.getChessColor()))) {
                count++;
            } else {
                break;
            }
        }

        if (count >= 5) {
            return true;
        }
        return false;
    }

    //-- 正斜线方向判断  /
    private boolean method3(FiveChess chess) {
        int count = 1;
        for (int k = 1; k < 5; k++) {
            if (chessStack.contains(new FiveChess(chess.getX() - k, chess.getY() + k, chess.getChessColor()))) {
                count++;
            } else {
                break;
            }
        }
        //-- 算右上斜线
        for (int k = 1; k < 5; k++) {
            if (chessStack.contains(new FiveChess(chess.getX() + k, chess.getY() - k, chess.getChessColor()))) {
                count++;
            } else {
                break;
            }
        }
        if (count >= 5) {
            return true;
        }
        return false;
    }

    //-- 反斜线方向判断 \
    private boolean method4(FiveChess chess) {
        //-- 算左上斜线
        int count = 1;
        for (int k = 1; k < 5; k++) {
            if (chessStack.contains(new FiveChess(chess.getX() - k, chess.getY() - k, chess.getChessColor()))) {
                count++;
            } else {
                break;
            }
        }
        //-- 算右下斜线
        for (int k = 1; k < 5; k++) {
            if (chessStack.contains(new FiveChess(chess.getX() + k, chess.getY() + k, chess.getChessColor()))) {
                count++;
            } else {
                break;
            }
        }
        if (count >= 5) {
            return true;
        }
        return false;
    }

    /**
     * 清空棋盘
     */
    public void clearChessBoard() {
        circleStack.clear();
    }

    public void clearChessStack() {
        chessStack.clear();
    }

}

