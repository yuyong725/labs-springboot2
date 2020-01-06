package cn.javadog.labs.springboot.dubbo.xml.filter;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.Method;

import cn.javadog.labs.springboot.dubbo.xml.core.ServiceException;
import cn.javadog.labs.springboot.dubbo.xml.core.ServiceExceptionEnum;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.ReflectUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.ListenableFilter;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * @author 余勇
 * @date 2020-01-06 20:20
 * 自定义过滤器，处理异常
 */
@Activate(group = CommonConstants.PROVIDER)
public class DubboExceptionFilter extends ListenableFilter {

    public DubboExceptionFilter() {
        super.listener = new ExceptionListenerX();
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return invoker.invoke(invocation);
    }

    static class ExceptionListenerX extends ExceptionListener {

        @Override
        public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
            // 发生异常，并且非泛化调用
            if (appResponse.hasException() && GenericService.class != invoker.getInterface()) {
                Throwable exception = appResponse.getException();
                // 如果是 ServiceException 异常，直接返回
                if (exception instanceof ServiceException) {
                    return;
                }
                // 如果是参数校验的 ConstraintViolationException 异常，则封装返回
                if (exception instanceof ConstraintViolationException) {
                    appResponse.setException(this.handleConstraintViolationException((ConstraintViolationException) exception));
                    return;
                }
            }
            // 其它情况，继续使用父类处理
            super.onResponse(appResponse, invoker, invocation);
        }

        private ServiceException handleConstraintViolationException(ConstraintViolationException ex) {
            // 拼接错误
            StringBuilder detailMessage = new StringBuilder();
            for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
                // 使用 ; 分隔多个错误
                if (detailMessage.length() > 0) {
                    detailMessage.append(";");
                }
                // 拼接内容到其中
                detailMessage.append(constraintViolation.getMessage());
            }
            // 返回异常
            return new ServiceException(ServiceExceptionEnum.INVALID_REQUEST_PARAM_ERROR,
                    detailMessage.toString());
        }

    }

    static class ExceptionListener implements Listener {

        private Logger logger = LoggerFactory.getLogger(ExceptionListener.class);

        @Override
        public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
            if (appResponse.hasException() && GenericService.class != invoker.getInterface()) {
                try {
                    Throwable exception = appResponse.getException();

                    // 如果是检查异常，直接抛出
                    if (!(exception instanceof RuntimeException) && (exception instanceof Exception)) {
                        return;
                    }
                    // 如果是方法签名上的异常，直接抛出
                    try {
                        Method method = invoker.getInterface().getMethod(invocation.getMethodName(), invocation.getParameterTypes());
                        Class<?>[] exceptionClassses = method.getExceptionTypes();
                        for (Class<?> exceptionClass : exceptionClassses) {
                            if (exception.getClass().equals(exceptionClass)) {
                                return;
                            }
                        }
                    } catch (NoSuchMethodException e) {
                        return;
                    }

                    // 如果方法签名上也找不到这个异常，就打印错误日志
                    logger.error("Got unchecked and undeclared exception which called by " + RpcContext.getContext().getRemoteHost() + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + exception.getClass().getName() + ": " + exception.getMessage(), exception);

                    // 如果异常和service服务在同一个jar包下，直接抛出，也就是service接口和异常都自定义在同一个模块，如API模块
                    String serviceFile = ReflectUtils.getCodeBase(invoker.getInterface());
                    String exceptionFile = ReflectUtils.getCodeBase(exception.getClass());
                    if (serviceFile == null || exceptionFile == null || serviceFile.equals(exceptionFile)) {
                        return;
                    }
                    // 如果是jdk的异常，也直接抛出
                    String className = exception.getClass().getName();
                    if (className.startsWith("java.") || className.startsWith("javax.")) {
                        return;
                    }
                    // 如果是dubbo的异常，也直接抛出
                    if (exception instanceof RpcException) {
                        return;
                    }

                    // 对于其它的，包起来，返回客户端
                    appResponse.setException(new RuntimeException(StringUtils.toString(exception)));
                    return;
                } catch (Throwable e) {
                    logger.warn("Fail to ExceptionFilter when called by " + RpcContext.getContext().getRemoteHost() + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + e.getClass().getName() + ": " + e.getMessage(), e);
                    return;
                }
            }
        }

        @Override
        public void onError(Throwable e, Invoker<?> invoker, Invocation invocation) {
            logger.error("Got unchecked and undeclared exception which called by " + RpcContext.getContext().getRemoteHost() + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + e.getClass().getName() + ": " + e.getMessage(), e);
        }

        // 用于测试
        public void setLogger(Logger logger) {
            this.logger = logger;
        }
    }

}
