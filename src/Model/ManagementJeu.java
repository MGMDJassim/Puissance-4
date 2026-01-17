package Model;

public class ManagementJeu {
    private static ModeJeu mode;

    public static void setMode(ModeJeu m){
        mode = m;
    }
    public static ModeJeu getMode() {
        return mode;
    }
}
