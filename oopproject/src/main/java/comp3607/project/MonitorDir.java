package comp3607.project;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;


public class MonitorDir {

    //https://www.youtube.com/watch?v=fcNp2SsWOeM
    //The code below was taken from the link above

	public static void main(String[] args) {

        try (WatchService service = FileSystems.getDefault().newWatchService()){
        Map<WatchKey, Path> keyMap = new HashMap<>();
        
        String separator = System.getProperty("file.separator");
        Path path = Paths.get("oopproject"+ separator +"FilesToRename");

        keyMap.put(path.register(service, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,StandardWatchEventKinds.ENTRY_DELETE), path);

        WatchKey watchKey;
            do{
                watchKey = service.take();
                Path eventDir = keyMap.get(watchKey);

                for (WatchEvent event : watchKey.pollEvents()) {
                    WatchEvent.Kind kind = event.kind();
                    Path eventPath = (Path) event.context();
                    System.out.println(eventDir + ": " + kind + ": "+ eventPath);
                }

            }while(watchKey.reset());
            
        } catch (Exception e) {
            //TODO: handle exception
        }
	}
}