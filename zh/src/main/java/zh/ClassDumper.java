package zh;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ClassDumper {

    int i;
    public ClassDumper() {
        this.i = i;
    }

    public  String dump(final Class<?> cls){
        if (cls == null) {
            return "Üres Class";
        }

        Arrays.stream(cls.getDeclaredFields()).forEach(field -> System.out.println(field.getName()));
        for(int i = 0; i < fields.length; i++) {
            System.out.println("Field = " + fields[i]);
        }
        return  "semmi";
    }

}