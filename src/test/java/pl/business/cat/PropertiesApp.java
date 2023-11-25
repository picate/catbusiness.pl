package pl.business.cat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PropertiesApp {
	
	
	private String url;
	
	private String dbUrl;
	
	private String driver;
}
