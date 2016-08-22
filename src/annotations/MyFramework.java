package annotations;

import java.io.BufferedReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyFramework {

    public static void main(String[] args) throws Throwable {
//        System.setSecurityManager(new SecurityManager());
//        FileReader fr = new FileReader("README.md");
//        StuffClass sc = new StuffClass();
//        Class clazz = sc.getClass();

        BufferedReader fr = Files.newBufferedReader(
                Paths.get("ClassToLoad.txt"));
        String className;
        while ((className = fr.readLine()) != null) {
            try {
                Class clazz = Class.forName(className);
                Object sc = clazz.newInstance();
                Method[] methods = clazz.getDeclaredMethods();
                for (Method m : methods) {
                    System.out.println("Found method: " + m);
                    DoStuff ds = m.getAnnotation(DoStuff.class);
                    if (ds != null) {
                        System.out.println("Found DoStuff annotation!!!");
                        m.setAccessible(true);
                        m.invoke(sc);
                    }
                }
                Field [] fields = clazz.getDeclaredFields();
                for (Field f : fields) {
                    System.out.println("Found field " + f);
                    SetMe sm = f.getAnnotation(SetMe.class);
                    if (sm != null) {
                        System.out.println("Annotated!");
                        f.setAccessible(true);
                        f.set(sc, "New value set by framework");
                    }
                }
                System.out.println("Object after setting is " + sc.toString());
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class not found");
            }
        }

    }

}
