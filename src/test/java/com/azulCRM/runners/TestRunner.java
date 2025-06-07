package com.azulCRM.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.messages.types.Git;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/azulCRM/step_definitions",
        tags = "@SendMessage",
        dryRun = false,
        publish = true
)
public class TestRunner {}
