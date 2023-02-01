import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class StateTracker extends Tracker{
    Map<String, Set<String>> countryToStateMap;
    public StateTracker(Tracker next) {
        super(next);
        countryToStateMap = new HashMap<>();
    }

    @Override
    void update(Patient patient, Disease disease, String status, String country, String state, String city) {
        updateStrategy(patient, disease, state, status);
        if(Objects.nonNull(this.nextTracker))
            this.nextTracker.update(patient, disease, status, country, state, city);
    }

    void print(String disease, String country){
        locToDiseaseToStateMap.entrySet().forEach(entry ->{
            System.out.println(entry.getKey());
            State tmpState = new State();

            entry.getValue().entrySet().forEach(
                    diseaseStateEntry ->
                            tmpState.upd(diseaseStateEntry.getValue()));
            tmpState.print();
        });
    }
}
