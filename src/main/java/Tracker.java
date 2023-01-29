import java.util.Map;

public abstract class Tracker {
    protected Tracker nextTracker;
    Map<String, State> map;
    abstract void update();
    abstract void get();
    public Tracker(Tracker next){
        nextTracker = next;
    }
}
