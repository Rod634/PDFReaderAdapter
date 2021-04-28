package logic;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import client.Client;
import target.IDocument;

public class Logica {
	
	public  void Initialize(IDocument adapter, File file) throws IOException
	{
		Client cl = new Client(adapter);
		cl.open(file);
		cl.getEditor();
	}

  	public int LoadPlugins(File file) throws MalformedURLException, InstantiationException, IllegalAccessException,
	ClassNotFoundException, IOException {
		int op = -1;
		do
		{
			File currentDir = new File("./src/plugins");
			String []plugins = currentDir.list();
			int i;
			URL[] jars = new URL[plugins.length];
	
			for (i = 0; i < plugins.length; i++)
			{
			  jars[i] = (new File("./src/plugins" + plugins[i])).toURL(); 
			  if(plugins[i].split("\\.")[0].toLowerCase().contains("pdf") ) {
				  op = i+1;
			  }
			}
	
			URLClassLoader ulc = new URLClassLoader(jars);
	
			if (op != 0 && op != i+1)
			{
			  String adpterName = plugins[op-1].split("\\.")[0];
			  IDocument adapter = (IDocument) Class.forName("adapter" + "." + adpterName, true, ulc).newInstance();
			  Initialize(adapter, file);
			  op = 0;
			}
	
			if(op == -1) {
				return op;
			}
		} while (op != 0);
		return op;
  	}
}
