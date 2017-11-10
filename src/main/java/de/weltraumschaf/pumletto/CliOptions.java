package de.weltraumschaf.pumletto;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 *
 */
@Parameters(commandDescription = "Generates PlantUML files for given source.")
@SuppressWarnings("FieldCanBeLocal")
final class CliOptions {
    @Parameter(names = {"-s", "--source"}, description = "File or directory to process.", required = true)
    private String source = "";

    @Parameter(names = {"--subpackages"}, description = "Required if source is a directory.")
    private String subpackages = "";

    String getSource() {
        return source;
    }

    String getSubpackages() {
        return subpackages;
    }
}
