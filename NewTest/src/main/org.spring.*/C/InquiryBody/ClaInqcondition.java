package C.InquiryBody;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/27/13
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class ClaInqcondition {
    private String Kch;
    private String Kcm;

    public ClaInqcondition() {
    }


    public ClaInqcondition(String kch, String kcm) {
        Kch = kch;
        Kcm = kcm;
    }

    public String getKch() {
        return Kch;
    }

    public void setKch(String kch) {
        Kch = kch;
    }

    public String getKcm() {
        return Kcm;
    }

    public void setKcm(String kcm) {
        Kcm = kcm;
    }
}
