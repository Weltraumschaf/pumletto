package de.weltraumschaf.pumletto;

import de.weltraumschaf.commons.system.ExitCode;

/**
 * Implements the {@link ExitCode exit codes} for this application.
 *
 * @author Sven Strittmatter &lt;weltraumschaf@googlemail.com&gt;
 * @since 1.0.0
 */
enum ExitCodes implements ExitCode {
    FATAL;

    @Override
    public int getCode() {
        return 255;
    }
}
