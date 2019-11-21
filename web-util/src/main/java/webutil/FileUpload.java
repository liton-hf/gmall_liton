package webutil;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

public  class FileUpload {

    public static String fileUpload(MultipartFile multipartFile){
        String trackerPath=FileUpload.class.getClassLoader().getResource("tracker.properties").getPath();
        String url = WebConstant.linuxPath;
        try {
            ClientGlobal.init(trackerPath);
            TrackerClient trackerClient=new TrackerClient();
            TrackerServer connection = trackerClient.getConnection();
            StorageClient storageClient=new StorageClient(connection,null);
            String filename = multipartFile.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));
            String[] paths = storageClient.upload_file(multipartFile.getBytes(), suffix, null);
            for (String path:paths) {
                url=url+"/"+path;
            }

        } catch (Exception e) {
            e.printStackTrace();

    }
        return url;
}
}
