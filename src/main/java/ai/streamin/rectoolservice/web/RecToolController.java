package ai.streamin.rectoolservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.streamin.rectoolservice.result.Result;
import ai.streamin.rectoolservice.result.ResultRepository;

@RestController
public class RecToolController {

	  @Autowired
	  ResultRepository resultRepository;
	  
	  @RequestMapping("/getResults")
	  public List<Result> getResults() {
		  long latestRecTime = resultRepository.findTopByOrderByRecTimeDesc().get(0).getRecTime();
		  return resultRepository.findByRecTime(latestRecTime);
	  }
				
	  @RequestMapping("/getMissingReferenceResults")
	  public List<Result> getMissingReferenceResults() {
		  long latestRecTime = resultRepository.findTopByOrderByRecTimeDesc().get(0).getRecTime();
		  return resultRepository.findByRecTimeAndIsReferenceMissing(latestRecTime, true);
	  }
	  
	  @RequestMapping("/getMissingCandidateResults")
	  public List<Result> getMissingCandidateResults() {
		  long latestRecTime = resultRepository.findTopByOrderByRecTimeDesc().get(0).getRecTime();
		  return resultRepository.findByRecTimeAndIsCandidateMissing(latestRecTime, true);
	  }
	  
	  @RequestMapping("/getMatchedResults")
	  public List<Result> getMatchedResults() {
		  long latestRecTime = resultRepository.findTopByOrderByRecTimeDesc().get(0).getRecTime();
		  return resultRepository.findByRecTimeAndIsReferenceMissingAndIsCandidateMissing(latestRecTime, false, false);
	  }
	  
}
