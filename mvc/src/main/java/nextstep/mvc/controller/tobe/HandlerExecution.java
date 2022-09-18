package nextstep.mvc.controller.tobe;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import nextstep.mvc.view.ModelAndView;

public class HandlerExecution {

    private final Method method;

    public HandlerExecution(final Method method) {
        this.method = method;
    }

    public ModelAndView handle(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final Class<?> declaringClass = method.getDeclaringClass();
        final Object clazz = declaringClass.getDeclaredConstructor()
                .newInstance();
        return (ModelAndView) method.invoke(clazz, new Object[]{request, response});
    }
}
