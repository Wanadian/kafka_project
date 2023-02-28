package fr.insa.api.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.insa.api.models.CountryStatistics;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class CountryStatisticsDeserializer implements Deserializer<CountryStatistics> {
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public CountryStatistics deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		CountryStatistics object = null;
		try {
			object = mapper.readValue(data, CountryStatistics.class);
		} catch (Exception exception) {
			System.out.println("Erreur de désérialization des octets " + exception);
		}
		return object;
	}

	@Override
	public void close() {
	}
}