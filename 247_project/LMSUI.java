import java.util.Scanner;

public class LMSUI {
    private Scanner scanner;
    private LMSApplicationFacede lmsApp;
    public LMSApplicationFacede getLmsApp() {
        return lmsApp;
    }
    public Scanner getScanner() {
        return scanner;
    }
    public void setLmsApp(LMSApplicationFacede lmsApp) {
        this.lmsApp = lmsApp;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
