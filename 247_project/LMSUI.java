import java.util.Scanner;

public class LMSUI {
    private Scanner scanner;
    private LMSApplicationFacede lmsApp;
    public static void main(String[] args){
        LMSUI UI = new LMSUI();
        UI.run();
    }
    public LMSUI(){
        scanner = new Scanner(System.in);
        lmsApp = new LMSApplicationFacede();
    }
    public void run(){
        lmsApp.mainLoop(scanner);
    }
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
