package cn.javadog.labs.springboot2.liquibase.migration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import liquibase.change.custom.CustomTaskChange;
import liquibase.database.Database;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.CustomChangeException;
import liquibase.exception.SetupException;
import liquibase.exception.ValidationErrors;
import liquibase.resource.ResourceAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 余勇
 * @date 2020-01-11 01:20
 * ava-based migrations
 */
public class CHANGE_SET_3_FixUsername implements CustomTaskChange {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(Database database) throws CustomChangeException {
        JdbcConnection connection = (JdbcConnection) database.getConnection();
        try (PreparedStatement psmt = connection.prepareStatement("SELECT id, username, password, create_time FROM users")) {
            try (ResultSet rs = psmt.executeQuery()) {
                while (rs.next()) {
                    String username = rs.getString("username");
                    if ("calm".equals(username)) {
                        Integer id = rs.getInt("id");
                        try (PreparedStatement updatePsmt = connection.prepareStatement("UPDATE users SET " +
                            "username = ? WHERE id = ?")){
                            updatePsmt.setString(1, "calm pro");
                            updatePsmt.setInt(2, id);
                            updatePsmt.executeUpdate();
                            logger.info("[migrate][更新 user({}) 的用户名({} => {})", id, username, "calm pro");
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getConfirmationMessage() {
        return null;
    }

    @Override
    public void setUp() throws SetupException {
    }

    @Override
    public void setFileOpener(ResourceAccessor resourceAccessor) {
    }

    @Override
    public ValidationErrors validate(Database database) {
        return null;
    }

}
