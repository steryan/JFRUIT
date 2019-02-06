package com.jfruit.core.utility;


import java.util.List;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient.ListContainersParam;
import com.spotify.docker.client.DockerClient.ListImagesParam;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Container;
import com.spotify.docker.client.messages.Image;

/**Docker client based on com.spotify.docker.client
 *  
 * @author sryan
 */
public class DockerSpotifyClient {

	/**
	 * Connect to docker daemon on a local host on Windows or Unix
	 * @return DefaultDockerClient 
	 * @throws DockerCertificateException
	 */
	public static DefaultDockerClient connect() throws DockerCertificateException {
				
		if (OsValidator.isWindows()) {
			// Connect to docker daemon on windows tcp://localhost:2375
			DefaultDockerClient docker = DefaultDockerClient.fromEnv().build();
			return docker;

		}else {
			// Connect to docker daemon on unix
			final DefaultDockerClient docker = new DefaultDockerClient("unix:///var/run/docker.sock");
			return docker;
		}

	}
	
	/**
	 * Return running docker containers  
	 * @param docker 
	 * @return
	 * @throws DockerException
	 * @throws InterruptedException
	 */
	public static List<Container> getRunningContainers(DefaultDockerClient docker) throws DockerException, InterruptedException{
	
		final List<Container> containers = docker.listContainers();
		
		return containers;
		
	}

	/**
	 * List docker images
	 * @param docker
	 * @return
	 * @throws DockerException
	 * @throws InterruptedException
	 */
	public static List<Image> getImages(DefaultDockerClient docker) throws DockerException, InterruptedException{
		
		final List<Image> images = docker.listImages(ListImagesParam.allImages());
		
		return images;

	}
	
	public static List<Container> listContainer(DefaultDockerClient docker) throws DockerException, InterruptedException{
		
		final List<Container> containers = docker.listContainers(ListContainersParam.allContainers());
		
		return containers;

	}
	
	/**
	 * Pull docker images for a given image name and tag
	 * @param docker
	 * @param image
	 * @param tag
	 * @throws DockerException
	 * @throws InterruptedException
	 */
	public static void pullImage(DefaultDockerClient docker, String image, String tag) throws DockerException, InterruptedException{
		
		docker.pull(image + ":" + tag);
	
	}	

	
}
