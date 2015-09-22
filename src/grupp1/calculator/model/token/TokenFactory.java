package grupp1.calculator.model.token;

import grupp1.calculator.model.token.operators.unary.*;
import java.io.DataInputStream;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides a factory class that creates appropriate tokens from strings.
 * @author Philip Arvidsson (S133686)
 */
public class TokenFactory {

/**
 * Cache for faster look-up.
 */
private static Map<String, Class> op_token_cache = new HashMap<String, Class>();
    
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
    
    try (InputStream     is  = (InputStream)url.getContent();
         DataInputStream dis = new DataInputStream(is))
    {
        
    String s;
    while ((s = dis.readLine()) != null) {
        String class_name = s.substring(0, s.lastIndexOf('.'));
        Class clazz = Class.forName(package_name + "." + class_name);
        classes.add(clazz);
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
        return ((Token)ctor.newInstance(s));
    } catch (Exception e) {
        // Don't worry about this, it won't ever happen in my elite c0de.
        System.out.println(e.toString());
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
    
    // A sane person would cache all of this crap below... but hey, who cares
    // about performance!
    
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
