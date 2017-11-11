package de.weltraumschaf.pumletto;

import com.sun.javadoc.Doclet;
import com.sun.javadoc.RootDoc;
import de.weltraumschaf.commons.validate.Validate;
import nl.talsmasoftware.umldoclet.UMLDoclet;

/**
 * {@link Doclet} implementation which delegates to {@link UMLDoclet}.
 * <p>Useful links:</p>
 * <ul>
 * <li><a href"https://stackoverflow.com/questions/24727110/javadoc-source-file-parsing">Javadoc source file parsing</a></li>
 * </ul>
 *
 * @author Sven Strittmatter &lt;weltraumschaf@googlemail.com&gt;
 * @since 1.0.0
 */
public final class Analyzer extends Doclet {
    /**
     * Implementation invokes {@link UMLDoclet}.
     *
     * @param root must not be {@code null}
     * @return {@code true } on success
     * @see Doclet#start(RootDoc)
     */
    public static boolean start(final RootDoc root) {
        Validate.notNull(root, "root");
        return new UMLDoclet(root).generateUMLDiagrams();
    }
}
