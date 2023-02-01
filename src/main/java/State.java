import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class State {
    Set<Patient> fatal;
    Set<Patient> cured;
    Set<Patient> active;
    Set<Patient> total;

    public State(){
        fatal = new HashSet<>();
        cured = new HashSet<>();
        active = new HashSet<>();
        total = new HashSet<>();
    }

    public void upd(State newState){
        fatal.addAll(Optional.ofNullable(newState.fatal).orElse(new HashSet<>()));
        cured.addAll(Optional.ofNullable(newState.cured).orElse(new HashSet<>()));
        active.addAll(Optional.ofNullable(newState.active).orElse(new HashSet<>()));
        total.addAll(Optional.ofNullable(newState.total).orElse(new HashSet<>()));
    }

    private Set miniSetFactory(String status){
        switch (status){
            case "FATAL":
                return fatal;
            case "CURED":
                return cured;
            case "ACTIVE":
                return active;
        }
        return null;
    }

    private void removeExisting(Patient patient){
        if(fatal.contains(patient)) fatal.remove(patient);
        if(cured.contains(patient)) cured.remove(patient);
        if(active.contains(patient)) active.remove(patient);
        if(total.contains(patient)) total.remove(patient);
    }

    public void upd(Patient patient, String status){
        removeExisting(patient);
        Set toUpdateSet = miniSetFactory(status);
        total.add(patient);
        toUpdateSet.add(patient);
//        print();
    }

    public void print(){
        int count = total.size();
        System.out.println("Total " + count);
        count = cured.size();
        System.out.println("Cured " + count);
        count = fatal.size();
        System.out.println("Fatal " + count);
        count = active.size();
        System.out.println("Active" + count);
    }

}
