package Benicomp.Utils;

import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;

public class SelenideLogEvents implements LogEventListener {

    public void onEvent(LogEvent logs) {
        if (logs.getStatus() == LogEvent.EventStatus.PASS) {

            Log.pass("Action: " + logs.getElement() + " - " + logs.getSubject() + " - Time(" + logs.getDuration() + ")ms");
            //System.out.println(logs.getStatus()+"- Action: "+logs.getElement()+" - "+logs.getSubject()+" - Time("+logs.getDuration()+")ms");
        }
        if (logs.getStatus() == LogEvent.EventStatus.FAIL) {
            Log.fail("Action: " + logs.getElement() + " - " + logs.getSubject() + " - Time(" + logs.getDuration() + ")ms");
            Log.error(logs.getError().getMessage());
            //System.out.println(logs.getStatus()+"- Action: "+logs.getElement()+" - "+logs.getSubject()+" - Time("+logs.getDuration()+")ms");

        }
    }

}
