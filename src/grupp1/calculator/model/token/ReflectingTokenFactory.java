package grupp1.calculator.model.token;

/*
grupp1.calculator.model.token.TokenFactory
------------------------------------------
Helt perfekt att använda Factory design mönstret till era tokens. Ni var allt
sugna på att använda lite reflection, va? :) OK.

Ni vill dock inte repetera identisk kod, vilket ni gör i eran getToken() metod
när ni loopar igenom klasserna i era olika operators paket. Här vill ni flytta
in den identiska koden i en metod (eller så kan ni lägga till en yttre loop för
paketnamnen).

OBS! Lägg märke till att eran kod endast kommer att fungera om ni kör Java
applikationen från en JAR fil (annars får ni en FileNotFoundException eftersom
eran TokenFactory-kod inte hittar JAR filen i eran getClasses() metod
"FileInputStream fis = new FileInputStream(jar_name)". Ni måste hantera fallet
då eran Java applikation körs som en uppackad JAR fil också om ni vill att eran
applikation skall fungera i det generella fallet (dock distribueras vanligen
Java applikationer som JAR filer).

KOMMENTAR:

    Mja, reflection kändes passande för ändamålet. I annat fall hade vi ju bara
    ersatt en switch-sats med en annan. Som alla andra grupper! ;-)

    Visst, det är lite copy-paste på något ställe, jag fixar det.

    Att den endast fungerar vid körning från JAR är vi medvetna om - vi har även
    kod skriven (från när vi testade programmet i tidigare skede) som fungerar
    från debuggern.

    // Philip

*/

import grupp1.calculator.model.token.TokenFactory;
import grupp1.calculator.model.token.operators.unary.*;
import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
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
public class ReflectingTokenFactory implements TokenFactory {

/**
 * Cache for faster look-up.
 */
private static final Map<String, Class> op_token_cache = new HashMap<>();

/**
 * Extremely l33t uber hax for retrieving all classes in a package.
 * @return Array of classes.
 */
private static Class[] getClasses(String package_name) {
    package_name = package_name.replace(".", "/");

    List<Class> classes = new ArrayList<>();

    // Basically, what we do is load all classes in the specified package...

    String jar_name;

    try {
        jar_name = ReflectingTokenFactory.class.getProtectionDomain()
                              .getCodeSource().getLocation().toURI().getPath();
    }
    catch (Exception e) {
        // Might as well try...
        jar_name = "oomj-lab1.jar";
    }

    try (FileInputStream fis = new FileInputStream(jar_name);
         JarInputStream  jar = new JarInputStream(fis))
    {

    JarEntry je;
    while ((je = jar.getNextJarEntry()) != null) {
        String name = je.getName();
        if (name.startsWith(package_name) && name.endsWith(".class")) {
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
@Override
public Token getToken(String s) {
    if (op_token_cache.containsKey(s))
        return newToken(op_token_cache.get(s), s);

    // Variables.
    if (s.charAt(0) == '$')
        return new VarToken(s);

    // Binary operators.
    Token tok = getTokenInternal(s, "operators.binary");
    if (tok != null)
        return (tok);

    // Unary operators.
    tok = getTokenInternal(s, "operators.unary");
    if (tok != null)
        return (tok);

    // Constants.
    tok = getTokenInternal(s, "operators.constants");
    if (tok != null)
        return (tok);

    // Numbers.
    try                             { Double.parseDouble(s); }
    catch (NumberFormatException e) { return null;           }
    return new OperandToken(s);
}

/**
 * Creates an appropriate token for the specified string through means of
 * RTTI/reflection and some wizardry.
 * @param s Token string.
 * @param package_name Package (under grupp1.calculator.model.token) to look in.
 * @return A token, or null if one could not be created.
 */
private Token getTokenInternal(String s, String package_name) {
    package_name = "grupp1.calculator.model.token." + package_name;

    Class[] classes = getClasses(package_name);
    for (Class clazz : classes) {
        Annotation a = clazz.getAnnotation(OperatorInfo.class);
        if (a != null && ((OperatorInfo)a).op().equals(s)) {
            op_token_cache.put(s, clazz);
            return newToken(clazz, s);
        }
    }

    return (null);
}

}
