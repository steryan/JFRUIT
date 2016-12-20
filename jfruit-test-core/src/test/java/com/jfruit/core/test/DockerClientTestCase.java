package com.jfruit.core.test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jfruit.core.utility.DockerClient;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Image;

public class DockerClientTestCase {
	
	// Create a logger to append logs to file or console
	static Logger logger = LogManager.getLogger(DockerClientTestCase.class.getName());

	/**
	 * Test docker pull and docker list api calls
	 * @throws InterruptedException 
	 * @throws DockerException 
	 */
	@Test
	public void testDockerCommands() throws DockerException, InterruptedException {
		
		logger.info("Start Test: DockerClientTestCase.testDockerCommands");
		DockerClient dc = new DockerClient();
						
		String imageName = "busybox";;
		String tag = "latest";
				
	    String imageTags = imageName + ":" + tag;				
		
	    // Pull the image 
		dc.pullImage(imageName, tag);
		
		// Retrieve images from repository
		List<Image> images = dc.getImages();
		
		//Image image;
		boolean found = false;
		
	    //Cycle through the images found
	    for(Image image : images) {
	        
	        if (image.repoTags().get(0).equals(imageTags)){
	        	logger.info("Found Image:" + image.repoTags().get(0));
	        	found=true;
	        }
	    }
		
	    // Assert Docker Image found 
	    Assert.assertTrue(found);	
	}

}
