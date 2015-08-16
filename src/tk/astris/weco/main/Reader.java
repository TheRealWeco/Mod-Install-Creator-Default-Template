package tk.astris.weco.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
	
	public Reader() throws IOException{
		try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("config.weco")))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	
		    	if(line.startsWith("files=")){
		    		line = line.replaceFirst("files=", "");
		    		String[] fS = line.split(";");
		    		
		    		for(int i = 0; i < fS.length; i++){
		    			String f = fS[i];
		    			File file = new File(f);
		    			MainModInstallerTemplate.files.add(getClass().getResourceAsStream(file.getName()));
		    			MainModInstallerTemplate.fileNames.add(file.getName());
		    		}
		    		
		    	}
		    	
		    	if(line.startsWith("icon=")){
		    		MainModInstallerTemplate.icon = getClass().getResourceAsStream("icon.png");
		    	}
		    	
		    	if(line.startsWith("legal=")){
		    		if(line.equals("legal=true")){
		    			MainModInstallerTemplate.le = true;
		    		}else{
		    			MainModInstallerTemplate.le = false;
		    		}
		    	}
		    	
		    	if(line.startsWith("titel=")){
		    		MainModInstallerTemplate.name = line.replaceFirst("titel=", "");
		    	}
		    	
		    	if(line.startsWith("launch=")){
		    		if(line.equals("launch=true")){
		    			MainModInstallerTemplate.launch = true;
		    		}else{
		    			MainModInstallerTemplate.launch = false;
		    		}
		    	}
		    	
		    }
		    br.close();
		}
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("legal.weco")))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	MainModInstallerTemplate.legalInformation.add(line);
		    }
			br.close();
		}
	}

}