package tk.astris.weco.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class MainModInstallerTemplate {

	public static GUI1 gui1;
	public static String name = "";
	public static InputStream icon = null;
	public static boolean le = true;
	public static boolean launch = false;
	public static ArrayList<String> legalInformation = new ArrayList<String>();
	public static ArrayList<InputStream> files = new ArrayList<InputStream>();
	public static ArrayList<String> fileNames = new ArrayList<String>();
	public static File dir = new File(System.getProperty("user.home") + "/astris/weco/Installer/");
	public static File comp1 = new File(MainModInstallerTemplate.dir, "Component1.exe");
	public static File comp2 = new File(MainModInstallerTemplate.dir, "Component2.exe");
	public static File mcMods = new File(System.getProperty("user.home") + "/AppData/Roaming/.minecraft/mods");
	public static File mcLauncher = new File(System.getProperty("user.home") + "/AppData/Roaming/.minecraft/launcher.jar");


	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException{
		
		Reader reader = new Reader();
		
		gui1 = new GUI1();
		gui1.setVisible(true);
		
		if(!dir.exists()){
			dir.mkdirs();
		}
		
				
	}
	
}
