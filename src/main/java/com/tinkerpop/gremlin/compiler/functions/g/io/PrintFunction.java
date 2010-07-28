package com.tinkerpop.gremlin.compiler.functions.g.io;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.GPath;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class PrintFunction extends AbstractFunction<Boolean> {

    private static final String FUNCTION_NAME = "print";


    public Atom<Boolean> compute(final List<Operation> parameters) throws RuntimeException {

        for (Operation operation : parameters) {
            Atom atom = operation.compute();
            Object operationValue = atom.getValue();
            
            if (operationValue instanceof GPath) {
                for (Object o : (GPath) operationValue) {
                    System.out.println(o);
                }
            } else {
                System.out.println(atom);
            }
        }

        return new Atom<Boolean>(true);
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}