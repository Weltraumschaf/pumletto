package de.weltraumschaf.pumletto;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * Command line options for this application.
 *
 * @author Sven Strittmatter &lt;weltraumschaf@googlemail.com&gt;
 * @since 1.0.0
 */
@Parameters(commandDescription = "Generates PlantUML files for given source.")
@SuppressWarnings("FieldCanBeLocal")
final class CliOptions {
    @Parameter(names = {"-s", "--source"}, description = "File or directory to process.", required = true)
    private String source = "";

    @Parameter(names = {"--subpackages"}, description = "Required if source is a directory.")
    private String subpackages = "";

    @Parameter(names = {"-h", "--help"}, description = "Show this help.", help = true)
    private boolean help;

    /**
     * The sources to generate UML for.
     * <p>It is either a single file or a directory.</p>
     *
     * @return never {@code null} or empty
     */
    String getSource() {
        return source;
    }

    /**
     * Optional subpackage to scan.
     * <p>Only necessary if {@link #getSource()} is a directory.</p>
     *
     * @return never {@code null}, maybe empty
     */
    String getSubpackages() {
        return subpackages;
    }

    /**
     * Whether to show help or not.
     *
     * @return false by default
     */
    boolean isHelp() {
        return help;
    }
}
