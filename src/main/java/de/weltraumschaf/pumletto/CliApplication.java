package de.weltraumschaf.pumletto;

import com.sun.javadoc.*;
import de.weltraumschaf.commons.application.InvokableAdapter;
import com.sun.tools.javadoc.Main;

/**
 * This class provides the {@link #main(java.lang.String[]) main entry point} for the command line application.
 *
 * @author Sven Strittmatter &lt;weltraumschaf@googlemail.com&gt;
 * @since 1.0.0
 */
public final class CliApplication extends InvokableAdapter {
    /**
     * Dedicated constructor.
     *
     * @param args must not be {@code null}
     */
    public CliApplication(final String[] args) {
        super(args);
    }

    /**
     * Invoked from JVM.
     *
     * @param args CLI arguments
     */
    public static void main(final String[] args) {
        InvokableAdapter.main(new CliApplication(args));
    }

    @Override
    public void execute() throws Exception {
        Main.execute("",
            Analyzer.class.getName(),
            new String[] {"/Users/sst/src/private/pumletto/src/main/java/de/weltraumschaf/pumletto/CliApplication.java"});
    }

    // https://stackoverflow.com/questions/24727110/javadoc-source-file-parsing
    // https://docs.oracle.com/javase/8/docs/technotes/guides/javadoc/standard-doclet.html#runningprogrammatically
    public static class Analyzer extends Doclet {

        public static boolean start(RootDoc root) {
            for (ClassDoc classDoc : root.classes()) {
                System.out.println("Class: " + classDoc.qualifiedName());

                for (MethodDoc methodDoc : classDoc.methods()) {
                    System.out.println("  " + methodDoc.returnType() + " " + methodDoc.name() + methodDoc.signature());
                }
            }

            return false;
        }
    }
}
