package ai.streamin.rectoolservice.graphql;

import ai.streamin.rectoolservice.result.Result;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ResultQuery implements GraphQLQueryResolver {

    private final ResultService resultService;

    public ResultQuery(final ResultService resultService) {
        this.resultService = resultService ;
    }

    public List<Result> getResults() {
        return this.resultService.getResults();
    }

    public List<Result> getMatchedResults() {
        return this.resultService.getMatchedResults();
    }

    public List<Result> getUnmatchedReference() {
        return this.resultService.getUnmatchedReference();
    }

    public List<Result> getUnmatchedCandidate() {
        return this.resultService.getUnmatchedCandidate();
    }
}