package de.weltraumschaf.pumletto;

import com.beust.jcommander.Parameter;

/**
 * Command line options for this application.
 *
 * @author Sven Strittmatter &lt;weltraumschaf@googlemail.com&gt;
 * @since 1.0.0
 */
@SuppressWarnings( {"FieldCanBeLocal", "WeakerAccess"})
public final class CliOptions {

    @Parameter(names = {"-s", "--source"}, description = "File or directory to process.", required = true)
    private String source = "";

    @Parameter(names = {"--subpackages"}, description = "Required if source is a directory.")
    private String subpackages = "";

    @Parameter(names = {"-f", "--format"}, description = "The image format to generate from the puml files. If not set only the puml files will be generated. Supported are: PNG, SVG, EPS, LATEX.")
    private String format = "";

    @Parameter(names = {"-h", "--help"}, help = true)
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
     * The wanted image format.
     * <p>
     * By default empty which means no image generation.
     * </p>
     *
     * @return never {@code null}, maybe empty
     */
    String getFormat() {
        return format;
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
