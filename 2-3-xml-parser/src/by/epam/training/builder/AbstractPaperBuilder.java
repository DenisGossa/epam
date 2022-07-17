package by.epam.training.builder;

import by.epam.training.entity.*;
import by.epam.training.exception.*;
import org.apache.logging.log4j.*;

import java.util.*;

public abstract class AbstractPaperBuilder {
    protected static final Logger LOGGER = LogManager.getLogger(AbstractPaperBuilder.class);
    protected Set<Paper> papers;

    public AbstractPaperBuilder() {
        papers = new HashSet<Paper>();
    }

    public Set<Paper> getPapers() {
        return papers;
    }

    abstract public void buildSetPapers(String fileName) throws ParserException;
}
