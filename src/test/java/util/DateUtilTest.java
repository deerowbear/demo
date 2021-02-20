package util;

import com.demo.util.DateUtils;
import org.junit.*;


import java.text.SimpleDateFormat;

public class DateUtilTest {

    private static SimpleDateFormat dateFormat;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        dateFormat = new SimpleDateFormat(DateUtils.DateFormat.ISO_DATETIME_FORMAT.formatStr());
        dateFormat.setLenient(false);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSimpleDateFormat(){
        Assert.assertNotNull(dateFormat);
    }
}
