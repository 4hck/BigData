package BigDatework2;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import java.io.*;
public class HDFSAPI3{
/**
* 3.读取文件内容
*/
public static void cat(Configuration conf, String remoteFilePath) throws IOException {
FileSystem fs = FileSystem.get(conf);
Path remotePath = new Path(remoteFilePath);
FSDataInputStream in = fs.open(remotePath);
BufferedReader d = new BufferedReader(new InputStreamReader(in));
String line = null;
while ( (line = d.readLine()) != null ) {
System.out.println(line);
}
d.close();
in.close();
fs.close();
}
/**
* 主函数
*/
public static void main(String[] args) {
Configuration conf = new Configuration();
conf.set("fs.default.name","hdfs://localhost:9000");
String remoteFilePath = "wyr.txt";
// HDFS 路径
try {
System.out.println("读取文件: " + remoteFilePath);
HDFSAPI3.cat(conf, remoteFilePath);
System.out.println("\n 读取完成");
} catch (Exception e) {
e.printStackTrace();
}
}
}