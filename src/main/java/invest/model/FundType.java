package invest.model;

/**
 * User: Bryan
 * Date: 6/29/14
 * Time: 11:44 PM
 */
public enum FundType {

    FSELX,

    YHOO;

    private static final String COMMA = ",";

    public static String commaSeparated() {
        StringBuilder sb = new StringBuilder();

        int limit = values().length - 1;

        for (int i = 0; i <= limit; i++) {

            sb.append("\"").append(values()[i]).append("\"");

            if (i != limit) {
                sb.append(COMMA);
            }
        }

        return sb.toString();
    }
}
