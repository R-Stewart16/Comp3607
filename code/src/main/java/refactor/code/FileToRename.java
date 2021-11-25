package refactor.code;

import java.nio.file.Path;
import java.util.*;
import java.io.File;
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
    private String fileName;

    /***
     * 
     */
    public FileToRename() {
        observers = new ArrayList<Observer>();
        generatePath();
    }

    /***
     * 
     */
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(fileName, path);
        }
    }

    /***
     * Generates the path to the FilesToRename
     */
    public void generatePath(){
        String separator = System.getProperty("file.separator");
        path = Paths.get("code" + separator + "FilesToRename");
    }

    /***
     * 
     */
    public void attach(Observer o) {
        observers.add(o);
    }

    /***
     * 
     */
    public void detach(Observer o) {
        observers.remove(o);
    }

    /***
     * monitors the FilesToRename folder for any new files to rename
     */
    public void monitorDirectory() {
        initialCheck();
        try (WatchService service = FileSystems.getDefault().newWatchService()) {
            Map<WatchKey, Path> keyMap = new HashMap<>();

            keyMap.put(path.register(service, StandardWatchEventKinds.ENTRY_CREATE), path);

            WatchKey watchKey;
            do {
                watchKey = service.take();
                
                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    Path eventPath = (Path) event.context();
                    fileName = eventPath.toString();
                    if (fileName.equals("renamedFiles"))
                        continue;
                    notifyObserver();
                }
                
                

            } while (watchKey.reset());

        } catch (Exception e) {
            System.out.println("Error: Main directory not found");
        }
    }

    /***
     * Renames all files in the directory if any exists
     */
    public void initialCheck(){
        File rootfolder = new File(path.toString());
        if(rootfolder.listFiles().length != 0){
            for(File file : rootfolder.listFiles()){
                fileName = file.getName();
                if(!fileName.endsWith(".csv") && !(fileName.equals("renamedFiles"))){
                    notifyObserver();
                } 
            }  
        }  
    }



}