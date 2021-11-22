package refactor.app;


import java.nio.file.Path;
import java.util.*;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;


public class FileToRename implements FolderDirectory {
    
    private Path path;
    private ArrayList<Observer> observers;

    public FileToRename() {
        monitorDirectory();
    }

    public void notifyObserver() {
        for (Observer o : observers){
            o.update();
        }
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void monitorDirectory() {

        try (WatchService service = FileSystems.getDefault().newWatchService()){
            Map<WatchKey, Path> keyMap = new HashMap<>();
            
            String separator = System.getProperty("file.separator");
            path = Paths.get("oopproject"+ separator +"FilesToRename");
    
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

    public Path getPath() {
        return path;
    }


}