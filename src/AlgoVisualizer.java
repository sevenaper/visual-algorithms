import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

public class AlgoVisualizer
{

    private static int DELAY = 5;
    private static int blockSide = 32;
    private MineSweeperData data;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int N, int M, int mineNumber)
    {

        // 初始化数据
        data = new MineSweeperData(N, M, mineNumber);
        int sceneWidth = M * blockSide;
        int sceneHeight = N * blockSide;
        // 初始化视图
        EventQueue.invokeLater(() ->
        {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(this::run).start();
        });
    }

    public static void main(String[] args)
    {

        int N = 20;
        int M = 20;
        int mineNumber = 20;

        AlgoVisualizer vis = new AlgoVisualizer(N, M, mineNumber);

    }

    // 动画逻辑
    private void run()
    {
        setData();
    }

    private void setData()
    {
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    private class AlgoKeyListener extends KeyAdapter
    {
    }

    private class AlgoMouseListener extends MouseAdapter
    {
    }
}
