import java.awt.*;
public class AlgoVisualizer
{

    private final int DELAY = 40;
    private MonteCarloPiData data;
    private AlgoFrame frame;    // 视图
    private int N;


    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N)
    {

        if (sceneWidth != sceneHeight)
        {
            throw new IllegalArgumentException("this demo must be run in a square box");
        }
        Circle circle = new Circle(sceneWidth / 2, sceneHeight / 2, sceneWidth / 2);
        data = new MonteCarloPiData(circle);
        this.N = N;
        // 初始化视图
        EventQueue.invokeLater(() ->
        {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            new Thread(this::run).start();
        });
    }

    // 动画逻辑
    private void run()
    {

        for (int i = 0; i < N; i++)
        {
            if (i % 100 == 0)
            {
                frame.render(data);
                AlgoVisHelper.pause(DELAY);
                System.out.println(data.estimatePi());
            }

            int x = (int) (Math.random() * frame.getCanvasWidth());
            int y = (int) (Math.random() * frame.getCanvasHeight());
            data.addPoint(new Point(x, y));
        }
    }


    public static void main(String[] args)
    {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 100000;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
