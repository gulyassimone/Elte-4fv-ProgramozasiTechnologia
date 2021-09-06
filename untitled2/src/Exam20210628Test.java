import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Exam20210628Test {
    @Test
    void test1 () throws NoSuchMethodException {
        Constructor c = MySuplier.class.getDeclaredConstructor();
        c.setAccessible(false);
        Assertions.assertThrows(IllegalAccessException.class, ()->{ c.getClass().newInstance();});

    }

    public void test2() throws NoSuchMethodException {
        MySuplier suplier = new MySuplier();
        Method useValue =
                suplier.getClass().getDeclaredMethod("get");
        Object[] margs = {null};
        Assertions.assertThrows(InvocationTargetException.class, ()->{useValue.invoke(suplier.getClass().newInstance(), margs);});
    }
    @Test
    void test3 (){
        Assertions.assertThrows(ClassNotFoundException.class, ()->{Class.forName("Suppli");});
    }
    @Test
    void test4 (){
        MySuplier suplier = new MySuplier();
        Assertions.assertThrows(NoSuchMethodException.class, ()->{suplier.getClass().getMethod("valami");});
    }
    @Test
    void test5 (){
        Exam20210628 a = new Exam20210628();
        MySuplier suplier = new MySuplier();
        Assertions.assertNull(a.ignoreExc(suplier));
    }

}
