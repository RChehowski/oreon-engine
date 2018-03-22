package org.oreon.core.context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.oreon.core.math.Quaternion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RenderConfig {
	
	// render configurations
	private boolean wireframe;
	private boolean underwater;
	private boolean reflection;
	private boolean refraction;
	
	// post processing filter
	private boolean bloomEnabled;
	private boolean dephtOfFieldEnabled;
	
	// render settings
	private float sightRange;
	private Quaternion clipplane;
	
	private int multisamples;
	
	private int displayWidth;
	private int displayHeight;
	
	protected RenderConfig(){
		
		Properties properties = new Properties();
		try {
			InputStream stream = RenderConfig.class.getClassLoader().getResourceAsStream("render-config.properties");
			properties.load(stream);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		multisamples = Integer.valueOf(properties.getProperty("multisamples"));
		displayWidth = Integer.valueOf(properties.getProperty("display.width"));
		displayHeight = Integer.valueOf(properties.getProperty("display.height"));
	}
}