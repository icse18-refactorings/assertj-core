/*
 * Created on Sep 17, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.assertions.error;

import static junit.framework.Assert.assertEquals;
import static org.fest.util.Arrays.array;
import static org.fest.util.Collections.list;

import org.fest.assertions.description.Description;
import org.fest.assertions.internal.TestDescription;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for <code>{@link WhenDoesNotContainOnlyErrorFactory#newAssertionError(Description)}</code>.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class WhenDoesNotContainOnlyErrorFactory_newAssertionError_Test {

  private Description description;
  private WhenDoesNotContainOnlyErrorFactory factory;

  @Before public void setUp() {
    description = new TestDescription("Jedi");
    factory =
        new WhenDoesNotContainOnlyErrorFactory(list("Yoda", "Han"), array("Luke", "Yoda"), list("Luke"), list("Han"));
  }

  @Test public void should_create_AssertionError() {
    AssertionError error = factory.newAssertionError(description);
    String msg = "[Jedi] expected:<['Yoda', 'Han']> to contain only:<['Luke', 'Yoda']>; could not find:<['Luke']> and got unexpected:<['Han']>";
    assertEquals(msg, error.getMessage());
  }
}
