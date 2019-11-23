package ai.streamin.rectoolservice.graphql;

import ai.streamin.rectoolservice.result.Result;
import ai.streamin.rectoolservice.result.ResultRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultService {

    private final ResultRepository resultRepository ;

    public ResultService(final ResultRepository resultRepository) {
        this.resultRepository = resultRepository ;
    }

    @Transactional(readOnly = true)
    public List<Result> getResults() {
        long latestRecTime = resultRepository.findTopByOrderByRecTimeDesc().get(0).getRecTime();
        return resultRepository.findByRecTime(latestRecTime);
    }

    @Transactional(readOnly = true)
    public List<Result> getMatchedResults() {
        long latestRecTime = resultRepository.findTopByOrderByRecTimeDesc().get(0).getRecTime();
        return resultRepository.findByRecTimeAndIsReferenceMissingAndIsCandidateMissing(latestRecTime, false, false);
    }

    @Transactional(readOnly = true)
    public List<Result> getUnmatchedResults() {
        long latestRecTime = resultRepository.findTopByOrderByRecTimeDesc().get(0).getRecTime();
        return resultRepository.findByRecTimeAndIsReferenceMissingAndIsCandidateMissing(latestRecTime, true, true);
    }

    @Transactional(readOnly = true)
    public List<Result> getUnmatchedReference() {
        long latestRecTime = resultRepository.findTopByOrderByRecTimeDesc().get(0).getRecTime();
        return resultRepository.findByRecTimeAndIsReferenceMissing(latestRecTime, true);
    }

    @Transactional(readOnly = true)
    public List<Result> getUnmatchedCandidate() {
        long latestRecTime = resultRepository.findTopByOrderByRecTimeDesc().get(0).getRecTime();
        return resultRepository.findByRecTimeAndIsCandidateMissing(latestRecTime, true);
    }

}
