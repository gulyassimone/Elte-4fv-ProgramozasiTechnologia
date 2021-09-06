import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Exam20210628 {
    public Object ignoreExc(MySuplier mysuplier){
        try {
            return mysuplier.get();
        }catch (InvocationTargetException e){
            return null;
        }catch (IllegalAccessException e){
            return null;
        }catch (NoSuchMethodException e){
            return null;
        }catch (ClassNotFoundException  e){
            return null;
        }

    }
    public static Object[] getMethodInfo(String string){
        return Arrays.stream(string.split(" ")).collect(Collectors.toMap((a, b, c) -> Map.Entry::getKey,  Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

}
