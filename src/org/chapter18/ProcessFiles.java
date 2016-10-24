package org.chapter18;

import java.io.File;
import java.io.IOException;

/**
 * 更进一步的策略模式
 * @author Administrator
 *
 */
public class ProcessFiles {

	public interface Strategy {
		void precess(File file);
	}
	
	private Strategy strategy;
	private String ext;
	
	public ProcessFiles(Strategy strategy, String ext) {
		this.strategy = strategy;
		this.ext = ext;
	}
	
	public void start(String[] args) {
		try {
			if(args.length == 0) 
				processDirectoryTree(new File("."));
			else
				for(String arg : args) {
					File fileArg = new File(arg);
					if(fileArg.isDirectory())
						processDirectoryTree(fileArg);
					else{
						if(!arg.endsWith("." + ext))
							arg += "." + ext;
						strategy.precess(new File(arg).getCanonicalFile());
					}
				}
 		} catch(IOException e) {
 			throw new RuntimeException(e);
 		}
		
	}
	
	public void processDirectoryTree(File root) throws IOException {
		for(File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext))
			strategy.precess(file.getCanonicalFile());
	}
	
	public static void main(String[] args) {
		new ProcessFiles(new ProcessFiles.Strategy() {
			
			@Override
			public void precess(File file) {
				System.out.println(file);
			}
		}, "java").start(args);
	}
}
