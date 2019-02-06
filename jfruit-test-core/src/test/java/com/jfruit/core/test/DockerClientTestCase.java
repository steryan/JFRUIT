package com.jfruit.core.test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jfruit.core.utility.DockerSpotifyClient;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Image;

public class DockerClientTestCase {
	
	// Create a logger to append logs to file or console
	static Logger logger = LogManager.getLogger(DockerClientTestCase.class.getName());

	/**
	 * Test docker pull and docker list api calls
	 * @throws InterruptedException 
	 * @throws DockerException 
	 * @throws DockerCertificateException 
	 */
	@Test
	public void testDockerCommands() throws DockerException, InterruptedException, DockerCertificateException {
		
		logger.info("Start Test: DockerClientTestCase.testDockerCommands");
		
		DefaultDockerClient dc = DockerSpotifyClient.connect();

					
		String imageName = "busybox";;
		String tag = "latest";
				
	    String imageTags = imageName + ":" + tag;				
		
	    // Pull the image 
	    DockerSpotifyClient.pullImage(dc, imageName, tag);
		
		// Retrieve images from repository
		List<Image> images = DockerSpotifyClient.getImages(dc);
		
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
