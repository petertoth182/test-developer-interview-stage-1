# Exercise
For the coding exercise, the goal is to test www.etsy.com using the template provided on https://github.com/soap6gal/qa-web-template.

The tasks are:

1.       To write and implement the remaining two scenarios in the search.feature file. The first scenario has been implemented to serve as an example. Candidates can modify the template as they see fit.
2.       To write (no need implement) the scenarios best suited for UI and API tests.

Candidates are welcomed to use their own framework however clear instructions on how to use and run the tests should also be provided.

# Solution

## UI tests
I chose the pageobject model for writing the tests. I used IntelliJ on Windows and I only run the tests in Chrome with Chromedriver.

The two implemented solutions are tagged with @solution in search.feature file<br />
FYI: I think the given scenarios for coding were deprecated on Etsy.com, that is why I changed them a little bit.<br />

Not implemented scenarios tagged with @wip:<br />
purchase.feature file: 1 scenario for testing purchasing an item<br />
account.feature fule: 3 scenarios for testing Etsy account<br />

## API tests

It can be found in api.feature file: 2 scenarios for testing REST API<br />
The first scenarios is implemented using Serenity-Rest-Assured lib.<br />

## Running tests

You need to set the path for Chromedriver in serenity.properties file:
`webdriver.chrome.driver = c:/path`<br />
eg.: `webdriver.chrome.driver = c:/chromedriver.exe`<br />

To run my scenarios tagged as 'solution' on Chrome:

`$ gradle clean test aggregate -Dcucumber.options="--tags @solution"`

## Reporting

View the report at target/site/serenity/index.html


