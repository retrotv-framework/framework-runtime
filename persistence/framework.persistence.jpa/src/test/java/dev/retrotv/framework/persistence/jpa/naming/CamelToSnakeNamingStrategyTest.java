package dev.retrotv.framework.persistence.jpa.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class CamelToSnakeNamingStrategyTest {

    private final CamelToSnakeNamingStrategy strategy = new CamelToSnakeNamingStrategy();
    private final JdbcEnvironment jdbcEnvironment = mock(JdbcEnvironment.class);

    @Test
    @DisplayName("카멜케이스 테이블명을 소문자 스네이크케이스로 변환한다")
    void test_toPhysicalTableName() {
        Identifier logical = Identifier.toIdentifier("OrderItem");

        Identifier physical = strategy.toPhysicalTableName(logical, jdbcEnvironment);

        assertThat(physical.getText()).isEqualTo("order_item");
    }

    @Test
    @DisplayName("카멜케이스 컬럼명을 소문자 스네이크케이스로 변환한다")
    void test_toPhysicalColumnName() {
        Identifier logical = Identifier.toIdentifier("createdAt");

        Identifier physical = strategy.toPhysicalColumnName(logical, jdbcEnvironment);

        assertThat(physical.getText()).isEqualTo("created_at");
    }
}
