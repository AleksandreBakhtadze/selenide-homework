package ge.tbc.testautomation.steps.livecoding;

import ge.tbc.testautomation.pages.livecoding.blogPage;

public class blogSteps {

    private blogPage page;

    public blogSteps() {
        page = new blogPage();
        page.openUrl("https://www.tbcbank.ge/en/blogs");
    }


}
