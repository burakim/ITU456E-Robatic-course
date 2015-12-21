package response;

/**
 * Created by BurakMac on 21/12/15.
 */
public class RouteGetResponse {
    private int resultCode;
    /*
    58 - Result successfully initiated
    67 - Unsuccessful operated result.
     */
    private String message;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
