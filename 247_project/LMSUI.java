import java.util.Scanner;

public class LMSUI {
    private Scanner scanner;
    private LMSApplicationFacade lmsApp;
    public static void main(String[] args){
        LMSUI UI = new LMSUI();
        UI.run();
    }
    public LMSUI(){
        scanner = new Scanner(System.in);
        lmsApp = new LMSApplicationFacade();
    }
    public void run(){
        lmsApp.mainLoop(scanner);
    }
    public LMSApplicationFacade getLmsApp() {
        return lmsApp;
    }
    public Scanner getScanner() {
        return scanner;
    }
    public void setLmsApp(LMSApplicationFacade lmsApp) {
        this.lmsApp = lmsApp;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
