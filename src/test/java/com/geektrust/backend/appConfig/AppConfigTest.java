package com.geektrust.backend.appConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.geektrust.backend.commands.CommandInvoker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("ApplicatonConfig Test")
public class AppConfigTest {
    private ApplicationConfig applicationConfig;

    @BeforeEach
    void setup(){
        applicationConfig = new ApplicationConfig();
    }

    @Test
    @DisplayName("Should Return CommandInvoker Via GetCommandInvoker method")
    public void shouldReturnCommandInvokerViaGetCommandInvoker() {
        CommandInvoker commandInvoker=applicationConfig.getCommandInvoker();
        assertNotNull(commandInvoker);
    }
}