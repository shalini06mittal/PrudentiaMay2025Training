package  oops;
import java.time.LocalDateTime;

/**
 * Call Detail Records
 * Prepaid user management system
 * Create 2 classes
 * 1. Plan -> name, callrate, smsrate, datarate
 * 2. Transaction -> type, amount, date(Local Date)
 */
public class CallDetails {

    private String caller;
    private String receiver;
    private String type;
    private LocalDateTime start;
    private LocalDateTime end;

    // constructors -> implicit default contructor
    // explicit default
    // constructor/ methods with the same name but
    // different type, no or sequence of parameter is called soverloading
    public CallDetails() {
        System.out.println("default constructor");
    }

    public CallDetails(String caller, String receiver, String type, LocalDateTime start, LocalDateTime end) {
        this.setCaller(caller);
        this.receiver = receiver;
        this.type = type;
        this.start = start;
        this.end = end;
    }

    // functions
    // getters and setters
    public void setCaller(String no){
        if(!no.startsWith("+91"))
            this.caller = "+91-"+no;
        else
            this.caller = no;
    }
    public String getCaller(){
        return  caller;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "CallDetails{" +
                "caller='" + caller + '\'' +
                ", receiver='" + receiver + '\'' +
                ", type='" + type + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
