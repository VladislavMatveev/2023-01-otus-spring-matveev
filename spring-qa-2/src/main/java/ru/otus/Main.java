package ru.otus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.config.ApplicationServiceSettingsProvider;
import ru.otus.service.ApplicationService;
import ru.otus.service.interfaces.IOService;
import ru.otus.service.interfaces.PrintService;
import ru.otus.service.interfaces.ReaderService;

@ComponentScan
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        ReaderService readerService = context.getBean(ReaderService.class);
        PrintService printService = context.getBean(PrintService.class);
        IOService ioService = context.getBean(IOService.class);
        ApplicationServiceSettingsProvider applicationServiceSettings = context.getBean(ApplicationServiceSettingsProvider.class);

        new ApplicationService(readerService, printService, ioService, applicationServiceSettings).run();
    }
}