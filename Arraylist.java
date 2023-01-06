import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
public class Arraylist {
    String path, path1;
    String[] Documents=new String[]{"pdf","txt"};
    String[] Video=new String[]{"mp4"};
    String[] Music=new String[]{"mp3"};
    ArrayList<String> list=new ArrayList<>();
    public static void main(String[] args)throws IOException{
        Arraylist obj=new Arraylist();
        obj.getting_files();
        obj.dividing_files();
        obj.generate_report();
    }
    public void getting_files(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the source path : ");
        path=sc.nextLine();
        File directoryPath = new File(path);
        String[] fileName = directoryPath.list();
        assert fileName != null;
        list.addAll(Arrays.asList(fileName));
        System.out.println("Files present in the source path :" + list);
    }
    public void dividing_files()throws IOException{
        for (String s : list) {
            for (String s1 : Documents) {
                if (s.contains(s1)) {
                    create_folder("Documents", s);
                    String filetype=s.substring(s.lastIndexOf('.')+1);
                    content_to_report(s,filetype,"Documents");
                }
            }
            for (String s2 : Video) {
                if (s.contains(s2)) {
                    create_folder("Video", s);
                    String filetype=s.substring(s.lastIndexOf('.')+1);
                    content_to_report(s,filetype,"Video");
                }
            }
            for (String s3 : Music) {
                if (s.contains(s3)) {
                    create_folder("Music", s);
                    String filetype=s.substring(s.lastIndexOf('.')+1);
                    content_to_report(s,filetype,"Music");
                }
            }
        }
    }
    public void create_folder(String folderName,String filename)throws IOException{
        path1 = path + "\\" + folderName;
        File f = new File(path1);
        boolean a = f.mkdir();
        String source = path + "\\" + filename;
        String destination = path1 + "\\" + filename;
        moving_files(source, destination);
    }
    public void moving_files(String source, String destination) throws IOException {
        Path temp = Files.move(Path.of(source), Path.of(destination));
    }
    public void generate_report()throws IOException{
        File files = new File(path+"\\report.txt");
        boolean b=files.createNewFile();
    }
    public void content_to_report(String filename, String filetype, String folderName)throws IOException{
        try(FileWriter fw = new FileWriter(path+"\\report.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println("File name : "+filename);
            out.println("File type : "+filetype);
            out.println("Assigned folder name : "+folderName);
        }
    }
}

