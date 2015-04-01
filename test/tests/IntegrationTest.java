package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.IndexPage;
import tests.pages.NewContactPage;

import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

/**
 * Runs a server with a fake in-memory database to test the system.
 */
public class IntegrationTest {
  /** The port to be used for testing. */
  private final int port = 3333;

  /**
   * Check to see that Index page can be retrieved.
   */
  @Test
  public void testRetrieveIndexPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();
        IndexPage indexPage = new IndexPage(browser.getDriver(), port);
        browser.goTo(indexPage);
        indexPage.isAt();
      }
    });
  }

  /**
   * Check to see that we can display a new contact.
   */
  public void testCreateNewPage() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();
        IndexPage indexPage = new IndexPage(browser.getDriver(), port);
        NewContactPage contactPage = new NewContactPage(browser.getDriver(), port);
        browser.goTo(contactPage);
        contactPage.isAt();

        String firstName = "Danny";
        String lastName = "Weng";
        String tel = "808-429-7517";
        String telType = "Mobile";
        contactPage.createContact(firstName, lastName, tel, telType);
        browser.goTo(indexPage);
        indexPage.hasContact(firstName, lastName, tel, telType);
      }
    });
  }

}
