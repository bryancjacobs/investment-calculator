package invest.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: Bryan
 * Date: 6/29/14
 * Time: 11:48 PM
 */
public class FundTypeTest {

    @Test
    public void shouldGet_1_3() {
        String actual = FundType.commaSeparated(1, 3);
        assertEquals("\"FSPHX\",\"FSAIX\",\"FBMPX\"", actual);

    }

    @Test
    public void shouldGet_20_39() {
        String actual = FundType.commaSeparated(20, 39);
        assertEquals("\"FDLSX\",\"FSHCX\",\"FIUIX\",\"FIDSX\",\"FSUTX\",\"FSAVX\",\"FDFAX\",\"FDCPX\",\"FSPTX\",\"FSCGX\",\"FWRLX\",\"FSTCX\",\"FIREX\",\"FRESX\",\"FSLEX\",\"FRIFX\",\"FSDPX\",\"FSDCX\",\"FSNGX\",\"FSENX\"", actual);
    }

    @Test
    public void shouldGet_1_1() {
        String actual = FundType.commaSeparated(0, 0);
        assertEquals("\"FBIOX\"", actual);
    }

    @Test
    public void shouldGetLastType() {
        int theEnd = FundType.values().length - 1;
        String actual = FundType.commaSeparated(theEnd, theEnd);
        assertEquals("\"FRXIX\"", actual);
    }

    @Test
    public void commaToFundType() {

        FundType[] types = FundType.commaToFundTypes(FundType.commaSeparated(0, FundType.values().length - 1));

        assertTrue(types.length == FundType.values().length);
    }
}
