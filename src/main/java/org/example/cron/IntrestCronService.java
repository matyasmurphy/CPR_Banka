package org.example.cron;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.facade.IntrestFacade;

import java.util.Timer;
import java.util.TimerTask;

@Singleton
public class IntrestCronService {
    private Timer timer;

    @Inject
    private IntrestFacade intrestFacade;

    public void IntrestTimer() {
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                intrestFacade.isSavingsAccount();
            }
        }, 0, 60000);
    }
}
