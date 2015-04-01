package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides testing support for the Index page.
 * @author Philip Johnson
 */
public class IndexPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Home Page digits");
  }

  /**
   * Check to see if Index page contains a contact.
   * @param firstName First name.
   * @param lastName Last name.
   * @param tel Telephone.
   * @param telType Telephone type.
   */
  public void hasContact(String firstName, String lastName, String tel, String telType) {
    assertThat(pageSource()).contains(firstName);
    assertThat(pageSource()).contains(lastName);
    assertThat(pageSource()).contains(tel);
    assertThat(pageSource()).contains(telType);
  }
  
}
