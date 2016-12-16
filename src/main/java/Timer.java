/**
 * Created by ludwighandel on 2016-12-15.
 */
public class Timer {

    public long startTime;
    public long endTime;


    public Timer(){
        startTime = System.nanoTime();
    }

    public long stop(){
        endTime = System.nanoTime();
        long totalTime = endTime-startTime;
        return totalTime;
    }

}
