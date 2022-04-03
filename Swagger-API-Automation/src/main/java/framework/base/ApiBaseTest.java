package framework.base;

import framework.listeners.Listener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;

@Listeners(value = {Listener.class})
public class ApiBaseTest {

    @BeforeMethod
    public void beforeMethod(Method method) {
        System.out.println("STARTING TEST: " + method.getName());
    }
}
