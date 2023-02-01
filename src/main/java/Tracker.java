import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Tracker {
    protected Tracker nextTracker;
    Map<String,Map<Disease, State>> locToDiseaseToStateMap;
    abstract void update(Patient patient, Disease disease, String status, String country, String state, String city);
    public Tracker(Tracker next){
        locToDiseaseToStateMap = new HashMap<>();
        nextTracker = next;
    }

    public void updateStrategy(Patient patient, Disease disease, String place, String status){
        Map<Disease, State> diseaseStateMap = locToDiseaseToStateMap.get(place);
        if(Objects.isNull(diseaseStateMap)){
            //city is not present , making a new entry for this city with an empty disease state.
            diseaseStateMap = new HashMap<>();
            locToDiseaseToStateMap.put(place, diseaseStateMap);
        }

        State countState = diseaseStateMap.get(disease);
        if(Objects.isNull(countState)){
            //disease is not present in the given city, making a new entry for the countState of this disease.
            countState = new State();
            diseaseStateMap.put(disease, countState);
        }

        countState.upd(patient, status);
    }
}
