import java.io.*;

public class searchInFile{
	public static void main(String[] args){
		if((args.length>1) || (args.length<1)){
			System.out.println("Too much/few input files, enter only one!");
		} else {
			String searchParameter = "";
			try{
				searchParameter = readFromConsole();
			} catch (IOException e){
				System.err.println("Can't get the search parameter! An IO ERROR accoured!");
				e.printStackTrace();
			}
			System.out.println("searching for: " + searchParameter);
			
			try{
				System.out.println("Nr. of matches: " + search(args[0], searchParameter));
			} catch (IOException e){
				System.err.println("IO ERROR");
				e.printStackTrace();
			}
		}
	}
	
	public static String readFromConsole()
	throws IOException {
		System.out.println("Set a search parameter:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp;
		tmp = br.readLine();
		return tmp;
	}
	
	public static int search(String inFileName, String searchParameter)
	throws IOException {
		File inFile = new File(inFileName);
		int nrOfMatches = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(inFile));){
			String line;
			for(line = br.readLine(); line!=null; line=br.readLine()){
				String[] thisLine = line.split(" ");
				for(int i=0; i<thisLine.length; ++i){
					if(thisLine[i].contains(searchParameter))
						++nrOfMatches;
				}
			}
		}
		return nrOfMatches;
	}
}