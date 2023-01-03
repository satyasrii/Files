import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        File files = new File("C:\\Users\\ssami\\Desktop\\Files\\report.txt");
        boolean b=files.createNewFile();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the path : ");
        String path=sc.nextLine();
        for(int i=0;i<4;i++){
            System.out.println("Enter the name of directory : ");
            String directory=sc.nextLine();
            String path1=path+directory;
            File f=new File(path1);
            boolean a = f.mkdir();
        }
        File folder = new File("C:/Users/ssami/Desktop/Files");
        File[] listOfFiles = folder.listFiles();
        String S=null;
        int i=1;
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                S = file.getPath();
                Path source = Paths.get(S);
                if(S.contains(".txt")){
                    Path temp = Files.move
                            (source, Paths.get("C:\\Users\\ssami\\Desktop\\Files\\Documents\\text file "+i+".txt"));
                    try(FileWriter fw = new FileWriter("C:\\Users\\ssami\\Desktop\\Files\\report.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw))
                    {
                        out.println("File name : text file "+i+".txt");
                        out.println("File type : .txt");
                        out.println("Assigned folder name : Documents");
                    }

                }
                else if(S.contains(".xlsx")){
                    Path temp = Files.move
                            (source, Paths.get("C:\\Users\\ssami\\Desktop\\Files\\Excel\\Excel file "+i+".xlsx"));
                    try(FileWriter fw = new FileWriter("C:\\Users\\ssami\\Desktop\\Files\\report.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw))
                    {
                        out.println("File name : Excel file "+i+".xlsx");
                        out.println("File type : .xlsx");
                        out.println("Assigned folder name : Excel");
                    }
                }
                else if(S.contains(".pptx")){
                    Path temp = Files.move
                            (source, Paths.get("C:\\Users\\ssami\\Desktop\\Files\\Powerpoint\\Powerpoint "+i+".pptx"));
                    try(FileWriter fw = new FileWriter("C:\\Users\\ssami\\Desktop\\Files\\report.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw))
                    {
                        out.println("File name : Powerpoint "+i+".pptx");
                        out.println("File type : .pptx");
                        out.println("Assigned folder name : Powerpoint");
                    }
                }
                else if(S.contains(".docx")){
                    Path temp = Files.move
                            (source, Paths.get("C:\\Users\\ssami\\Desktop\\Files\\Word\\Word"+i+".docx"));
                    try(FileWriter fw = new FileWriter("C:\\Users\\ssami\\Desktop\\Files\\report.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw))
                    {
                        out.println("File name : Word "+i+".docx");
                        out.println("File type : .docx");
                        out.println("Assigned folder name : Word");
                    }
                }
                i++;
            }
        }
    }
}
