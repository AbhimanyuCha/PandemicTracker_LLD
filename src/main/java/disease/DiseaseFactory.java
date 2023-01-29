package disease;

import java.util.Objects;

//Singleton Factory;
public class DiseaseFactory {
    private final Covid covid = new Covid();
    private final Flu flu = new Flu();
    private static DiseaseFactory instance = null;
    private DiseaseFactory(){}

    public static DiseaseFactory getInstance() {
        if(Objects.isNull(instance))
            instance = new DiseaseFactory();
        return instance;
    }

    public Disease getDisease(String name){
        switch (name){
            case "COVID" :
                return covid;
            case "FLU" :
                return flu;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
    }
}
