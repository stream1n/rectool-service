package ai.streamin.rectoolservice.result;

import java.util.List;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface ResultRepository extends DatastoreRepository<Result, String> {
	
	List<Result> findAll();
	List<Result> findTopByOrderByRecTimeDesc();
	List<Result> findByRecTime(long recTime);
	List<Result> findByRecTimeAndIsReferenceMissing(long recTime, boolean isReferenceMissing);
	List<Result> findByRecTimeAndIsCandidateMissing(long recTime, boolean isCandidateMissing);
	List<Result> findByRecTimeAndIsReferenceMissingAndIsCandidateMissing(long recTime, boolean isReferenceMissing, boolean isCandidateMissing);
}