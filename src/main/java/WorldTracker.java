public class WorldTracker extends Tracker{
    private State worldSummary;
    public WorldTracker(Tracker nextTracker){
        super(nextTracker);
        worldSummary = new State();
    }

    @Override
    public void update(Patient patient, Disease disease, String status, String country, String state, String city) {
        worldSummary.upd(patient, status);
    }

    public void print(){
        worldSummary.print();
    }
}
