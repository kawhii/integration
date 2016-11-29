package com.carl.framework.core.file;

import com.carl.framework.util.UUID;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 默认的文件保存策略
 * @author Carl
 * @date 2016/11/29
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
public class DefaultFileSaveStrategy implements FileSaveStrategy {
    private String basePath = "upload-files";
    private String busiCode = "base";
    private NameGenerator nameGenerator = params -> UUID.get().toString();

    public DefaultFileSaveStrategy setBasePath(String basePath) {
        this.basePath = basePath;
        return this;
    }

    public DefaultFileSaveStrategy setBusiCode(String busiCode) {
        this.busiCode = busiCode;
        return this;
    }

    public String getBasePath() {
        return basePath;
    }


    public String getBusiCode() {
        return busiCode;
    }

    public NameGenerator getGenerator() {
        return nameGenerator;
    }

    public FileInfo save(String basePath, MultipartFile file) throws FileSaveException {
        String fileName = nameGenerator.generator()
                + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String filePath = getBasePath()+ File.separator + getBusiCode() + File.separator;
        FileInfo fileInfo = new FileInfo()
                .setFileName(fileName)
                .setFilePath(filePath + fileName)
                .setSource(file);
        try {
            File base = new File(basePath, filePath);
            if(!base.exists()) {
                base.mkdirs();
            }
            file.transferTo(new File(base, fileName));
        } catch (IOException e) {
            throw new FileSaveException(e);
        }
        return fileInfo;
    }
}
