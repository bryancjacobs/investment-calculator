package invest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Bryan
 * Date: 6/29/14
 * Time: 11:44 PM
 */
public enum FundType {

    // 0 - 19
    FBIOX,
    FSPHX,
    FSAIX,
    FBMPX,
    FPHAX,
    FSRFX,
    FSCSX,
    FSHOX,
    FSVLX,
    FBSOX,
    FSPCX,
    FSRPX,
    FSMEX,
    FSRBX,
    FSCHX,
    FSCPX,
    FSELX,
    FSLBX,
    FSDAX,
    FCYIX,

    // 20 - 39
    FDLSX,
    FSHCX,
    FIUIX,
    FIDSX,
    FSUTX,
    FSAVX,
    FDFAX,
    FDCPX,
    FSPTX,
    FSCGX,
    FWRLX,
    FSTCX,
    FIREX,
    FRESX,
    FSLEX,
    FRIFX,
    FSDPX,
    FSDCX,
    FSNGX,
    FSENX,

    // 40 - 45
    FNARX,
    FSESX,
    FFGCX,
    FSAGX,
    FSRVX,
    FRXIX;

    private static final String COMMA = ",";

    public static String commaSeparated(int start, int end) {

        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("start and end must be greater than 0");
        }

        if (start > end) {
            throw new IllegalArgumentException("start must be less than end");
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= values().length - 1; i++) {
            if (i >= start && i <= end) {
                sb.append("\"").append(values()[i]).append("\"");

                if (i != end) {
                    sb.append(COMMA);
                }
            }
        }

        return sb.toString();
    }

    public static FundType[] commaToFundTypes(String commaSeparated) {
        String[] types = commaSeparated.replace("\"", "").split(",");

        List<FundType> fundTypes = new ArrayList<>();

        for (String type : types) {
            fundTypes.add(FundType.valueOf(type));
        }

        return fundTypes.toArray(new FundType[fundTypes.size()]);
    }
}
