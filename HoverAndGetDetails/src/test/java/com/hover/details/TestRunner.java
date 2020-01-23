package com.hover.details;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "res/features", glue = "com.hover.details.steps", plugin = { "pretty",
		"json:target/cucumber-jvm-report/cucumber.json" }, monochrome = true)
public class TestRunner {

}
