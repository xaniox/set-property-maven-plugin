package de.matzefratze123.setproperty;

import java.util.List;
import java.util.Properties;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "set-properties", defaultPhase = LifecyclePhase.VALIDATE)
public class SetPropertyMojo extends AbstractMojo {
	
	@Parameter(defaultValue = "${project}", readonly = true, required = true)
	private org.apache.maven.project.MavenProject project;
	
	@Parameter
	private List<Operation> operations;
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		Properties properties = project.getProperties();
		
		for (Operation operation : operations) {
			List<SetProperty> propertiesSet = operation.execute(properties);
			
			for (SetProperty prop : propertiesSet) {
				getLog().info("Setting property '" + prop.getProperty() + "' to '" + prop.getValue() + "'...");
			}
		}
	}

}
