package db;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Driver;

@Data
@AllArgsConstructor
public class DataSource {

        private Driver jdbcDriver;
        private String connectionUrl;
        private String username;
        private String password;

        @Override
        public boolean equals(Object dataSource) {
            boolean result = false;
            if (dataSource instanceof DataSource) {
                result = getJdbcDriver().getClass().getName()
                        .equals(((DataSource) dataSource).getJdbcDriver().getClass().getName())
                        && getConnectionUrl().equals(((DataSource) dataSource).getConnectionUrl())
                        && getUsername().equals(((DataSource) dataSource).getUsername())
                        && getPassword().equals(((DataSource) dataSource).getPassword());
            }
            return result;
        }
}
