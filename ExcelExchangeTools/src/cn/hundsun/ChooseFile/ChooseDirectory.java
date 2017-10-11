package cn.hundsun.ChooseFile;

import java.io.File;
import javax.swing.JFileChooser;

public class ChooseDirectory {
	
	public ChooseDirectory() {
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Ñ¡ÔñÄ¿Â¼");
		jfc.setDialogType(JFileChooser.OPEN_DIALOG);
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int res = jfc.showOpenDialog(null);
		if (res == JFileChooser.APPROVE_OPTION) {
			File dir = jfc.getSelectedFile();
			System.out.println(dir.getAbsolutePath());
		}
	}
}
