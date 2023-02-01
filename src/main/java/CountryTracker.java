import java.util.Objects;

public class CountryTracker extends Tracker{
    public CountryTracker(Tracker next) {
        super(next);
    }

    @Override
    void update(Patient patient, Disease disease, String status, String country, String state, String city) {
        updateStrategy(patient, disease, country, status);
        if(Objects.nonNull(this.nextTracker))
            this.nextTracker.update(patient, disease, status, country, state, city);
    }

    void print(String disease){
        locToDiseaseToStateMap.entrySet().forEach(entry ->{
            System.out.println(entry.getKey());
            State tmpState = new State();
            if(entry.getValue().containsKey(disease)) {
                tmpState.upd(entry.getValue().get(disease));
            }
            tmpState.print();
        });
    }
}
