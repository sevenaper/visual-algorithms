public class MontyHallExperiment
{
    private int N;

    public MontyHallExperiment(int N)
    {
        if (N <= 0)
        {
            throw new IllegalArgumentException("N must be larger than 0!");
        }
        this.N = N;
    }

    public void run(boolean changeDoor)
    {
        int wins = 0;
        for (int i = 0; i < N; ++i)
        {
            if (play(changeDoor))
            {
                wins++;
            }
        }
        System.out.println(changeDoor ? "Change the door" : "Not change the door");
        System.out.println("winning rate:" + (double) wins / N);
    }

    boolean play(boolean changeDoor)
    {
        // Door 0 1 2
        int prizeDoor = (int) (Math.random() * 3);
        int playerChoice = (int) (Math.random() * 3);
        if (playerChoice == prizeDoor)
        {
            return !changeDoor;
        }
        else
        {
            return changeDoor;
        }
    }

    public static void main(String[] args)
    {
        int N = 1000000;
        MontyHallExperiment exp = new MontyHallExperiment(N);
        exp.run(true);
        exp.run(false);
    }
}
