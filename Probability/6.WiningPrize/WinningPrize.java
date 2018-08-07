public class WinningPrize
{
    private double chance;
    private int playTimes;
    private int N;
    public WinningPrize(double chance,int playTimes,int N)
    {
        if(chance < 0.0 || chance > 1.0)
            throw new IllegalArgumentException("chance must be between 0 and 1!");

        if(playTimes <= 0 || N <= 0)
            throw new IllegalArgumentException("playTime or N must be larger than 0!");

        this.chance = chance;
        this.playTimes = playTimes;
        this.N = N;
    }

    public void run(){

        int wins = 0;
        for(int i = 0 ; i < N ; i ++)
            if(play())
                wins ++;

        System.out.println("winning rate: " + (double)wins/N);
    }

    private boolean play(){
        for(int i = 0 ; i < playTimes ; i ++)
            if(Math.random() < chance)
                return true;
        return false;
    }


    public static void main(String[] args)
    {
        double chance = 0.2;
        int playTimes = 10;
        int N = 10000000;

        WinningPrize exp = new WinningPrize(chance, playTimes, N);
        exp.run();
    }
}
