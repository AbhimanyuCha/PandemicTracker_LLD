import java.util.*;

//Singleton Factory;
public class DiseaseDAO {
    Map<String, Disease> diseaseMap;
    private static DiseaseDAO instance = null;
    private DiseaseDAO(){
        diseaseMap = new HashMap<>();
    }

    public static DiseaseDAO getInstance() {
        if(Objects.isNull(instance))
            instance = new DiseaseDAO();
        return instance;
    }

    public Disease getDisease(String name){
        Disease disease = diseaseMap.get(name);
        if(Objects.isNull(disease)){
            disease = new Disease(name);
            diseaseMap.put(name , disease);
        }
        return disease;
    }
}
