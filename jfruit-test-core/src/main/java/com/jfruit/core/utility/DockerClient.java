package com.jfruit.core.utility;


import java.util.List;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient.ListContainersParam;
import com.spotify.docker.client.DockerClient.ListImagesParam;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Container;
import com.spotify.docker.client.messages.Image;

/**Docker client
 *  
 * @author sryan
 *
 */
public class DockerClient{
	
	
	final DefaultDockerClient docker = new DefaultDockerClient("unix:///var/run/docker.sock");
		
	public List<Container> getRunningContainers() throws DockerException, InterruptedException{
	
		final List<Container> containers = docker.listContainers();
		
		return containers;
		
	}
	
	public List<Image> getImages() throws DockerException, InterruptedException{
		
		final List<Image> images = docker.listImages(ListImagesParam.allImages());
		
		return images;

	}
	
	public List<Container> listContainer() throws DockerException, InterruptedException{
		
		final List<Container> containers = docker.listContainers(ListContainersParam.allContainers());
		
		return containers;

	}
	
	public void pullImage(String image, String tag) throws DockerException, InterruptedException{
		
		docker.pull(image + ":" + tag);
	
	}	

	
}
