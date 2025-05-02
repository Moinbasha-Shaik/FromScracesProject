package in.basha.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WelcomeScheduler {

    @Scheduled(fixedRate = 20000)
    public void displayWelcomeMessage() {
        System.out.println("Welcome to From scratch - " + java.time.LocalDateTime.now());
    }
}
