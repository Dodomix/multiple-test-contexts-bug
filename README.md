# Multiple contexts in Spring test

This repository can be used to demonstrate an issue when using spring-webflux and running tests with multiple contexts.

The main code consists of a single controller to demonstrate calls to.

There are 3 tests included, each extending a base class with a single test which calls the controller and expects status 200. The middle test has a different Spring application context by changing a property value. 
It also has a @DirtiesContext annotation. The tests run on a random port and call the controller using that port.

### How to run

If tests are run in order (Test1 -> Test2 -> Test3), Test3 will fail. Each test by itself will pass.

Test1 creates an application context (which will be the same as the context in Test3). It passes.

Test2 creates a different application context (because of the property change) and clears it after the test (because of DirtiesContext). It passes.

Test3 reuses the application context from Test1, but receives a ConnectException when it tries to call the controller. It fails.
