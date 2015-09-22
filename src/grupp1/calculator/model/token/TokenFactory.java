package grupp1.calculator.model.token;

import grupp1.calculator.model.token.operators.unary.*;
import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Provides a factory class that creates appropriate tokens from strings. This
 * is where all the magic happens. h4xx0rz $upr3m3!
 * @author Philip Arvidsson (S133686)
 */
public class TokenFactory {

/**
 * Cache for faster look-up.
 */
private static final Map<String, Class> op_token_cache = new HashMap<>();
    
/**
 * Extremely l33t uber hax for retrieving all classes in a package.
 * @return Array of classes.
 */
private static Class[] getClasses(String package_name) {
    List<Class> classes      = new ArrayList<>();
    ClassLoader class_loader = TokenFactory.class.getClassLoader();
    String      package_url  = package_name.replaceAll("[.]", "/");
    URL         url          = class_loader.getResource(package_url);
    
    // Basically, what we do is load all classes in the specified package...
    
    String jar_name;
    
    try {
        jar_name = TokenFactory.class.getProtectionDomain()
                              .getCodeSource().getLocation().toURI().getPath();    
    }
    catch (Exception e) {
        // Might as well try...
        jar_name = "oomj-lab.jar";
    }
    
    try (FileInputStream fis = new FileInputStream(jar_name);
         JarInputStream  jar = new JarInputStream(fis))
    {
        
    JarEntry je;
    while ((je = jar.getNextJarEntry()) != null) {
        String name = je.getName();
        if (name.startsWith(package_url) && name.endsWith(".class")) {
            // We found a class. Let's load it.

            name = name.replace("/", ".").replace(".class", "");
            Class clazz = Class.forName(name);
            classes.add(clazz);
        }
    }
    
    }
    catch (Exception e) {
        System.out.println(e.toString());
        System.out.println(e.getStackTrace()[0].toString());
    }
    
    // Lousy hacky method because Java can't do type inference correctly.
    return (classes.toArray(new Class[0]));
}

/**
 * Instantiates a token.
 * @param clazz Token class to instantiate.
 * @param s Token constructor argument.
 * @return A new, shiny token!
 */
private static Token newToken(Class clazz, String s) {
    try {
        Constructor ctor = clazz.getDeclaredConstructor(String.class);
        return ((Token)ctor.newInstance(new Object[]{ s }));
    } catch (Exception e) {
        // Don't worry about this, it won't ever happen in my elite c0de.
        System.out.println(e.toString());
        System.out.println(e.getStackTrace()[0].toString());
    }

    
    return (null);
}
    
/**
 * Creates a token from the specified string. Returns null if a token could
 * not be created.
 * @param s String to create token from.
 * @return A token representing the specified string.
 */
public Token getToken(String s) {
    if (op_token_cache.containsKey(s))
        return newToken(op_token_cache.get(s), s);

    Class[] classes;
    
    // Binary operators.
    classes = getClasses("grupp1.calculator.model.token.operators.binary");
    for (Class clazz : classes) {
        Annotation a = clazz.getAnnotation(OperatorInfo.class);
        if (a != null && ((OperatorInfo)a).op().equals(s)) {
            op_token_cache.put(s, clazz);
            return newToken(clazz, s);
        }
    }
    
    // Unary operators.
    classes = getClasses("grupp1.calculator.model.token.operators.unary");
    for (Class clazz : classes) {
        Annotation a = clazz.getAnnotation(OperatorInfo.class);
        if (a != null && ((OperatorInfo)a).op().equals(s)) {
            op_token_cache.put(s, clazz);
            return newToken(clazz, s);
        }
    }
    
    // Constants.
    classes = getClasses("grupp1.calculator.model.token.operators.constants");
    for (Class clazz : classes) {
        Annotation a = clazz.getAnnotation(OperatorInfo.class);
        if (a != null && ((OperatorInfo)a).op().equals(s)) {
            op_token_cache.put(s, clazz);
            return newToken(clazz, s);
        }
    }
    
    // Variables.
    if (s.charAt(0) == '$')
        return new VarToken(s);
    
    // Numbers.
    try                             { Double.parseDouble(s); }
    catch (NumberFormatException e) { return null;           }
    
    return new OperandToken(s);
}

}
