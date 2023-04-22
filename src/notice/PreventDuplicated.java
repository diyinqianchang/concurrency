package notice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PreventDuplicated {

    private final static String LOCK_PATH = "C:\\Users\\Administrator\\Desktop\\懒人助手\\javetest\\src\\notice\\";

    private final static String LOCK_FILE = "yy.txt";

    private final static String PERMISSIONS = "rw-------";

    public static void main(String[] args) throws IOException {

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("The program received kill SIGNAL");
            getLockFile().toFile().delete();
        }));

        checkRunning();

        for (;;){
            try {
                TimeUnit.MILLISECONDS.sleep(1);
                System.out.println("program is running");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }


    }

    private static void checkRunning() throws IOException{

        Path path = getLockFile();
        if (path.toFile().exists()){
            throw new RuntimeException("The program already running");
        }
        System.out.println(path);
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString(PERMISSIONS);
        System.out.println(perms);
//        Files.createFile(path,PosixFilePermissions.asFileAttribute(perms));
        File file = new File(path.toString());

        System.out.println(file);

    }

    private static Path getLockFile(){
        return Paths.get(LOCK_PATH,LOCK_FILE);
    }

}
