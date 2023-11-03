package com.example.multiplecontext;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

// force new context initialization
@TestPropertySource(properties = {"dummy-property = dummy-value"})
@DirtiesContext // this also clears something from the context which should be used in Test3, but it's not reinitialized
public class Test2 extends TestBase {
}
