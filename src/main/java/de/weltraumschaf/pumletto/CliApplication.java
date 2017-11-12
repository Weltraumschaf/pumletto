package de.weltraumschaf.pumletto;

import com.sun.tools.javadoc.Main;
import de.weltraumschaf.commons.application.ApplicationException;
import de.weltraumschaf.commons.application.InvokableAdapter;
import de.weltraumschaf.commons.jcommander.JCommanderImproved;
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
    private static final String USAGE = "-s|--source <file or dir> [--subpackages <subpackage>] [-h|--help]";
    private static final String DESCRIPTIONS = "Command line tool to generate PlantUML files from sources.";
    private static final String EXAMPLE = "pumletto -s ~/some-project/src/main/java --subpackages de";
    private final JCommanderImproved<CliOptions> cliArgs = new JCommanderImproved<>("pumletto", CliOptions.class);

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
        debug = true;
        final CliOptions options = cliArgs.gatherOptions(getArgs());

        if (options.isHelp()) {
            getIoStreams().print(cliArgs.helpMessage(USAGE, DESCRIPTIONS, EXAMPLE));
            return;
        }

        // https://docs.oracle.com/javase/8/docs/technotes/guides/javadoc/standard-doclet.html#runningprogrammatically
        Main.execute("javadoc", UMLDoclet.class.getName(), generateJavadocArguments(options));
    }

    private String[] generateJavadocArguments(final CliOptions options) throws ApplicationException {
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

        if (!options.getFormat().isEmpty()) {
            javadocOptions.add("-umlImageFormat");
            javadocOptions.add(options.getFormat());
        }

        javadocOptions.add("-umlSkipStandardDoclet");
        javadocOptions.add("true");

        return javadocOptions.toArray(new String[javadocOptions.size()]);
    }
}
