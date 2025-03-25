package com.percyvega;

import java.io.File;

public class FileUtil {

    /**
     * This method assumes that the file has been placed in the resources folder.
     *
     * @param fileName
     * @return
     */
    public static File findFileInResources(String fileName) {
//        FileUtil.class.getResource(fileName);
        String s = FileUtil.class.getClassLoader().getResource("").getFile() + fileName;
        return new File(s);
    }

    public static File findFileInSameFolderAs(boolean isMainNotTest, String fileName, Class clazz) {
        String projectPath = System.getProperty("user.dir"); // same as new File("").getAbsoluteFile().toString() or Paths.get("").toAbsolutePath().toString()
        String folderAfterSrc = isMainNotTest ? "/src/main/java/" : "/src/test/java/";
        String classPackageFolder = clazz.getPackageName().replace(".", "/") + "/";
        String s = projectPath + folderAfterSrc + classPackageFolder + fileName;

        return new File(s);
    }

}
