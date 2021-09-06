import zh.ClassDumper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //  ClassDumper object = new ClassDumper();
        //  ClassDumper k = new ClassDumper();
        //System.out.println(k.dump(object.getClass())); // Display the string.

        ClassDumper c = new ClassDumper();
        Class cls = c.getClass();

        // returns the array of Field objects
        Field[] fields = cls.getDeclaredFields();
        Arrays.stream(cls.toString().split(" ")).findFirst();
        System.out.println(cls.toString()+ "{");
        Arrays.stream(cls.getDeclaredClasses()).forEach(System.out::println);
        Arrays.stream(fields).forEach(field -> System.out.println(field.getType() + " " + field.getName() + ";"));
        Arrays.stream(cls.getDeclaredMethods()).forEach(field -> System.out.println(field.toString()));
        System.out.println("}");
        Method[] m = cls.getDeclaredMethods();
        Arrays.stream(cls.getDeclaredMethods()).forEach(elem -> System.out.println(elem.getGenericParameterTypes() +  elem.getGenericReturnType() + elem.getTypeParameters() + elem.getName() ));
       /* = Arrays.stream(cls.getDeclaredMethods()).forEach(field ->
                Arrays.stream(field.toString().split(" "))
                        .forEach(elem -> Arrays.stream(elem.split("\\.")).reduce((first, second) -> second).get()));*/
        String class_name = cls.toString().split(" ")[0] + " " + Arrays.stream(cls.toString().split(" ")[1].split("\\.")).reduce((first, second) -> second).get();
    }
}