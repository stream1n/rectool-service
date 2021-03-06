package ai.streamin.rectoolservice.result;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity(name = "recResults")
@Data
public class Result {
	
    @Id
    String id;
    
	private long recTime;
	private String tradeId;
	private String book;
	private String pair;
	private boolean isCandidateMissing;
	private boolean isReferenceMissing;
	private double candidate;
	private double reference;
	private double diff;

	private transient  String formattedRecTime;

	// Getter and setter
	public String getFormattedRecTime() {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(getRecTime()), ZoneId.systemDefault()).toString();
	}

}
