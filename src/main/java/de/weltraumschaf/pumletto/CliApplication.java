package de.weltraumschaf.pumletto;

import com.beust.jcommander.JCommander;
import com.sun.javadoc.*;
import de.weltraumschaf.commons.application.ApplicationException;
import de.weltraumschaf.commons.application.InvokableAdapter;
import com.sun.tools.javadoc.Main;
import de.weltraumschaf.commons.system.ExitCode;
import nl.talsmasoftware.umldoclet.UMLDoclet;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

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
    private CliApplication(final String[] args) {
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
        final CliOptions options = new CliOptions();
        final JCommander parser = new JCommander(options);
        parser.parse(getArgs());
        // https://docs.oracle.com/javase/8/docs/technotes/tools/unix/javadoc.html
        final Collection<String> javadocOptions = new ArrayList<>();

        if (Files.isDirectory(Paths.get(options.getSource()))) {
            javadocOptions.add("-sourcepath");
            javadocOptions.add(options.getSource());
            javadocOptions.add("-subpackages");

            if (options.getSubpackages().isEmpty()) {
                throw new ApplicationException(ExitCodes.FATAL, "Option --subpackages required for directory!");
            }

            javadocOptions.add(options.getSubpackages());
        } else {
            javadocOptions.add(options.getSource());
        }

        Main.execute("javadoc", Analyzer.class.getName(), javadocOptions.toArray(new String[javadocOptions.size()]));
    }

    // https://stackoverflow.com/questions/24727110/javadoc-source-file-parsing
    // https://docs.oracle.com/javase/8/docs/technotes/guides/javadoc/standard-doclet.html#runningprogrammatically
    public static final class Analyzer extends Doclet {

        public static boolean start(RootDoc root) {
            return new UMLDoclet(root).generateUMLDiagrams();
        }
    }

    public  enum ExitCodes implements ExitCode {
        FATAL;

        @Override
        public int getCode() {
            return 255;
        }
    }
}
