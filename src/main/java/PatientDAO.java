import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//Singleton
public class PatientDAO {
    static PatientDAO instance = null;
    Map<String, Patient> patientMap = new HashMap<>();
    private PatientDAO() {}

    public static PatientDAO getInstance() {
        if(Objects.isNull(instance))
            instance = new PatientDAO();
        return instance;
    }

    public Patient getPatient(String name){
        return patientMap.get(name);
    }
}
