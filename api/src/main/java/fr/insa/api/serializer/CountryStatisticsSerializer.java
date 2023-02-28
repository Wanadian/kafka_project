package fr.insa.api.serializer;

import java.util.Map;

import fr.insa.api.models.CountryStatistics;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CountryStatisticsSerializer implements Serializer<CountryStatistics> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {

	}

	@Override
	public byte[] serialize(String topic, CountryStatistics data) {
		byte[] retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			retVal = objectMapper.writeValueAsString(data).getBytes();
		} catch (Exception exception) {
			System.out.println("Erreur de sérialization de l objet " + data);
		}
		return retVal;
	}

	@Override
	public void close() {

	}

}