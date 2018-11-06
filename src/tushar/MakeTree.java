package tushar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Stack;

import javax.swing.JTree;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class MakeTree {
	private static FileSystemView fileSystemView;
	private static DefaultTreeModel treeModel;
	
	public static JTree makeTree() throws FileNotFoundException{
		
		
		//FileReader fr = new FileReader("C:\\Users\\KowserTusher\\workspace\\FileSystem");
		/*File  file = new File("C:\\Users\\KowserTusher\\workspace\\FileSystem");
		Stack<String> fileTree = new Stack<>();
		DefaultMutableTreeNode fileSystem=new DefaultMutableTreeNode("FileSystem");
		JTree tree  = new JTree(fileSystem);
		String [] allFile = null;
		//BufferedReader br = new BufferedReader();
		if(file.isDirectory()){
			allFile = file.list();
			for(String str : allFile){
				System.out.println(str);
				File fr = new File(str);
				if(fr.isDirectory()){
					System.out.println(str + "  Is A Directory");
					fileTree.push(str);
					DefaultMutableTreeNode dir=new DefaultMutableTreeNode(str);
					fileSystem.add(dir);
					
				}
				else {
					System.out.println(str + "  Is  Not A Directory");
					DefaultMutableTreeNode dir=new DefaultMutableTreeNode(str);
					fileSystem.add(dir);
					
				}
			}
		}
		*/
		 JTree tree;
		 DefaultMutableTreeNode root = new DefaultMutableTreeNode();
         treeModel = new DefaultTreeModel(root);

		File myroot = new File("C:\\Users\\KowserTusher\\workspace\\FileSystem");
        File[] roots = fileSystemView.getFiles(myroot, true);
        for (File fileSystemRoot : roots) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(fileSystemRoot);
            root.add( node );
            //showChildren(node);
            //
            File[] files = fileSystemView.getFiles(fileSystemRoot, true);
            for (File file : files) {
                if (file.isDirectory()) {
                    node.add(new DefaultMutableTreeNode(file));
                }
            }
            //
        }

        tree = new JTree(treeModel);
		return tree;
		
	}
	

}
