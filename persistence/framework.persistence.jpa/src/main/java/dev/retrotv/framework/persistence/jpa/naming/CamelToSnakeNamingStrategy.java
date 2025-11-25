package dev.retrotv.framework.persistence.jpa.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategySnakeCaseImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.Locale;

public class CamelToSnakeNamingStrategy extends PhysicalNamingStrategySnakeCaseImpl {

    @Override
    public Identifier toPhysicalCatalogName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return toLowerCase(super.toPhysicalCatalogName(logicalName, jdbcEnvironment));
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return toLowerCase(super.toPhysicalSchemaName(logicalName, jdbcEnvironment));
    }

    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return toLowerCase(super.toPhysicalTableName(logicalName, jdbcEnvironment));
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return toLowerCase(super.toPhysicalSequenceName(logicalName, jdbcEnvironment));
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        return toLowerCase(super.toPhysicalColumnName(logicalName, jdbcEnvironment));
    }

    private Identifier toLowerCase(Identifier identifier) {
        if (identifier == null) {
            return null;
        }

        String name = identifier.getText().toLowerCase(Locale.ROOT);
        return Identifier.toIdentifier(name, identifier.isQuoted());
    }
}