public class App {
    private final static DiseaseDAO diseaseRepo = DiseaseDAO.getInstance();
    private final static PatientDAO patientRepo = PatientDAO.getInstance();
    private static Tracker locationChainTracker;
    public App(){
        locationChainTracker =
                new CityTracker(
                    new StateTracker(
                            new CountryTracker(
                                    new WorldTracker(null))));
    }

    public void report(String ...args){
        Disease disease = diseaseRepo.getDisease(args[0]);
        Patient patient = patientRepo.getPatient(args[1]);
        String country = args[2];
        String state = args[3];
        String city = args[4];
        locationChainTracker.update(patient,disease,"ACTIVE",country,state,city);
    }

    public void cured(String args[]){
        Disease disease = diseaseRepo.getDisease(args[0]);
        Patient patient = patientRepo.getPatient(args[1]);
        String country = args[2];
        String state = args[3];
        String city = args[4];
        locationChainTracker.update(patient,disease,"CURED",country,state,city);
    }

    public void fatal(String args[]){
        Disease disease = diseaseRepo.getDisease(args[0]);
        Patient patient = patientRepo.getPatient(args[1]);
        String country = args[2];
        String state = args[3];
        String city = args[4];
        locationChainTracker.update(patient,disease,"FATAL",country,state,city);
    }

    public void showWorldSummary(){
        ((WorldTracker)locationChainTracker.nextTracker.nextTracker.nextTracker).print();
    }

    public void showWorldSummaryDiseaseBreakup(){
        //for every disease accumulate the worldTracker and print it.

    }

    public void showCountryBreakup(String disease){
        //for every disease accumulate the countryTracker and print it
        /*
        13. ShowCountryBreakup(“COVID-19”) =>
            a. China:
                i. Total : 3
                ii. Cured : 0
                iii. Fatality : 0
                iv. Active : 3
            b. India:
                i. Total : 5
                ii. Cured : 0
                iii. Fatality : 0
                iv. Active : 5
         */
        ((CountryTracker)locationChainTracker.nextTracker.nextTracker).print(disease);
    }

    public void showCityBreakup(String disease, String state){
        //for every disease accumulate the cityTracker and print it
        ((CityTracker)locationChainTracker).print(disease, state);
    }

    public void showStateBreakup(String disease, String country){
        //for every disease accumulate the cityTracker and print it
        ((StateTracker)locationChainTracker.nextTracker).print(disease, country);
    }

    public static void main(String[] args) {
        App app = new App();
        app.report("COVID-19", "P1", "China", "Hubei", "Wuhan");
        app.report("COVID-19", "P2", "China", "Hubei", "Wuhan");
        app.report("COVID-19", "P3", "China", "Jiangsu", "Shanghai");
        app.report("COVID-19", "P4", "India", "UP", "Agra");
        app.report("COVID-19", "P5", "India", "Karnataka", "Bangalore");
        app.report("COVID-19", "P7", "India", "Karnataka", "Bangalore");
        app.showCountryBreakup("COVID-19");
    }

}
