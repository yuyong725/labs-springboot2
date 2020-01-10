package cn.javadog.labs.springboot2.flyway.migration;

import org.flywaydb.core.api.callback.Callback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 余勇
 * @date 2020-01-11 00:30
 * 迁移回调
 */
@Component
public class ExampleFlywayCallback implements Callback {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public boolean supports(Event event, Context context) {
        return true;
    }

    @Override
    public boolean canHandleInTransaction(Event event, Context context) {
        return false;
    }

    @Override
    public void handle(Event event, Context context) {
        log.info("event: {}", event);
    }

}
