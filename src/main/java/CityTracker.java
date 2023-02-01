import java.util.*;

public class CityTracker extends Tracker {
    Map<String, Set<String>> stateToCityMap;
    public CityTracker(Tracker next) {
        super(next);
        stateToCityMap = new HashMap<>();
    }

    @Override
    void update(Patient patient, Disease disease, String status, String country, String state, String city) {
        updateStrategy(patient, disease, city, status);

        Set<String> cities = stateToCityMap.get(state);
        if(Objects.isNull(cities)) cities = new HashSet<>();
        cities.add(city);
        stateToCityMap.put(state, cities);

        if(Objects.nonNull(this.nextTracker))
            this.nextTracker.update(patient, disease, status, country, state, city);
    }

    void print(String disease, String state){
        locToDiseaseToStateMap.entrySet().forEach(entry ->{
                    System.out.println(entry.getKey());
                    State tmpState = new State();
                    if(stateToCityMap.get(state).contains(entry.getKey()))
                        tmpState.upd(entry.getValue().get(disease));
                    tmpState.print();
        });
    }
}
