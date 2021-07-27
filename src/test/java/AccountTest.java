import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountTest {

  @BeforeEach
  void setUp() throws NoSuchFieldException, IllegalAccessException {
    TestUtils.resetIdCounter(Opportunity.class);
  }

  @AfterEach
  void tearDown() {
  }

  private void resetPrivateStaticIntegerFieldToZero(Class aClass, String fieldName) {
    try {
      // get declared field - f.e. `private static int accountCount` of `Account`
      //using magic (aka Reflection)
      Field field = aClass.getDeclaredField(fieldName);
      // remove the `private` modifier
      field.setAccessible(true);
      // set the static field value to 0.
      // first argument is the class instance. Since we want the static field there is no instance, hence null.
      field.set(null, 0);
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }

  @Test
  void accountPropertiesHaveGivenValues() {
    var acc = new Account(Industry.PRODUCE, 10, "Berlin", "USA", Collections.emptyList(), Collections.emptyList());

    assertEquals(Industry.PRODUCE, acc.getIndustry());
    assertEquals(10, acc.getEmployeeCount());
    assertEquals("Berlin", acc.getCity());
    assertEquals("USA", acc.getCountry());
    assertNotNull(acc.getContactList());
    assertEquals(0, acc.getContactList().size());
    assertNotNull(acc.getOpportunityList());
    assertEquals(0, acc.getOpportunityList().size());
  }

  @Test
  void firstAccountGetsIdOne() {
    var acc = new Account(Industry.PRODUCE, 10, "Berlin", "USA", Collections.emptyList(), Collections.emptyList());
    assertEquals(1, acc.getId());
  }

  @Test
  void secondAccountGetsIdTwo() {
    var acc1 = new Account(Industry.PRODUCE, 10, "Berlin", "USA", Collections.emptyList(), Collections.emptyList());
    var acc2 = new Account(Industry.PRODUCE, 10, "Berlin", "USA", Collections.emptyList(), Collections.emptyList());
    assertEquals(1, acc1.getId());
    assertEquals(2, acc2.getId());
  }
}