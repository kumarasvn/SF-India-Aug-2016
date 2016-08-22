package annotations;

import java.io.BufferedReader;
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
        String className = fr.readLine();
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

    }

}
