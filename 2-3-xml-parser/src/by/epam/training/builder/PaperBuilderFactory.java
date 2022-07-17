package by.epam.training.builder;

import by.epam.training.exception.*;

public class PaperBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    public AbstractPaperBuilder createPaperBuilder(String typeParser) throws ParameterException, ParserException {
        try {
            TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
            switch (type) {
                case DOM:
                    return new PaperDOMBuilder();
                case STAX:
                    return new PaperStAXBuilder();
                case SAX:
                    return new PaperSAXBuilder();
                default:
                    throw new ParameterException(type.name() + " invalid argument");
            }
        } catch (IllegalArgumentException e) {
            throw new ParameterException(typeParser + " invalid argument");
        }
    }
}
