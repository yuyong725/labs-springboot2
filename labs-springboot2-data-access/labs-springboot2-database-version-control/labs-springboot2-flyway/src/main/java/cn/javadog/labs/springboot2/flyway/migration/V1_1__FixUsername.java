package cn.javadog.labs.springboot2.flyway.migration;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.flywaydb.core.api.MigrationVersion;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

/**
 * @author 余勇
 * @date 2020-01-11 00:43
 * 1.1版本
 * note 即使GG，也会留下记录，因此该class也是不能改的
 */
public class V1_1__FixUsername extends BaseJavaMigration {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void migrate(Context context) throws Exception {
        // 创建 JdbcTemplate ，方便 JDBC 操作
        JdbcTemplate template = new JdbcTemplate(context.getConfiguration().getDataSource());
        // 查询所有用户，如果用户名为 calm flyway ，则变更成 calm
        template.query("SELECT id, username, password, create_time FROM flyway_users", rs -> {
            // 遍历返回的结果
            do {
                String username = rs.getString("username");
                if ("calm flyway".equals(username)) {
                    Integer id = rs.getInt("id");
                    template.update("UPDATE flyway_users SET username = ? WHERE id = ?",
                            "calm", id);
                    logger.info("[migrate][更新 user({}) 的用户名({} => {})", id, username, "calm");
                }
            } while (rs.next());
        });
    }

    /**
     * 默认返回，是 null 。
     */
    @Override
    public Integer getChecksum() {
        return 11;
    }

    @Override
    public boolean canExecuteInTransaction() {
        // 默认返回，也是 true
        return true;
    }

    @Override
    public MigrationVersion getVersion() {
        // 默认按照约定的规则，从类名中解析获得。可以自定义
        return super.getVersion();
    }

}
