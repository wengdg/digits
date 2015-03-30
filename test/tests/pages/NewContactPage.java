package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides testing support for the Index page.
 * @author Philip Johnson
 */
public class NewContactPage extends FluentPage {
  private String url;

  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public NewContactPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/newcontact";
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("New Contact digits");
  }

  /**
   * Create a new contact for testing purposes.
   * @param firstName First name.
   * @param lastName Last name.
   * @param tel Telephone.
   */
  public void createContact(String firstName, String lastName, String tel) {
    fill("#firstName").with(firstName);
    fill("#lastName").with(lastName);
    fill("#tel").with(tel);
    submit("#submit");
  }
  
}
