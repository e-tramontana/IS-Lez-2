public class TestLogs extends MyTestSupport {
    private Logs lg = Logs.getInstance();

    public static void main(String[] args) {
        TestLogs tl = new TestLogs();
        tl.testSingl();
        tl.testAll();
        tl.testLast();
    }

    public void testSingl() {
        initLogs();
        Logs lg2 = Logs.getInstance();
        lg2.record("uno");
        lg2.record("due");
        assertEquals(lg.dumpLast(), "due", "logs singleton");
    }

    public void testLast() {
        initLogs();
        assertEquals(lg.dumpLast(), "three ", "logs last");
    }

    public void testAll() {
        initLogs();
        assertEquals(lg.dumpAll(), "one two three ", "logs all");
    }

    private void initLogs() {
        lg.empty();
        lg.record("one ");
        lg.record("two ");
        lg.record("three ");
    }
}