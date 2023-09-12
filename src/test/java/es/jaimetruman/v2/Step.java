package es.jaimetruman.v2;

import es.jaimetruman.MySQLQueryBuilder;
import lombok.AllArgsConstructor;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 *      COMP   CONC
 */

class Main {
    public static void main(String[] args) {
        Test<Integer> test = new Test<>();
        Type genericType = test.getClass().getGenericSuperclass();

        if (genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();

            for (Type typeArgument : typeArguments) {
                System.out.println(typeArgument.getTypeName());
            }
        }
    }

    static class Test<T> {
        public void xd(){
            Class<T> lol = (Class<T>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];

            System.out.println(lol.getName());
        }
    }
}

class Select {
    public static InitialSelectStep from(String table) {
        return new InitialSelectStep(new StringBuilder(String.format("SELECT * FROM %s ", table)));
    }
}

interface Step<COMP extends ComparationStep, CONC extends ConcatenationStep> {
    StringBuilder builder();

    COMP comparationStep(StringBuilder stringBuilder);

    CONC concatenationStep(StringBuilder stringBuilder);


    default String build() {
        return builder().toString();
    }
}

interface InitialStep<COMP extends ComparationStep, CONC extends ConcatenationStep> extends Step<COMP, CONC> {
    @Override
    default CONC concatenationStep(StringBuilder stringBuilder) {
        throw new IllegalArgumentException("Malformed API");
    }
}

interface ConcatenationStep<COMP extends ComparationStep, CONC extends ConcatenationStep> extends Step<COMP, CONC> {
    @Override
    default CONC concatenationStep(StringBuilder stringBuilder) {
        throw new IllegalArgumentException("Malformed API");
    }
}

interface ComparationStep<COMP extends ComparationStep, CONC extends ConcatenationStep> extends Step<COMP, CONC> {
    @Override
    default COMP comparationStep(StringBuilder stringBuilder) {
        throw new IllegalArgumentException("Malformed API");
    }
}

interface Where<COMP extends ComparationStep, CONC extends ConcatenationStep> extends InitialStep<COMP, CONC> {
    default COMP where(String field) {
        builder().append("WHERE ")
                .append(MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(field))
                .append(" ");

        return comparationStep(builder());
    }
}

interface Equal<COMP extends ComparationStep, CONC extends ConcatenationStep> extends ComparationStep<COMP, CONC> {
    default CONC equal(Object value) {
        builder().append("= ")
                .append(MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value))
                .append(" ");
        return concatenationStep(builder());
    }
}

interface And<COMP extends ComparationStep, CONC extends ConcatenationStep> extends ConcatenationStep<COMP, CONC> {
    default CONC and(Object value) {
        builder().append("AND ")
                .append(MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value))
                .append(" ");
        return concatenationStep(builder());
    }
}

interface Or<COMP extends ComparationStep, CONC extends ConcatenationStep> extends ConcatenationStep<COMP, CONC> {
    default CONC or(Object value) {
        builder().append("OR ")
                .append(MySQLQueryBuilder.getDatabaseTypeSerializerMapper().serialize(value))
                .append(" ");
        return concatenationStep(builder());
    }
}

@AllArgsConstructor
class InitialSelectStep implements InitialStep<SelectCompartionStep, SelectConcatenationStep>,
                                    Where<SelectCompartionStep, SelectConcatenationStep> {
    private final StringBuilder stringBuilder;

    @Override
    public StringBuilder builder() {
        return stringBuilder;
    }

    @Override
    public SelectCompartionStep comparationStep(StringBuilder stringBuilder) {
        return new SelectCompartionStep(stringBuilder);
    }
}

@AllArgsConstructor
class SelectConcatenationStep implements ConcatenationStep<SelectCompartionStep, SelectConcatenationStep>,
        And<SelectCompartionStep, SelectConcatenationStep>,
        Or<SelectCompartionStep, SelectConcatenationStep> {
    private final StringBuilder stringBuilder;

    @Override
    public StringBuilder builder() {
        return stringBuilder;
    }

    @Override
    public SelectConcatenationStep and(Object value) {
        return And.super.and(value);
    }

    @Override
    public SelectConcatenationStep or(Object value) {
        return Or.super.or(value);
    }

    @Override
    public SelectCompartionStep comparationStep(StringBuilder stringBuilder) {
        return new SelectCompartionStep(stringBuilder);
    }
}

@AllArgsConstructor
class SelectCompartionStep implements ComparationStep<SelectCompartionStep, SelectConcatenationStep>,
                                            Equal<SelectCompartionStep, SelectConcatenationStep> {
    private final StringBuilder stringBuilder;

    @Override
    public StringBuilder builder() {
        return stringBuilder;
    }

    @Override
    public SelectConcatenationStep concatenationStep(StringBuilder stringBuilder) {
        return new SelectConcatenationStep(stringBuilder);
    }
}





















































