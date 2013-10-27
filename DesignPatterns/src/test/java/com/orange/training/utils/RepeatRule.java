package com.orange.training.utils;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 27.10.2013
 * Time: 22:22
 * To change this template use File | Settings | File Templates.
 */
public class RepeatRule implements TestRule {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepeatRule.class);
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Repeat {
        public abstract int times();
    }

    private static class RepeatStatement extends Statement {

        private final int times;
        private final Statement statement;

        private RepeatStatement(int times, Statement statement) {
            this.times = times;
            this.statement = statement;
        }

        @Override
        public void evaluate() throws Throwable {
            for (int i = 0; i < times; i++) {
                LOGGER.info("Running case " + i);
                statement.evaluate();
            }
        }
    }

    @Override
    public Statement apply(Statement statement, Description description) {

        Statement result = statement;

        Repeat repeat = description.getAnnotation(Repeat.class);
        if (repeat != null) {
            result = new RepeatStatement(repeat.times(), statement);
        }

        return result;
    }
}
