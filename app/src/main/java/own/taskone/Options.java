package own.taskone;

/**
 * Created by USER on 12-06-2017.
 */

public class Options {
    String Name,Type;
    Options(String Name, String Type){
           this.Name = Name;this.Type = Type;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }
}
