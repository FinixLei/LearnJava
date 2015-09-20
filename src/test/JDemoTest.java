package test;

import static org.junit.Assert.*;

import org.junit.*;

public class JDemoTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Annotation BeforeClass: -----------------");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Annotation AfterClass: -----------------");
    }

    @Before
    public void before() {
        System.out.println("Annotation Before");
    }

    @After
    public void after() {
        System.out.println("Annotation After");
    }

    @Test(timeout = 10000)
    public void testadd() {
        JDemo a = new JDemo();
        assertEquals(6, a.add(3, 3));
        System.out.println("in Test ---- testAdd()");
    }

    @Test
    public void testdivision() {
        JDemo a = new JDemo();
        assertEquals(3, a.division(6, 2));
        System.out.println("in Test ---- testDivision()");
    }

    @Ignore
    @Test
    public void test_ignore() {
        JDemo a = new JDemo();
        assertEquals(6, a.add(1, 5));
        System.out.println("in test_ignore()");
    }

    @Test
    public void teest_fail() {
        fail();
    }
}

class JDemo extends Thread {

    int result;

    public int add(int a, int b) {
        try {
            sleep(100);
            result = a + b;
        } catch (InterruptedException e) {
            System.err.println("InterruptedException: " + e.getMessage());
        }
        return result;
    }

    public int division(int a, int b) {
        return result = a / b;
    }
}
