import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class getAllname {

	public static void main(String[] args) throws IOException 
	{
		File file = new File("./");
		File[] files = file.listFiles();
		String allname = "";
		FileOutputStream out = null;
		for (File q:files)
			allname = allname + "./" + q.getName()+";";
		byte[] b = allname.getBytes();
		File res = new File("./result.txt");
		try {
			out = new FileOutputStream(res);
			out.write(b);
			out.flush();
		} 
		catch (Exception e) 
		{
			System.out.println("Error!");
			e.printStackTrace();
		}
		finally
		{
			if (out!=null) out.close();
		}
		System.out.println("OK!");

	}

}

