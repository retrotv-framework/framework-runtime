package dev.retrotv.framework.persistence.jpa.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategySnakeCaseImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.Locale;

public class CamelToScreamingSnakeNamingStrategy extends PhysicalNamingStrategySnakeCaseImpl {

    @Override
    public Identifier toPhysicalCatalogName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return toUpperCase(super.toPhysicalCatalogName(logicalName, jdbcEnvironment));
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return toUpperCase(super.toPhysicalSchemaName(logicalName, jdbcEnvironment));
    }

    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return toUpperCase(super.toPhysicalTableName(logicalName, jdbcEnvironment));
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return toUpperCase(super.toPhysicalSequenceName(logicalName, jdbcEnvironment));
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return toUpperCase(super.toPhysicalColumnName(logicalName, jdbcEnvironment));
    }

    private Identifier toUpperCase(Identifier identifier) {
        if (identifier == null) {
            return null;
        }

        String name = identifier.getText().toUpperCase(Locale.ROOT);
        return Identifier.toIdentifier(name, identifier.isQuoted());
    }
}
